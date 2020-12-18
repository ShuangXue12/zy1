package com.example.zy1.presenter;

import com.example.zy1.base.BasePresenter;
import com.example.zy1.bean.HomeBean;
import com.example.zy1.contract.HomeContract;
import com.example.zy1.model.MainModel;
import com.example.zy1.utils.InetCallBack;
import com.example.zy1.utils.URLConstart;

public class HomePresenter extends BasePresenter<HomeContract.HomeView> implements HomeContract.MainPresenter{
    private HomeContract.HomeModel mainModel;
    private HomeContract.HomeView homeView;

    public HomePresenter(HomeContract.HomeView homeView) {
        this.homeView = homeView;
        mainModel = new MainModel(this);
    }

    @Override
    public void par() {
        mainModel.getModel(URLConstart.newUrl, new InetCallBack<HomeBean>() {
            @Override
            public void onSuccess(HomeBean homeBean) {
                iView.getHome(homeBean);
            }

            @Override
            public void onFail(String error) {
                iView.onFail(error);
            }
        });
    }
}
