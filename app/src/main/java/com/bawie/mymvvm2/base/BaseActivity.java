package com.bawie.mymvvm2.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;



public abstract class BaseActivity<VDB extends ViewDataBinding> extends AppCompatActivity {

    public VDB binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, getLayoutId());

        init(savedInstanceState);
    }

    protected abstract void init(Bundle savedInstanceState);


    public abstract int getLayoutId();
}
