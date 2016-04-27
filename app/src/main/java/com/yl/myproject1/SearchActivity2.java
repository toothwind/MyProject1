package com.yl.myproject1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class SearchActivity2 extends AppCompatActivity {

    private EditText et_search;
    private ImageView image_search;
    private ImageView image_del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search3);
        initView();
    }

    private void initView() {
        et_search = (EditText) findViewById(R.id.et_search);
        image_search = (ImageView) findViewById(R.id.image_search);
        image_search.setVisibility(View.VISIBLE);
        image_del = (ImageView) findViewById(R.id.image_del);
        image_del.setVisibility(View.INVISIBLE);
        image_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_search.setText("");
            }
        });

        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()==0){
                    image_del.setVisibility(View.INVISIBLE);
                    image_search.setVisibility(View.VISIBLE);
                }else{
                    image_del.setVisibility(View.VISIBLE);
                    image_search.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


}
