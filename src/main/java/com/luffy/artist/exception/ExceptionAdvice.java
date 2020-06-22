package com.luffy.artist.exception;

import com.luffy.artist.enums.ErrorCode;
import com.luffy.artist.vo.Result;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常通知类
 * @author Peng xue-tao
 * @since 2020/6/22
 */
@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return new Result<>(ErrorCode.ERROR_10000.getCode(), objectError.getDefaultMessage(), ErrorCode.ERROR_10000.getErrorDesc());
    }
}
