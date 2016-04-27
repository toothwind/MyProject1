package com.yl.myproject1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText sousuo;
    private EditText ss;
    private ImageView image_del;
    private LinearLayout ll_sousuo_back;
    private LinearLayout ll_sousuo_front;
    private ImageView imageSousuo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
    }

    private void initView() {
        sousuo = (EditText) findViewById(R.id.sousuo);
        ss = (EditText) findViewById(R.id.ss);


        ss.setOnClickListener(this);
        image_del = (ImageView) findViewById(R.id.image_del);
        image_del.setOnClickListener(this);
        ll_sousuo_back = (LinearLayout) findViewById(R.id.ll_sousuo_back);
        ll_sousuo_back.setOnClickListener(this);
        ll_sousuo_front = (LinearLayout) findViewById(R.id.ll_sousuo_front);
        ll_sousuo_front.setOnClickListener(this);

        sousuo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // System.out.println("1s="+s);
                // image_del.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                System.out.println("2s=" + s+(s==null || "".equals(s))+(s.length()));
                if (s.length()==0) {
                    //没有删除
                    image_del.setVisibility(View.INVISIBLE);

                } else {
                    image_del.setVisibility(View.VISIBLE);


                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // System.out.println("3s="+s);

            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sousuo:
                Toast.makeText(this, "下边的", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ss:
                Toast.makeText(this, "上边的", Toast.LENGTH_SHORT).show();
                ll_sousuo_back.setVisibility(View.VISIBLE);
                ll_sousuo_front.setVisibility(View.GONE);
                break;
            case R.id.image_del:
                sousuo.setText("");
                break;
        }
    }
}
