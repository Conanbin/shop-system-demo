package com.cosmax.shop.system.commons.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: media-system
 * @description: 数据传递返回实体
 * @author: Cosmax
 * @create: 2020/02/01 17:36
 */

@Builder
@Data
public class BaseResult implements Serializable {
    private static final long serialVersionUID = 3468352004150968551L;

    public static final int code_SUCCESS = 200;
    public static final int code_FAIL = 500;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回对象
     */
    private Object data;


    public static BaseResult success(){
        return BaseResult.createResult(code_SUCCESS,"成功",null);
    }

    public static BaseResult success(int code, String message, Object object){
        return BaseResult.createResult(code,message,object);
    }

    public static BaseResult success(String message){
        return BaseResult.createResult(code_SUCCESS, message,null);
    }

    public static BaseResult success(String message,Object data){
        return BaseResult.createResult(code_SUCCESS, message,data);
    }

    public static BaseResult fail(){
        return createResult(code_FAIL,"失败",null);
    }

    public static BaseResult fail(String message){
        return createResult(code_FAIL,message,null);
    }

    public static BaseResult fail(String message,Object data){
        return createResult(code_FAIL,message,data);
    }

    public static BaseResult fail(int code, String message,Object data){
        return createResult(code,message,data);
    }

    private static BaseResult createResult(int code, String message, Object data){
        return new BaseResult(code, message, data);
    }
    public static class STATECODE{

        public final static int OK = 20000;
        // 熔断
        public final static int BREAKTIME = 20002;
        public final static int ERROR = 50000;
        public final static int Illegal_TOKEN = 50008;
        public final static int OTHER_CLIENT_LOG_IN = 50012;
        public final static int TOKEN_EXPIRED = 50014;

    }
}
