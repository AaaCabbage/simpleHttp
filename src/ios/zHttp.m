//
//  zHttp.m
//  HelloWorld
//
//  Created by liu on 16/9/12.
//
//

#import "zHttp.h"
#import "AFNetworking.h"

@implementation zHttp
- (void)get:(CDVInvokedUrlCommand*)command{
    
    NSString *url =command.arguments[0];
    
    AFHTTPSessionManager *manager = [AFHTTPSessionManager manager];
    
    [manager GET:url parameters:nil progress:^(NSProgress * _Nonnull downloadProgress) {
        
    }
         success:^(NSURLSessionDataTask * _Nonnull task, id  _Nullable responseObject) {
             
             NSDictionary *jsonDict = [NSJSONSerialization JSONObjectWithData:responseObject options:NSJSONReadingMutableContainers error:nil];
             CDVPluginResult* result = [CDVPluginResult resultWithStatus: CDVCommandStatus_OK messageAsDictionary:jsonDict];
             //根据callbackId回调的id返回原生代码
             [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];
             
         }
     
         failure:^(NSURLSessionDataTask * _Nullable task, NSError * _Nonnull   error) {
             
             NSString *errorStr = [NSString stringWithFormat:@"%@",error];
             CDVPluginResult* result = [CDVPluginResult resultWithStatus: CDVCommandStatus_ERROR messageAsString:errorStr];
             //根据callbackId回调的id返回原生代码
             [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];
             
         }];
   
 
}
- (void)post:(CDVInvokedUrlCommand*)command{
    
    NSString *url =command.arguments[0];
    NSString *param =command.arguments[1];
    
    AFHTTPSessionManager *manager = [AFHTTPSessionManager manager];
    
   
    [manager POST:url parameters:param progress:^(NSProgress * _Nonnull uploadProgress) {
      
        
    } success:^(NSURLSessionDataTask * _Nonnull task, id  _Nullable responseObject) {
        
        NSDictionary *jsonDict = [NSJSONSerialization JSONObjectWithData:responseObject options:NSJSONReadingMutableContainers error:nil];
        CDVPluginResult* result = [CDVPluginResult resultWithStatus: CDVCommandStatus_OK messageAsDictionary:jsonDict];
        //根据callbackId回调的id返回原生代码
        [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];
        
    } failure:^(NSURLSessionDataTask * _Nullable task, NSError * _Nonnull error) {
     
        NSString *errorStr = [NSString stringWithFormat:@"%@",error];
        CDVPluginResult* result = [CDVPluginResult resultWithStatus: CDVCommandStatus_ERROR messageAsString:errorStr];
        //根据callbackId回调的id返回原生代码
        [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];
    }];
}
@end
