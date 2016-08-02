
#import <UIKit/UIKit.h>

@interface CDVUIWebViewDelegate+OpenBlank : NSObject <UIWebViewDelegate>{
    __weak NSObject <UIWebViewDelegate>* _delegate;
    NSInteger _loadCount;
    NSInteger _state;
    NSInteger _curLoadToken;
    NSInteger _loadStartPollCount;
}

@end
