package com.dengshen.blog.Actions;

public class ActionResult {
    private boolean success;
    private String msg;
    private Object data;
    private Integer code;


    public ActionResult() {
    }

    public ActionResult(boolean success) {
        this(success, null, null);
    }

    public ActionResult(boolean success, String msg) {
        this(success, msg, null);
    }

    public ActionResult(boolean success, String msg, Object data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
