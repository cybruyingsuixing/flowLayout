package com.bway.day_0609_zhouliumoni;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class FlowLayout extends ViewGroup {


    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//获取子控件宽度与高度
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int widthmode = MeasureSpec.getMode(widthMeasureSpec);
        int widthsize = MeasureSpec.getSize(widthMeasureSpec);
        int heightmode = MeasureSpec.getMode(heightMeasureSpec);
        int heightsize = MeasureSpec.getSize(heightMeasureSpec);

        int width = 0;
        int height = 0;
        int linewidth = 0;
        int lineheight = 0;
        int totalheight = 0;

        View childview;
        int childwidth = 0;
        int childheght = 60;

        if (getChildCount() == 0) {
            setMeasuredDimension(0, 0);
        }

        for (int i = 0; i < getChildCount(); i++) {
            childview = getChildAt(i);
            childwidth = childview.getMeasuredWidth();

            if (childwidth > widthsize) {
                throw new IllegalArgumentException("子view宽度不能大于FlowLayout宽度");
            }
//得到子控件的高度
            childheght = childview.getMeasuredHeight();

            //如果每行的子控件的宽度大于父控件的话，进行换行

            if (linewidth + childwidth > widthsize) {

                //换行之后
                width = widthsize;
                //当前的高度等于新来的子控件的高度
                totalheight += lineheight;
                lineheight = childheght;


            } else {
                //否则的话不换行，往后进行拼接
                linewidth += childwidth;
                lineheight = Math.max(lineheight, childheght);
                width = Math.max(width, linewidth);

            }
            if (i == getChildCount() - 1) {
                totalheight += lineheight;
                height = totalheight;
            }

            width = widthmode == MeasureSpec.EXACTLY ? widthsize : width;
            height = heightmode == MeasureSpec.EXACTLY ? heightsize : width;
            //确定最终测量的宽高
            setMeasuredDimension(width, height);


        }

    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int width = 0;
        int height = 0;
        int linewidth = 0;
        int lineheight = 0;
        int totalheight = 0;

        View childview;
        int childwidth = 0;
        int childheght = 60;

        for (int i = 0; i < getChildCount(); i++) {
            childview = getChildAt(i);
            childwidth = childview.getMeasuredWidth();
            childheght = childview.getMeasuredHeight();

            if (i % 2 == 0) {
                totalheight += childheght;
                childwidth =getWidth()/2;
                linewidth = 0;
                layoutChildView(childview, linewidth, totalheight, linewidth + childwidth, totalheight + childheght);


            } else {
                totalheight += childheght;
                childwidth =getWidth()/2;
                linewidth = childwidth ;;
                layoutChildView(childview, linewidth, totalheight, linewidth + childwidth, totalheight + childheght);

            }

        }
    }
    public void layoutChildView(View child, int l, int h, int r, int b) {
        child.layout(l, h, r, b);
    }


}
