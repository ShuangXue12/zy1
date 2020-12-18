package com.example.zy1.contract;

import com.example.zy1.base.BaseView;
import com.example.zy1.bean.HomeBean;
import com.example.zy1.utils.InetCallBack;

public class HomeContract {
    public interface HomeView extends BaseView {
        void getHome(HomeBean homeBean);

        void onFail(String error);
    }

    public interface HomeModel {
        <T> void getModel(String url, InetCallBack<T> callBack);
    }

    public interface MainPresenter {
        void par();
    }
}
