package com.doanchuyennganh.ungtuyenvn.entity;

public class Test {

    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
