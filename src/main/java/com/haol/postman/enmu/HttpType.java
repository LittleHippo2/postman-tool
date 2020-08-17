package com.haol.postman.enmu;

public enum HttpType {

    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE");

    private String name;

    HttpType(String name) {
        this.name = name;
    }


    public static HttpType getByName(String name) {
        for (HttpType transactType : values()) {
            if (transactType.getName().equals(name)) {
                //获取指定的枚举
                return transactType;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}