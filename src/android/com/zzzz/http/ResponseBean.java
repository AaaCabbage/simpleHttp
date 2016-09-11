package com.zzzz.http;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by waynezu on 16/8/30.
 */
public class ResponseBean {
    private boolean success;
    private String data;

    @Override
    public String toString() {
        return "{success:"+success+",data:"+data+"}";
    }
    public JSONObject getObj() throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put("success",success);
        jo.put("data",data);
        return jo;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}