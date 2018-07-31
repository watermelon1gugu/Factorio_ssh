package com.ScuSoftware.Factorio.common.handler;


import com.ScuSoftware.Factorio.common.exception.TransactionalException;
import com.ScuSoftware.Factorio.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by kinginblue on 2017/4/10.
 * @ControllerAdvice + @ExceptionHandler 实现全局的 Controller 层的异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理所有不可知的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    Response handleException(Exception e){
        LOGGER.error(e.getMessage(), e);
        Response response = new Response();
        response.setData("操作失败！");
        return response;
    }

    /**
     * 处理所有业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(TransactionalException.class)
    @ResponseBody
    Response handleBusinessException(TransactionalException e){
        LOGGER.error(e.getMessage(), e);

        Response response = new Response();
        response.setData(e.getMessage());
        return response;
    }

    /**
     * 处理所有接口数据验证异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    Response handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        LOGGER.error(e.getMessage(), e);
        Response response = new Response();
        response.setData(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return response;
    }

}
