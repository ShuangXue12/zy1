package com.example.zy1.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zy1.R;
import com.example.zy1.adapter.HomeAdapter;
import com.example.zy1.base.BaseActivity;
import com.example.zy1.bean.HomeBean;
import com.example.zy1.contract.HomeContract;
import com.example.zy1.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * base:
 * <p>
 * 1.M:extends  Contract.M
 * 2.V:extends BaseActivity<Presenter> implements Contract.v
 * 3.P:extends P<Contract.v> implements Contract.P
 */
public class MainActivity extends BaseActivity<HomePresenter> implements HomeContract.HomeView {

    private RecyclerView recycler;
    private HomeAdapter homeAdapter;
    private ArrayList<HomeBean.NewsBean> list;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    @Override
    protected int getLayouID() {
        return R.layout.activity_main;
    }



    @Override
    protected void initData() {
        presenter.par();
    }

    protected void initView() {
        recycler = (RecyclerView) findViewById(R.id.recycler);

        list = new ArrayList<>();
        homeAdapter = new HomeAdapter(this,list);
        recycler.setAdapter(homeAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    protected HomePresenter getPresenter() {
        return new HomePresenter(this);
    }

    @Override
    public void getHome(HomeBean homeBean) {
        List<HomeBean.NewsBean> news = homeBean.getNews();
        list.addAll(news);
        homeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String error) {
        Log.d(TAG, "onFail: "+error);
    }
}
