simple-cordova-HTTP
==================

Cordova / Phonegap plugin for communicating with HTTP servers.  Supports  Android. use RxAndroid OkHttp Retrofit.Supports  iOS. use AFNetWorking 3.0.

## Usage

``` 
cordova plugin add https://github.com/AaaCabbage/simpleHttp.git
```

## Android

```
In your build.gradle dependencies add
    compile 'com.squareup.okhttp3:okhttp:3.4.1'
    compile 'com.squareup.okio:okio:1.9.0'
    compile 'io.reactivex:rxjava:1.1.9'
    compile 'io.reactivex:rxandroid:1.2.1'
    compile 'com.squareup.retrofit2:retrofit:2.1.0'
    compile 'com.squareup.retrofit2:adapter-rxjava:2.1.0'
```