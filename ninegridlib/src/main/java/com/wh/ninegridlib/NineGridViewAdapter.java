package com.wh.ninegridlib;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

/**
 * @author MrWhhh .
 * @date : 2017/4/20 .
 * @description : Adapter.
 */
public abstract class NineGridViewAdapter<T> {
    /**
     * 加载图片到ImageView
     *
     * @param context
     * @param imageView
     * @param t
     */
    public abstract void loadingWayImg(Context context, ImageView imageView, T t);

    /**
     * item点击事件
     *
     * @param context
     * @param imageView
     * @param position
     * @param list
     */
    public abstract void onItemClick(Context context, ImageView imageView, int position, List<T> list);

    /**
     * 实例化ImageView onTouch事件加了点击效果 也可以自定义
     *
     * @param context
     * @return
     */
    public ImageView getImageView(Context context) {
        final ImageView img = new ImageView(context);
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        img.setAlpha(0.8f);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        img.setAlpha(1f);
                        break;
                }
                return false;
            }
        });
        return img;
    }
}
