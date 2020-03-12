package com.oms.shared.exception;


public class Response {

    private Integer code;

    private Object message;

    private Object data;

    public Response(Integer code, Object exceptionDetail) {
        this.code = code;
        this.message = exceptionDetail;
        this.data = null;
    }

    public Response(Integer code, Object message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
