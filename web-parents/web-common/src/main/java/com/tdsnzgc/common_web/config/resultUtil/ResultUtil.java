package com.tdsnzgc.common_web.config.resultUtil;

public class ResultUtil<T> {
    private Result<T> result;

    public ResultUtil(){
        result = new Result<>();
        result.setSuccess(true);
        result.setMessage("success");
        result.setCode(200);
        result.setData((T) "");

    }

    public Result<T> setSuccessMsg(String msg) {
        result.setSuccess(true);
        result.setMessage(msg);
        result.setCode(200);

        return result;
    }
    public Result<T> setErrorMsg(String msg) {
        result.setSuccess(false);
        result.setMessage(msg);
        result.setCode(-1);

        return result;
    }

    public Result<T> setErrorMsg(String msg, int code) {
        result.setSuccess(false);
        result.setMessage(msg);
        result.setCode(code);

        return result;
    }

    public Result<T> setData(T t, String msg) {
        result.setSuccess(true);
        result.setMessage(msg);
        result.setCode(200);
        result.setData(t);

        return result;
    }

    public Result<T> setData(T t) {
        result.setSuccess(true);
        result.setCode(200);
        result.setData(t);

        return result;
    }
}
