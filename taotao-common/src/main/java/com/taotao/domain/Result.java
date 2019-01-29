package com.taotao.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 8027051693393821446L;

    /**
     * 错误信息
     */
    private String errorMessage;
    /**
     *z状态码
     */
    private String code;
    /**
     *数据
     */
    private T data;

    public static <T> Result<T> wrapSuccessResult(T data){
        Result<T> result = new Result<T>();
        result.code = "200";
        result.data = data;
        return result;
    }
}
