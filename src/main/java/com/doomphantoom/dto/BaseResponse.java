package com.doomphantoom.dto;

/**
 * Created by doomphantom on 23/10/2015.
 */
public class BaseResponse<T> {
    private String resultCode;
    private String resultDescription;
    private T body;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
