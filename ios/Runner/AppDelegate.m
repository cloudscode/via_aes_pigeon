#include "AppDelegate.h"
#include "GeneratedPluginRegistrant.h"

@implementation AppDelegate

- (BOOL)application:(UIApplication *)application
    didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
  [GeneratedPluginRegistrant registerWithRegistry:self];
  // Override point for customization after application launch.
  FlutterViewController* controller =
      (FlutterViewController*)self.window.rootViewController;
  ApiSetup(controller.binaryMessenger, self);
  return [super application:application didFinishLaunchingWithOptions:launchOptions];
}


-(SearchReply *)search:(SearchRequest*)input error:(FlutterError **)error {
    SearchReply* result = [[SearchReply alloc] init];
    result.result  = [NSString stringWithFormat:@"%s%@","Hi ",input.query];
    return result;
}


@end
