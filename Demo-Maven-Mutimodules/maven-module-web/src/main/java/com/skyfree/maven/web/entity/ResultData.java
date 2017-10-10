package com.skyfree.maven.web.entity;

import java.io.Serializable;

/**
 * Created by BFD-483 on 2017/7/3.
 */
public class ResultData<T> extends ResultInfo implements Serializable {

    private static final long serialVersionUID = 6300337442870893052L;

    private T data = null;

    public T getData() {

        return this.data;
    }

    public void setData(T data) {

        this.data = data;
    }

    public ResultData() {

    }

    public ResultData(int retcode, String retdesc) {

        super(retcode, retdesc);
    }

    public ResultData(int retcode, String retdesc, T object) {

        super(retcode, retdesc);
        this.data = object;
    }
}