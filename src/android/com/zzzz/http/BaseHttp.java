package com.zzzz;

import android.content.Context;
import java.io.File;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by waynezu on 16/8/30.
 */
public abstract class BaseHttp{
    public static final String SERVICE = "";//TODO fill address
    private static Retrofit mRetrofit;
    protected static Retrofit getmRetrofit() {
        if (mRetrofit == null) {
            Context context = MyApplication.getInstance().getApplicationContext();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(30, TimeUnit.SECONDS);
            builder.cookieJar(new CookiesManager());
            File cacheDir = new File(context.getCacheDir().getAbsolutePath(),"HttpCache");
            Cache cache = new Cache(cacheDir,2*1024*1024);
            builder.cache(cache);
//            builder.addInterceptor(new MyInterceptor());
            OkHttpClient mOkHttpClient = builder.build();
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(SERVICE + "/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(mOkHttpClient)
                    .build();
        }
        return mRetrofit;
    }
}