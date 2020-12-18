package com.example.zy1.utils;

public interface InetCallBack<T> {
    void onSuccess(T t);

    void onFail(String error);
}
