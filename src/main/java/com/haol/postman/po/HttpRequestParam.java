package com.haol.postman.po;

public class HttpRequestParam {

    private String httpType;
    private String httpUrl;
    private String httpParam;
    private String httpBody;
    private String httpHeader;


    public String getHttpType() {
        return httpType;
    }

    public void setHttpType(String httpType) {
        this.httpType = httpType;
    }

    public String getHttpUrl() {
        return httpUrl;
    }

    public void setHttpUrl(String httpUrl) {
        this.httpUrl = httpUrl;
    }

    public String getHttpParam() {
        return httpParam;
    }

    public void setHttpParam(String httpParam) {
        this.httpParam = httpParam;
    }

    public String getHttpBody() {
        return httpBody;
    }

    public void setHttpBody(String httpBody) {
        this.httpBody = httpBody;
    }

    public String getHttpHeader() {
        return httpHeader;
    }

    public void setHttpHeader(String httpHeader) {
        this.httpHeader = httpHeader;
    }
}
