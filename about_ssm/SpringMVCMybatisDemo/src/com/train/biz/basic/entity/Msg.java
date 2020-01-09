package com.train.biz.basic.entity;

import java.util.HashMap;
import java.util.Map;


/*
 * 返回通用的值
 * */
public class Msg {

//    状态码 100：成功  200：失败
    private int code;
//    提示信息
    private  String msg;

    private Map<String, Object> extend= new HashMap<String,Object>();

    public static Msg seccess(){
        Msg result = new Msg();
        result.setCode(100);
        result.setMsg("处理成功");
        return result;
    }


    public static Msg fali(){
        Msg result2 = new Msg();
        result2.setCode(200);
        result2.setMsg("处理失败");
        return result2;
    }




    public Msg add(String key,Object Value){
        this.getExtend().put(key, Value);
        return this;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
