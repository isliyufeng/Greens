package com.cxk.cai.entity;

/**
 * @author 喜闻乐见i
 */
public class ResultVo {
    private int code;
    private String msg;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public static ResultVo setSUCCESS(Object data) {
        ResultVo r = new ResultVo();
        r.setCode(200);
        r.setMsg("OK");
        r.setData(data);
        return r;
    }

    public static ResultVo setERROR() {
        ResultVo r = new ResultVo();
        r.setCode(400);
        r.setMsg("ERROR");
        r.setData(null);
        return r;
    }

    public static ResultVo setResult(boolean isSuccess, Object obj){
        if(isSuccess){
            return setSUCCESS(obj);
        }else {
            return setERROR();
        }
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
