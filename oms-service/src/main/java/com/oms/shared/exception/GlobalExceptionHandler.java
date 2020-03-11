package com.oms.shared.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 参数异常统一处理
     */
    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    protected ExceptionResponse handleMethodArgumentNotValidException(HttpServletRequest request, Exception exception) {

        // 异常信息
        List<ObjectError> allErrors;
        if (exception instanceof BindException) {
            allErrors = ((BindException) exception).getAllErrors();
        } else if (exception instanceof MethodArgumentNotValidException) {
            allErrors = ((MethodArgumentNotValidException) exception).getBindingResult().getAllErrors();
        } else {
            allErrors = new ArrayList<>();
        }
        StringBuilder err = new StringBuilder();
        for (ObjectError objectError : allErrors) {
            err.append(objectError.getDefaultMessage());
            err.append(";");
        }

        return new ExceptionResponse(BaseErrorCode.ILLEGAL_ARGUMENT_EXCEPTION.getCode(), err);
    }

    /**
     * SQL异常统一处理
     */
    @ExceptionHandler({SQLException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    protected ExceptionResponse handleSQLExceptionHandler(HttpServletRequest request, SQLException exception) {
        String message = exception.getMessage();
        ;
        return new ExceptionResponse(BaseErrorCode.SQL_EXCEPTION.getCode(), BaseErrorCode.SQL_EXCEPTION.getMessage());
    }


    /**
     * 非法参数异常统一处理
     */
    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    protected ExceptionResponse handleIllegalArgumentException(HttpServletRequest request, IllegalArgumentException exception) {
        String message = exception.getMessage();
        return new ExceptionResponse(BaseErrorCode.ILLEGAL_ARGUMENT_EXCEPTION.getCode(), BaseErrorCode.ILLEGAL_ARGUMENT_EXCEPTION.getMessage());
    }

    /**
     * 非法参数异常统一处理
     */
    @ExceptionHandler({InvalidFormatException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    protected ExceptionResponse handleInvalidFormatException(HttpServletRequest request, InvalidFormatException exception) {
        String message = exception.getMessage();
        return new ExceptionResponse(BaseErrorCode.ILLEGAL_ARGUMENT_EXCEPTION.getCode(), BaseErrorCode.ILLEGAL_ARGUMENT_EXCEPTION.getMessage());
    }

    /**
     * 业务异常统一处理
     */
    @ExceptionHandler({BusinessException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    protected ExceptionResponse handleBusinessException(HttpServletRequest request, BusinessException exception) {
        return new ExceptionResponse(exception.getCode(), exception.getMessage());
    }

    /**
     * 统一异常处理
     */
    @ExceptionHandler({Exception.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    protected ExceptionResponse handleOtherException(HttpServletRequest request, Exception exception) {
        String message = exception.getMessage();
        if (exception instanceof HttpMessageNotReadableException) {
            return new ExceptionResponse(BaseErrorCode.FORMAT_PARSE_EXCEPTION.getCode(), BaseErrorCode.FORMAT_PARSE_EXCEPTION.getMessage());
        } else if (exception instanceof HttpRequestMethodNotSupportedException) {
            return new ExceptionResponse(BaseErrorCode.METHOD_NOT_SUPPORT_EXCEPTION.getCode(), BaseErrorCode.METHOD_NOT_SUPPORT_EXCEPTION.getMessage());
        } else if (exception instanceof NoHandlerFoundException) {
            return new ExceptionResponse(BaseErrorCode.HANDLER_NOT_FOUND_EXCEPTION.getCode(), BaseErrorCode.HANDLER_NOT_FOUND_EXCEPTION.getMessage());
        } else {
            return new ExceptionResponse(BaseErrorCode.EXCEPTION.getCode(), BaseErrorCode.EXCEPTION.getMessage());
        }

    }
}
