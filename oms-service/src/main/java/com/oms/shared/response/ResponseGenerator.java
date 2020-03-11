package com.oms.shared.response;


public class ResponseGenerator {

    private static final String DEFAULT_SUCCESS_MESSAGE = "Success";

    public static <T> Response<T> genSuccess() {
        return new Response<T>()
                .setCode(ResponseCode.SUCCESS.code())
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Response<T> genSuccess(T data) {
        return new Response<T>()
                .setCode(ResponseCode.SUCCESS.code())
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }


    public static <T> Response<T> genParameterError(String message) {
        return new Response<T>()
                .setCode(ResponseCode.PARAM_ERROR.code())
                .setMessage(message)
                .setData(null);
    }

    public static <T> Response<T> genFail(String message) {
        return new Response<T>()
                .setCode(ResponseCode.FAIL.code())
                .setMessage(message);
    }

    public static <T> Response<T> genFail(int code, String message) {
        return new Response<T>()
                .setCode(code)
                .setMessage(message)
                .setData(null);
    }

    public static <T> Response<T> genFail(int code, String message, T data) {
        return new Response<T>()
                .setCode(code)
                .setMessage(message)
                .setData(data);
    }

}