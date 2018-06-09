package com.bway.day_0609_zhouliumoni;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyTitleView title;
    private FlowLayout flow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.mytitle);
        flow = findViewById(R.id.flow);
        title.onBtnOnClick(new MyTitleView.onBtnOnClick() {
            @Override
            public void onLeftClick() {


                boolean flag;
                if(flow.getChildAt(0)!=null){
                    flag=true;
                }else{
                    flag=false;
                    Toast.makeText(MainActivity.this,"数据已清空",Toast.LENGTH_SHORT).show();
                }
                if(flag==true){
                    flow.removeViewAt(0);
                }


            }

            @Override
            public void onRIghtClick() {
                Toast.makeText(MainActivity.this,"+",Toast.LENGTH_SHORT).show();
                TextView text = new TextView(MainActivity.this);
                text.setText("赵丽颖");
                text.setTextSize(25);
               text.setBackgroundColor(Color.RED);
               text.setWidth(flow.getWidth()/2);
              text.setHeight(60);
               flow.addView(text);
            }

            @Override
            public void getText() {

               //
                flow.removeAllViews();
            }
        });
    }
}
