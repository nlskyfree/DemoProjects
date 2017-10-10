package com.skyfree.maven.web.control;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skyfree.maven.common.utils.GyUtils;
import com.skyfree.maven.web.entity.ResultConstant;
import com.skyfree.maven.web.entity.ResultData;

/**
 * @project 知识图谱
 * @file BaseController.java 创建时间:2017年7月6日上午11:49:32
 * @description 返回结果包装类与统一异常处理类（简要描述类的职责、实现方式、使用注意事项等）
 * @author 倪路
 * @version 1.0
 *
 */
public abstract class BaseControl {

    private final static Logger logger = LoggerFactory.getLogger(BaseControl.class);

    /**
     * @description 统一异常处理器(不捕获Error)
     * @time 创建时间:2017年7月6日下午12:24:25
     * @param excp 异常信息
     * @return ResultData<Object>
     * @author 倪路
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultData<Object> exceptionHandler(HttpServletRequest req, Exception excp) {
        String stackTrace = ExceptionUtils.getStackTrace(excp);
        logger.error("request: {} raised {}", req.getRequestURL(), stackTrace);
        String message = GyUtils.isNull(excp.getMessage()) ? ResultConstant.SYS_ERROR_DESC : excp.getMessage();
        return new ResultData<Object>(ResultConstant.SYS_ERROR_CODE, message, null);
    }

    /**
     * @description 业务调用成功，返回200
     * @time 创建时间:2017年7月6日下午12:25:58
     * @param data 数据
     * @return
     * @author 倪路
     */
    public ResultData<Object> success() {
        return new ResultData<Object>(ResultConstant.OK_CODE, ResultConstant.OK_DESC, null);
    }

    /**
     * @description 业务调用成功，返回200
     * @time 创建时间:2017年7月6日下午12:25:58
     * @param data 数据
     * @return
     * @author 倪路
     */
    public ResultData<Object> success(String message) {
        return new ResultData<Object>(ResultConstant.OK_CODE, message, null);
    }

    /**
     * @description 业务调用成功，返回200
     * @time 创建时间:2017年7月6日下午12:25:58
     * @param data 数据
     * @return
     * @author 倪路
     */
    public ResultData<Object> success(Object data) {
        return new ResultData<Object>(ResultConstant.OK_CODE, ResultConstant.OK_DESC, data);
    }

    /**
     * @description 业务调用成功，返回200，和自定义message
     * @time 创建时间:2017年7月6日下午12:25:58
     * @param data 数据
     * @param message 业务消息
     * @return
     * @author 倪路
     */
    public ResultData<Object> success(Object data, String message) {
        return new ResultData<Object>(ResultConstant.OK_CODE, message, data);
    }

    /**
     * @description 参数异常返回400
     * @time 创建时间:2017年7月6日下午12:28:50
     * @return
     * @author 倪路
     */
    public ResultData<Object> paramsError() {
        return new ResultData<Object>(ResultConstant.PARAM_ERROR_CODE, ResultConstant.PARAM_ERROR_DESC, null);
    }

    /**
     * @description 参数异常，返回400和自定义消息
     * @time 创建时间:2017年7月6日下午12:32:26
     * @param message
     * @return
     * @author 倪路
     */
    public ResultData<Object> paramsError(String message) {
        return new ResultData<Object>(ResultConstant.PARAM_ERROR_CODE, message, null);
    }

    /**
     * @description 参数异常返回400与特定数据
     * @time 创建时间:2017年7月6日下午12:32:39
     * @param data
     * @return
     * @author 倪路
     */
    public ResultData<Object> paramsError(Object data) {
        return new ResultData<Object>(ResultConstant.PARAM_ERROR_CODE, ResultConstant.PARAM_ERROR_DESC, data);
    }

    /**
     * @description 参数异常返回400与消息与特定数据
     * @time 创建时间:2017年7月6日下午12:32:39
     * @param data
     * @return
     * @author 倪路
     */
    public ResultData<Object> paramsError(Object data, String message) {
        return new ResultData<Object>(ResultConstant.PARAM_ERROR_CODE, message, data);
    }
}
