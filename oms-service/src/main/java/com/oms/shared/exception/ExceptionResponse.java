package com.oms.shared.exception;


public class ExceptionResponse {

    private Integer code;

    private Object message;

    private Object data;

    public ExceptionResponse(Integer code, Object exceptionDetail) {
        this.code = code;
        this.message = exceptionDetail;
    }

    @Override
    public String toString() {
        return "ExceptionResponse{" +
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
