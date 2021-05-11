package com.example.demo01.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ResultUtils<T> {

    private String code;
    private String msg;
    private T data;
    public static ResultUtils error(String code, String msg){return new ResultUtils(code,msg,null);}
    //检验密码和用户名是否合规
    public static ResultUtils test(String msg){return new ResultUtils(null,msg,null);}
    public static ResultUtils pass(String msg, Object data){return new ResultUtils("200",msg,data);}


}
