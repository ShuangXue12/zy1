package com.example.zy1.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    public P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayouID());
        if (presenter == null) {
            presenter = getPresenter();
            presenter.addachView(this);
        }
        initView();
        initData();
    }

    protected abstract int getLayouID();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P getPresenter();
}
