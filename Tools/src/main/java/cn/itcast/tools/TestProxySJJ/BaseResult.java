package cn.itcast.tools.TestProxySJJ;

import java.util.Map;

public class BaseResult<T> {
    private Integer retCode;
    private String message;
    private T retValue;
    private Map<String,Object>  extentions;
    private boolean success;
    private String traceId;

    public BaseResult(){
        this.retCode=200;
        this.success=true;
    }

    public BaseResult(Integer retCode,String retMsg){
        this.retCode=200;
        this.success=true;
        this.success=false;
        this.retCode=retCode;
        this.message=retMsg;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getRetValue() {
        return retValue;
    }

    public void setRetValue(T retValue) {
        this.retValue = retValue;
    }

    public Map<String, Object> getExtentions() {
        return extentions;
    }

    public void setExtentions(Map<String, Object> extentions) {
        this.extentions = extentions;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
