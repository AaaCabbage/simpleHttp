package com.zzzz;

import com.zzzz.http.ResponseBean;
import com.zzzz.http.BaseHttp;
import java.util.Map;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;
/**
 * Created by waynezu on 16/8/30.
 */
public class HttpPost extends BaseHttp{
    private interface HttpService{
        @FormUrlEncoded
        @POST("{path}")
        Observable<ResponseBean> getData(@Path("path") String path, @FieldMap Map<String,String> map);
    }
    protected static final HttpService service = getmRetrofit().create(HttpService.class);
    public static Observable<ResponseBean> getData(String path,Map<String,String>map){
        return service.getData(path,map);
    }
}