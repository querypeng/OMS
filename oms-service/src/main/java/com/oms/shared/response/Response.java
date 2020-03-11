package com.oms.shared.response;

import com.alibaba.fastjson.JSON;

/**
 * @author leon
 * Email: zoul@sce-re.com
 * Date: 2018-9-5
 */

public class Response<T> {
    private int code;
    private String message;
    private T data;


    public int getCode() {
        return code;
    }

    public Response<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Response<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Response<T> setData(T data) {
        this.data = data;
        return this;
    }

    public boolean isSuccess() {
        return this.getCode() == 200;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
