package com.bway.day_0609_zhouliumoni;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyTitleView extends LinearLayout implements View.OnClickListener {


    public MyTitleView(Context context) {
        super(context);
    }

    public MyTitleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MyTiltleView);
        String title_text = array.getString(R.styleable.MyTiltleView_title_text);
        String btn_left = array.getString(R.styleable.MyTiltleView_btn_left_text);
        String btn_right = array.getString(R.styleable.MyTiltleView_btn_right_text);

        View view = inflate(context, R.layout.title_layout, this);

        //获取id
        Button left_btn = view.findViewById(R.id.btn_left);
       Button right_btn= view.findViewById(R.id.btn_right);
        TextView text_title=view.findViewById(R.id.title_tet);
        left_btn.setOnClickListener(this);
        right_btn.setOnClickListener(this);
        text_title.setOnClickListener(this);
    }

    //点击事件
    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_left:
                 if(onBtnOnClick!=null){
                     onBtnOnClick.onLeftClick();
                 }
                break;
                 case R.id.btn_right:
                     if(onBtnOnClick!=null){
                         onBtnOnClick.onRIghtClick();
                     }
                     break;

                     case R.id.title_tet:
                         if(onBtnOnClick!=null){
                             onBtnOnClick.getText();
                         }
                         break;
        }
    }


    //接口回调
    public interface onBtnOnClick{

        void onLeftClick();
        void onRIghtClick();
        void getText();
    }
   //设置外部访问的方法
   private onBtnOnClick onBtnOnClick;

    public void onBtnOnClick(MyTitleView.onBtnOnClick onBtnOnClick){

    this.onBtnOnClick=onBtnOnClick;

    }
}
