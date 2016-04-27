package com.yl.myproject1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.yl.myproject1.fragment.DingjiFragment;
import com.yl.myproject1.fragment.QingSheFragment;
import com.yl.myproject1.fragment.ReMenFragment;
import com.yl.myproject1.fragment.SheHuaFragment;
import com.yl.myproject1.fragment.ShiShangFragment;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    private ListView lv_menu;
    private FrameLayout fm_content;

    private String[] menus = new String[]{"热门", "顶级", "奢华", "轻奢", "时尚"};

    private List<Fragment> fragments = new ArrayList<>();

    private AdapterView.OnItemClickListener onMenuItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fm_content,fragments.get(position))
                    .commit();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        initView();
        initListener();
        initData();

    }


    private void initView() {
        lv_menu = (ListView) findViewById(R.id.lv_menu);
        fm_content = (FrameLayout) findViewById(R.id.fm_content);
    }

    private void initListener() {
        lv_menu.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menus));

        lv_menu.setOnItemClickListener(onMenuItemClickListener);
    }

    private void initData() {
        fragments.add(new ReMenFragment());
        fragments.add(new DingjiFragment());
        fragments.add(new SheHuaFragment());
        fragments.add(new QingSheFragment());
        fragments.add(new ShiShangFragment());
        getSupportFragmentManager().beginTransaction().replace(R.id.fm_content,fragments.get(0)).commit();
    }


}
