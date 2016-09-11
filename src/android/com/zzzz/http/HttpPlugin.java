package com.zzzz;

import com.google.gson.Gson;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.zzzz.http.HttpPost;
import com.zzzz.http.HttpGet;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by waynezu on 16/8/30.
 */
 public class HttpPlugin extends CordovaPlugin{
      @Override
    public boolean execute(final String action,final JSONArray args,final CallbackContext callbackContext) throws JSONException {
        switch (action){
            case "post":
                try {
                JSONObject jo= args.getJSONObject(1);
                String path = args.getString(0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                threadhelper(new execG() {
                    @Override
                    public void run(JSONArray jsonArray) {
                        PostRequest(path,jo,callbackContext);
                    }
                },args);
                return true;
            case "get":
                try {
                String path = args.getString(0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                threadhelper(new execG() {
                    @Override
                    public void run(JSONArray jsonArray) {
                        GetRequest(path,callbackContext);
                    }
                },args);
                return true;
        }
    }
    private interface execG{
        void run(JSONArray jsonArray);
    }

    private void threadhelper (final execG g,final JSONArray args){
        cordova.getThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                g.run(args);
            }
        });

    }

    private Map<String,String> getMap(JSONObject jo){
        Map<String,String> map = new TreeMap<>();
        for(Iterator it = jo.keys(); it.hasNext();){
            String key = (String) it.next();
            map.put(key,jo.getString(key));
        }
        return map;
    }

    private void PostRequest(String path,JSONArray arg,final CallbackContext callbackContext){
        HttpPost.getData(path,getMap(arg))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callbackContext.error(e.toString());
                    }

                    @Override
                    public void onNext(ResponseBean responseBean) {
                        try {
                            callbackContext.success(responseBean.getObj());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void GetRequest(String path,final CallbackContext callbackContext){
        HttpGet.getData(path)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callbackContext.error(e.toString());
                    }

                    @Override
                    public void onNext(ResponseBean responseBean) {
                        try {
                            callbackContext.success(responseBean.getObj());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
 }