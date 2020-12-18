package com.example.zy1.model;

import com.example.zy1.contract.HomeContract;
import com.example.zy1.utils.InetCallBack;
import com.example.zy1.utils.RetrofitUtils;

public class MainModel implements HomeContract.HomeModel {
    private HomeContract.MainPresenter presenter;

    public MainModel(HomeContract.MainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void getModel(String url, InetCallBack<T> callBack) {
        RetrofitUtils.getRetrofitUtils().get(url,callBack);
    }
}
