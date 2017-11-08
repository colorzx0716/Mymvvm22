package com.bawie.mymvvm2.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * XRecyclerView适配器
 */

public class MVVMBaseAdapter<T> extends RecyclerView.Adapter<MVVMBaseAdapter.MyHolder>{
    private Context context;
    List<T> data;
    private int layoutId;
    private int vid;
    private LayoutInflater layoutInflater;

    public void refresh(List<T> d){
        if (data!=null){
            data.clear();
            data.addAll(d);
            notifyDataSetChanged();
        }
    }

    public void loadMore(List<T> d){
        if (data!=null){
            data.addAll(d);
            notifyDataSetChanged();
        }
    }

    public MVVMBaseAdapter(Context context, List<T> data, int layoutId, int vid) {
        this.context = context;
        this.data = data;
        this.layoutId = layoutId;
        this.vid = vid;
        this.layoutInflater = layoutInflater.from(context);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, layoutId, parent, false);
        MyHolder myHolder = new MyHolder(binding.getRoot());

        myHolder.setViewDataBinding(binding);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(MVVMBaseAdapter.MyHolder holder, int position) {
        holder.viewDataBinding.setVariable(vid, data.get(position));

        holder.viewDataBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ViewDataBinding viewDataBinding;

        public MyHolder(View itemView) {
            super(itemView);
        }

        public ViewDataBinding getViewDataBinding() {
            return viewDataBinding;
        }

        public void setViewDataBinding(ViewDataBinding viewDataBinding) {
            this.viewDataBinding = viewDataBinding;
        }
    }

}
