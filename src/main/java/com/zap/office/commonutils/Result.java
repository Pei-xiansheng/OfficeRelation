package com.zap.office.commonutils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ZhuApeng
 * @Title: Result
 * @ProjectName: OfficeRelation
 * @Description: 统一返回结果
 * @date: 2021/10/14 13:21
 */

@Data
public class Result {
    private Integer code;
    private String msg;
    private Boolean success;
    private Map<String,Object> data = new HashMap<>();

    private Result(){}

    //成功
    public static Result ok(){
        Result r = new Result();
        r.setCode(ResultStatus.success);
        r.setMsg("成功！");
        r.setSuccess(true);
        return r;
    }

    //失败
    public static Result error(){
        Result r = new Result();
        r.setCode(ResultStatus.error);
        r.setMsg("失败！");
        r.setSuccess(false);
        return r;
    }

    public Result success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public Result code(Integer code){
        this.setCode(code);
        return this;
    }

    public Result msg(String msg){
        this.setMsg(msg);
        return this;
    }

    public Result map(Map map){
        this.setData(map);
        return this;
    }

    public Result data(String key,Object value){
        this.data.put(key,value);
        return this;
    }
}
