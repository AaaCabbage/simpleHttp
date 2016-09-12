//
//  zHttp.h
//  HelloWorld
//
//  Created by liu on 16/9/12.
//
//

#import <Cordova/CDVPlugin.h>

@interface zHttp : CDVPlugin
- (void)get:(CDVInvokedUrlCommand*)command;
- (void)post:(CDVInvokedUrlCommand*)command;
@end
