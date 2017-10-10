package com.skyfree.maven.web.entity;

/**
 * Created by BFD-483 on 2017/7/3.
 */
public class ResultConstant {
    public static final String RET_CODE = "retCode";

    public static final String RET_DESC = "retDesc";

    public static final int OK_CODE = 200;
    public static final String OK_DESC = "msg_success";

    public static final int PARAM_ERROR_CODE = 400;
    public static final String PARAM_ERROR_DESC = "msg_err_paramError";

    public static final int UN_AHTHORIZED_ERROR_CODE = 401;
    public static final String UN_AHTHORIZED__ERROR_DESC = "请求未认证";

    public static final int UN_AUTHEN_ERROR_CODE = 406;
    public static final String UN_AUTHEN__ERROR_DESC = "请求未授权";

    public static final int SYS_ERROR_CODE = 500;
    public static final String SYS_ERROR_DESC = "msg_err_systemError";

}
