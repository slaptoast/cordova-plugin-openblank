
// #import <UIKit/UIKit.h>

// @interface CDVUIWebViewDelegate : NSObject <UIWebViewDelegate>{
//     __weak NSObject <UIWebViewDelegate>* _delegate;
//     NSInteger _loadCount;
//     NSInteger _state;
//     NSInteger _curLoadToken;
//     NSInteger _loadStartPollCount;
// }

// @end
#import <Cordova/CDVIntentAndNavigationFilter.h>
#import <Cordova/CDV.h>

@interface CDVIntentAndNavigationFilter (OpenBlank)

@property (nonatomic, readwrite) NSMutableArray* allowIntents;
@property (nonatomic, readwrite) NSMutableArray* allowNavigations;
@property (nonatomic, readwrite) CDVWhitelist* allowIntentsWhitelist;
@property (nonatomic, readwrite) CDVWhitelist* allowNavigationsWhitelist;

@end

