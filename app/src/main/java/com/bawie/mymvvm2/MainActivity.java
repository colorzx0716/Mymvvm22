package com.bawie.mymvvm2;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.bawie.mymvvm2.base.BaseActivity;
import com.bawie.mymvvm2.databinding.ActivityMainBinding;
import com.bawie.mymvvm2.vm.ProductVM;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements XRecyclerView.LoadingListener {

    private ProductVM productVM;
    private XRecyclerView xRecyclerView;

    @Override
    public void onRefresh() {
        productVM.refresh("0");
    }

    @Override
    public void onLoadMore() {
        productVM.loadmore("1");
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initView();
        productVM = new ProductVM(this,binding,"0");

    }

    private void initView() {
        xRecyclerView = binding.lv;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        xRecyclerView.setLayoutManager(linearLayoutManager);
        xRecyclerView.setLoadingListener(this);
        xRecyclerView.setLoadingMoreEnabled(true);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
}
