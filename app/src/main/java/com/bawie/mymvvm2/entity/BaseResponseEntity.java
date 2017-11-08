package com.bawie.mymvvm2.entity;


//bean基类
public class BaseResponseEntity<T> {

    public String msg;
    public String code;
    public T data;
}
