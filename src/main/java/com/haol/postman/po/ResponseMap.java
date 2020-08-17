package com.haol.postman.po;

public class ResponseMap {

    public ResponseMap(Object data) {
        Data = data;
    }

    private Object Data;

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }
}
