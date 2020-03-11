package com.oms.shared.exception;

import lombok.Data;


@Data
public class BusinessException extends RuntimeException {

    private Integer code;

    public BusinessException(final BaseErrorCode baseErrorCode) {
        super(baseErrorCode.getMessage());
        this.code = baseErrorCode.getCode();
    }

    public BusinessException(final int errorCode, final String message) {
        super(message);
        this.code = errorCode;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
