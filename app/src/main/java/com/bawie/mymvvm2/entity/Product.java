package com.bawie.mymvvm2.entity;


import android.databinding.BindingAdapter;
import android.widget.ImageView;

/**
 * bean类
 */
import com.bumptech.glide.Glide;

public class Product {
    public String title;
    public String price;

    public String icon = "http://pic26.photophoto.cn/20130323/0005018467298586_b.jpg";

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    //图片加载
    @BindingAdapter("imgUrl")
    public static void display(ImageView iv,String url){
        Glide.with(iv.getContext()).load(url).into(iv);
    }

}
