package com.example.zy1.utils;

public interface InetWorkInterface {
    <T> void get(String url, InetCallBack<T> callBack);
}
