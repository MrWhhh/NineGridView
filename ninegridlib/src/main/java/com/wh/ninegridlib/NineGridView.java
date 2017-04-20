package com.wh.ninegridlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MrWhhh .
 * @date : 2017/4/20 .
 * @description : .
 */
public class NineGridView<T> extends ViewGroup {

    public final static int STYLE_CUSTOM = 0;     // 自定义布局
    public final static int STYLE_GRID = 1;     // 宫格布局

    List<T> dataList;

    List<ImageView> imgList = new ArrayList<>();

    NineGridViewAdapter<T> adapter;

    int childWidth;

    int spacing = 10; //间距
    int showStyle; //显示方式

    final String TAG = "NineGridView";

    public NineGridView(Context context) {
        super(context);
    }

    public NineGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NineGridView);
        int spacing = (int) typedArray.getDimension(R.styleable.NineGridView_spacing, -1);
        if (spacing > -1) {
            this.spacing = spacing;
        }
        showStyle = typedArray.getInt(R.styleable.NineGridView_showStyle, STYLE_CUSTOM);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        for (int i = 0; i < getChildCount(); i++) {
            adapter.loadingWayImg(getContext(), (ImageView) getChildAt(i), dataList.get(i));
        }

        if (null != dataList && dataList.size() > 0) {
            if (showStyle == STYLE_CUSTOM) {
                int height = 0;
                switch (getChildCount()) {
                    case 1:
                        ImageView img1 = (ImageView) getChildAt(0);
                        img1.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
                        height = widthSize / img1.getDrawable().getMinimumWidth() * img1.getDrawable().getMinimumHeight();
                        break;
                    case 2:
                        height = (widthSize - spacing) / 2;
                        break;
                    case 3:
                        height = widthSize / 3 * 2;
                        break;
                    case 4:
                        height = widthSize;
                        break;
                    case 5:
                        height = (widthSize - spacing) / 2 + spacing + (widthSize - spacing) / 3;
                        break;
                    case 6:
                        height = widthSize / 3 * 2 + widthSize / 3;
                        break;
                    case 7:
                        height = widthSize + spacing + widthSize / 3;
                        break;
                    case 8:
                        height = widthSize / 3 * 2 + spacing + widthSize / 2;
                        break;
                    default:
                        height = widthSize + spacing * 2;
                        break;
                }
                setMeasuredDimension(widthSize, height);
                for (int i = 0; i < getChildCount(); i++) {
                    LayoutParams lp = getChildAt(i).getLayoutParams();
                    lp.width = childWidth;
                    lp.height = childWidth;
                    getChildAt(i).setLayoutParams(lp);
                }
            } else {
                setMeasuredDimension(widthSize, widthSize / 3 * (int) Math.ceil((double) getChildCount() / 3));
            }
        } else {
            setMeasuredDimension(0, 0);
        }

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        if (showStyle == STYLE_CUSTOM) {
            if (childCount == 3) {
                for (int i = 0; i < childCount; i++) {
                    int width = (getWidth() - spacing / 2) / 6;
                    switch (i) {
                        case 0:
                            getChildAt(0).layout(0, 0, width * 4, width * 4);
                            break;
                        case 1:
                            int left = width * 4 + spacing;
                            int right = left + width * 2 - spacing / 2;
                            getChildAt(1).layout(left, 0, right, width * 2 - spacing / 2);
                            break;
                        case 2:
                            getChildAt(2).layout(width * 4 + spacing, width * 2 + spacing / 2, width * 4 + spacing + width * 2 - spacing / 2, width * 2 + width * 2);
                            break;
                    }
                }
            } else if (childCount == 6) {
                for (int i = 0; i < 3; i++) {
                    int width = (getWidth() - spacing / 2) / 6;
                    switch (i) {
                        case 0:
                            getChildAt(0).layout(0, 0, width * 4, width * 4);
                            break;
                        case 1:
                            int left = width * 4 + spacing;
                            int right = left + width * 2 - spacing / 2;
                            getChildAt(1).layout(left, 0, right, width * 2 - spacing / 2);
                            break;
                        case 2:
                            getChildAt(2).layout(width * 4 + spacing, width * 2 + spacing / 2, width * 4 + spacing + width * 2 - spacing / 2, width * 2 + width * 2);
                            break;
                    }
                }
                for (int i = 0; i < childCount - 3; i++) {
                    ImageView img = (ImageView) getChildAt(i + 3);

                    int width = (getWidth() - spacing * 2) / 3;

                    int rowNum = i / 3;
                    int columnNum = i % 3;

                    int left = width * columnNum + spacing * columnNum;
                    int top = width * rowNum + spacing * (rowNum + 1) + (getWidth() - spacing / 2) / 3 * 2;
                    int right = left + width;
                    int bottom = top + width;

                    img.layout(left, top, right, bottom);
                }
            } else if (childCount % 3 == 0) {
                for (int i = 0; i < childCount; i++) {
                    ImageView img = (ImageView) getChildAt(i);

                    int width = (getWidth() - spacing * 2) / 3;

                    int rowNum = i / 3;
                    int columnNum = i % 3;

                    int left = width * columnNum + spacing * columnNum;
                    int top = width * rowNum + spacing * rowNum;
                    int right = left + width;
                    int bottom = top + width;

                    img.layout(left, top, right, bottom);
                }

            } else if (childCount == 2 || childCount == 4) {
                int width = (getWidth() - spacing) / 2;
                for (int i = 0; i < childCount; i++) {
                    ImageView img = (ImageView) getChildAt(i);
                    int rowNum = i / 2;
                    int columnNum = i % 2;
                    int left = width * columnNum + spacing * columnNum;
                    int top = width * rowNum + spacing * rowNum;
                    int right = left + width;
                    int bottom = top + width;
                    img.layout(left, top, right, bottom);
                }
            }
            switch (childCount) {
                case 1:
                    ImageView img1 = (ImageView) getChildAt(0);
                    img1.layout(0, 0, getWidth(), getWidth() / img1.getDrawable().getMinimumWidth() * img1.getDrawable().getMinimumHeight());
                    break;
                case 5:
                case 8:
                    for (int i = 0; i < 2; i++) {
                        ImageView img = (ImageView) getChildAt(i);

                        int width = (getWidth() - spacing) / 2;

                        int rowNum = i / 2;
                        int columnNum = i % 2;

                        int left = width * columnNum + spacing * columnNum;
                        int top = width * rowNum + spacing * rowNum;
                        int right = left + width;
                        int bottom = top + width;

                        img.layout(left, top, right, bottom);
                    }
                    for (int i = 0; i < childCount - 2; i++) {
                        ImageView img = (ImageView) getChildAt(i + 2);

                        int width = (getWidth() - spacing * 2) / 3;

                        int rowNum = i / 3;
                        int columnNum = i % 3;

                        int left = width * columnNum + spacing * columnNum;
                        int top = width * rowNum + spacing * (rowNum + 1) + ((getWidth() - spacing) / 2);
                        int right = left + width;
                        int bottom = top + width;

                        img.layout(left, top, right, bottom);
                    }
                    break;
                case 7:
                    for (int i = 0; i < 4; i++) {
                        ImageView img = (ImageView) getChildAt(i);

                        int width = (getWidth() - spacing) / 2;

                        int rowNum = i / 2;
                        int columnNum = i % 2;

                        int left = width * columnNum + spacing * columnNum;
                        int top = width * rowNum + spacing * rowNum;
                        int right = left + width;
                        int bottom = top + width;

                        img.layout(left, top, right, bottom);
                    }
                    for (int i = 0; i < childCount - 4; i++) {
                        ImageView img = (ImageView) getChildAt(i + 4);

                        int width = (getWidth() - spacing * 2) / 3;

                        int rowNum = i / 3;
                        int columnNum = i % 3;

                        int left = width * columnNum + spacing * columnNum;
                        int top = width * rowNum + spacing * (rowNum + 2) + ((getWidth() - spacing));
                        int right = left + width;
                        int bottom = top + width;

                        img.layout(left, top, right, bottom);
                    }
                    break;
            }
        } else {
            for (int i = 0; i < childCount; i++) {
                ImageView img = (ImageView) getChildAt(i);

                int width = (getWidth() - spacing * 2) / 3;

                int rowNum = i / 3;
                int columnNum = i % 3;

                int left = width * columnNum + spacing * columnNum;
                int top = width * rowNum + spacing * rowNum;
                int right = left + width;
                int bottom = top + width;

                img.layout(left, top, right, bottom);
            }
        }
    }

    /**
     * 设置Adapter 再setData前调用
     *
     * @param mAdapter
     */
    public void setAdapter(NineGridViewAdapter mAdapter) {
        adapter = mAdapter;
    }

    /**
     * 设置数据源
     *
     * @param list
     */
    public void setData(List<T> list) {
        if (null == list && list.isEmpty()) {
            this.setVisibility(GONE);
            return;
        } else {
            this.setVisibility(VISIBLE);
        }
        removeAllViews();
        dataList = list;
        for (int i = 0; i < list.size(); i++) {
            ImageView iv = getImageView(i);
            if (null == iv) {
                return;
            }
            addView(getImageView(i), generateDefaultLayoutParams());
        }
        requestLayout();
    }

    public ImageView getImageView(final int position) {
        if (position < imgList.size()) {
            return imgList.get(position);
        } else {
            if (adapter != null) {
                final ImageView imageView = adapter.getImageView(getContext());
                imgList.add(imageView);
                imageView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        adapter.onItemClick(getContext(), (ImageView) v, position, dataList);
                    }
                });
                return imageView;
            } else {
                Log.e(TAG, "先setAdapter()");
                return null;
            }
        }
    }

    /**
     * 设置图片间距
     *
     * @param spacing
     */
    public void setSpacing(int spacing) {
        this.spacing = spacing;
    }

    /**
     * 设置显示布局
     *
     * @param showStyle
     */
    public void setShowStyle(int showStyle) {
        this.showStyle = showStyle;
    }


}
