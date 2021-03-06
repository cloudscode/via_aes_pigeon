// Autogenerated from Pigeon (v0.1.4), do not edit directly.
// See also: https://pub.dev/packages/pigeon
#import "pigeon.h"
#import <Flutter/Flutter.h>

#if !__has_feature(objc_arc)
#error File requires ARC to be enabled.
#endif

static NSDictionary* wrapResult(NSDictionary *result, FlutterError *error) {
  NSDictionary *errorDict = (NSDictionary *)[NSNull null];
  if (error) {
    errorDict = [NSDictionary dictionaryWithObjectsAndKeys:
        (error.code ? error.code : [NSNull null]), @"code",
        (error.message ? error.message : [NSNull null]), @"message",
        (error.details ? error.details : [NSNull null]), @"details",
        nil];
  }
  return [NSDictionary dictionaryWithObjectsAndKeys:
      (result ? result : [NSNull null]), @"result",
      errorDict, @"error",
      nil];
}

@interface ViaAesReply ()
+(ViaAesReply*)fromMap:(NSDictionary*)dict;
-(NSDictionary*)toMap;
@end
@interface ViaAesRequest ()
+(ViaAesRequest*)fromMap:(NSDictionary*)dict;
-(NSDictionary*)toMap;
@end

@implementation ViaAesReply
+(ViaAesReply*)fromMap:(NSDictionary*)dict {
  ViaAesReply* result = [[ViaAesReply alloc] init];
  result.result = dict[@"result"];
  if ((NSNull *)result.result == [NSNull null]) {
    result.result = nil;
  }
  return result;
}
-(NSDictionary*)toMap {
  return [NSDictionary dictionaryWithObjectsAndKeys:(self.result ? self.result : [NSNull null]), @"result", nil];
}
@end

@implementation ViaAesRequest
+(ViaAesRequest*)fromMap:(NSDictionary*)dict {
  ViaAesRequest* result = [[ViaAesRequest alloc] init];
  result.data = dict[@"data"];
  if ((NSNull *)result.data == [NSNull null]) {
    result.data = nil;
  }
  result.key = dict[@"key"];
  if ((NSNull *)result.key == [NSNull null]) {
    result.key = nil;
  }
  result.iv = dict[@"iv"];
  if ((NSNull *)result.iv == [NSNull null]) {
    result.iv = nil;
  }
  return result;
}
-(NSDictionary*)toMap {
  return [NSDictionary dictionaryWithObjectsAndKeys:(self.data ? self.data : [NSNull null]), @"data", (self.key ? self.key : [NSNull null]), @"key", (self.iv ? self.iv : [NSNull null]), @"iv", nil];
}
@end

void ViaAesApiSetup(id<FlutterBinaryMessenger> binaryMessenger, id<ViaAesApi> api) {
  {
    FlutterBasicMessageChannel *channel =
      [FlutterBasicMessageChannel
        messageChannelWithName:@"dev.flutter.pigeon.ViaAesApi.encrypt"
        binaryMessenger:binaryMessenger];
    if (api) {
      [channel setMessageHandler:^(id _Nullable message, FlutterReply callback) {
        FlutterError *error;
        ViaAesRequest *input = [ViaAesRequest fromMap:message];
        ViaAesReply *output = [api encrypt:input error:&error];
        callback(wrapResult([output toMap], error));
      }];
    }
    else {
      [channel setMessageHandler:nil];
    }
  }
  {
    FlutterBasicMessageChannel *channel =
      [FlutterBasicMessageChannel
        messageChannelWithName:@"dev.flutter.pigeon.ViaAesApi.decrypt"
        binaryMessenger:binaryMessenger];
    if (api) {
      [channel setMessageHandler:^(id _Nullable message, FlutterReply callback) {
        FlutterError *error;
        ViaAesRequest *input = [ViaAesRequest fromMap:message];
        ViaAesReply *output = [api decrypt:input error:&error];
        callback(wrapResult([output toMap], error));
      }];
    }
    else {
      [channel setMessageHandler:nil];
    }
  }
}
