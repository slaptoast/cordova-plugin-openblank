/*
 Licensed to the Apache Software Foundation (ASF) under one
 or more contributor license agreements.  See the NOTICE file
 distributed with this work for additional information
 regarding copyright ownership.  The ASF licenses this file
 to you under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License.  You may obtain a copy of the License at
 
 http://www.apache.org/licenses/LICENSE-2.0
 
 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 */

#import "CDVIntentAndNavigationFilter+OpenBlank.h"
#import <Cordova/CDVIntentAndNavigationFilter.h>
#import <Cordova/CDV.h>

@implementation CDVIntentAndNavigationFilter (OpenBlank)
- (BOOL)shouldOverrideLoadWithRequest:(NSURLRequest*)request navigationType:(UIWebViewNavigationType)navigationType
{
    NSString* allowIntents_whitelistRejectionFormatString = @"ERROR External navigation rejected - <allow-intent> not set for url='%@'";
    NSString* allowNavigations_whitelistRejectionFormatString = @"ERROR Internal navigation rejected - <allow-navigation> not set for url='%@'";
    
    NSURL* url = [request URL];
    BOOL allowNavigationsPass = NO;
    NSMutableArray* errorLogs = [NSMutableArray array];
    
    switch (navigationType) {
        case UIWebViewNavigationTypeLinkClicked:
            // Note that the rejection strings will *only* print if
            // it's a link click (and url is not whitelisted by <allow-*>)
            if ([self.allowIntentsWhitelist URLIsAllowed:url logFailure:NO]) {
                // the url *is* in a <allow-intent> tag, push to the system
                [[UIApplication sharedApplication] openURL:url];
                return YES;
            } else {
                [[UIApplication sharedApplication] openURL:url];
                [errorLogs addObject:[NSString stringWithFormat:allowIntents_whitelistRejectionFormatString, [url absoluteString]]];
            }
            // fall through, to check whether you can load this in the webview
        default:
            // check whether we can internally navigate to this url
            allowNavigationsPass = [self.allowNavigationsWhitelist URLIsAllowed:url logFailure:NO];
            // log all failures only when this last filter fails
            if (!allowNavigationsPass){
                [errorLogs addObject:[NSString stringWithFormat:allowNavigations_whitelistRejectionFormatString, [url absoluteString]]];

                // this is the last filter and it failed, now print out all previous error logs
                for (NSString* errorLog in errorLogs) {
                    NSLog(@"%@", errorLog);
                }
            }
            
            return allowNavigationsPass;
    }
}

@end
