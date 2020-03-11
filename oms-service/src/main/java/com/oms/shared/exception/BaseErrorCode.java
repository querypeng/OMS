package com.oms.shared.exception;


public enum BaseErrorCode {

    //
    EXCEPTION(6400, "不可描述的异常"),
    SQL_EXCEPTION(6401, "SQL异常"),
    ILLEGAL_ARGUMENT_EXCEPTION(6402, "非法参数异常"),
    LOCK_EXCEPTION(6403, "重复操作"),
    FORMAT_PARSE_EXCEPTION(6405, "格式转换异常"),
    METHOD_NOT_SUPPORT_EXCEPTION(6406, "请求方式非法异常"),
    HANDLER_NOT_FOUND_EXCEPTION(6406, "接口未找到"),

    ILLEGAL_PARAM(62602001, "非法入参"),

    ERROR_APPLICATION(42501999, "系统异常！");

    private Integer code;

    private String message;

    BaseErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
