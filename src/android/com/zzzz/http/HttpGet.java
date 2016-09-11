package com.zzzz;

import com.zzzz.http.ResponseBean;
import com.zzzz.http.BaseHttp;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;
/**
 * Created by waynezu on 16/8/30.
 */
public class HttpGet extends BaseHttp{
    private interface HttpService{
        @FormUrlEncoded
        @GET("{path}")
        Observable<ResponseBean> getData(@Path("path") String path);
    }
    protected static final HttpService service = getmRetrofit().create(HttpService.class);
    public static Observable<ResponseBean> getData(String path){
        return service.getData(path);
    }
}