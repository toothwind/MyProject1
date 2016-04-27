package com.yl.myproject1.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yl.myproject1.R;

import java.util.ArrayList;
import java.util.List;

/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         佛祖保佑       永无BUG
*/
public class ReMenFragment extends Fragment {

    private TextView tv_title;
    private GridView gv_content;

    private List<String> brands = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.fragment_dingji, null);

        initView(view);
        initData();
        return view;
    }


    private void initView(View view) {
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        gv_content = (GridView) view.findViewById(R.id.gv_content);
    }

    private void initData() {

        for (int i = 0; i < 100; i++) {
            brands.add("品牌" + i);
        }

        MyAdapter adapter = new MyAdapter();
        gv_content.setAdapter(adapter);
        gv_content.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getActivity(), brands.get(position),Toast.LENGTH_SHORT).show();
            }
        });

    }


    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return brands.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;

            if (convertView == null) {
                convertView = View.inflate(getActivity(), R.layout.fragment_gv_item, null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }

            holder.iv_gv_item.setImageResource(R.mipmap.zixun);
            holder.tv_gv_item.setText(brands.get(position));

            return convertView;
        }

        public class ViewHolder {

            public ImageView iv_gv_item;
            public TextView tv_gv_item;

            public ViewHolder(View rootView) {

                this.iv_gv_item = (ImageView) rootView.findViewById(R.id.iv_gv_item);
                this.tv_gv_item = (TextView) rootView.findViewById(R.id.tv_gv_item);
            }

        }
    }

}
