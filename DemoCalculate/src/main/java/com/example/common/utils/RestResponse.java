package com.example.common.utils;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class RestResponse extends HashMap<String,Object> {

    private static final long serialVersionUID = 1L;

    public RestResponse(){
        put("code",0);
        put("msg","success");
    }

    public static RestResponse error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
    }

    public static RestResponse error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static RestResponse error(int code,String msg){
        RestResponse restResponse = new RestResponse();
        restResponse.put("code",code);
        restResponse.put("msg",msg);
        return restResponse;
    }
    public static RestResponse success(String msg) {
        RestResponse restResponse = new RestResponse();
        restResponse.put("msg", msg);
        return restResponse;
    }
    public static RestResponse success(int code, String msg) {
        RestResponse restResponse = new RestResponse();
        restResponse.put("code", code);
        restResponse.put("msg", msg);
        return restResponse;
    }
    public static RestResponse success(Map<String, Object> map) {
        RestResponse restResponse = new RestResponse();
        restResponse.putAll(map);
        return restResponse;
    }

    public static RestResponse success(int code, String msg, Map<String, Object> map) {
        RestResponse restResponse = new RestResponse();
        restResponse.put("code", code);
        restResponse.put("msg", msg);
        restResponse.putAll(map);
        return restResponse;
    }

    @Override
    public RestResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
