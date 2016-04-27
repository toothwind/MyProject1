package com.yl.myproject1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView saoyisao;
    private EditText sousuo;
    private TextView zixun;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        saoyisao = (TextView) findViewById(R.id.saoyisao);
        sousuo = (EditText) findViewById(R.id.sousuo);
        zixun = (TextView) findViewById(R.id.zixun);

        saoyisao.setOnClickListener(this);
        sousuo.setOnClickListener(this);
        zixun.setOnClickListener(this);

//        AlertDialog.Builder  builder = new AlertDialog.Builder(this);

//        AlertDialog dialog = builder.create();
//
//        dialog.setTitle("sssssssssss");
//        EditText editText = new EditText(this);
//        dialog.setView(editText);

//        dialog.show();

//        builder.setTitle("aaa");

//        //builder.setView(R.layout.activity_main);

//        EditText editText = new EditText(this);
//        editText.setHint("sssss!!");
//        builder.setView(editText);

//        builder.show();

        listView = (ListView) findViewById(R.id.listView);
       listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
               new String[]{"22","2","222","22","2","222","22","2","222","22","2","222","22","2","222","22","2","222"}));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.saoyisao:
                Toast.makeText(this, "扫一扫-->打开详情界面", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(this, ProductActivity.class));



                break;
            case R.id.sousuo:
                // Toast.makeText(this, "搜索",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, SearchActivity2.class));
                break;
            case R.id.zixun:
                Toast.makeText(this, "咨询", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
