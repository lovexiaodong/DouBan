package com.example.com.douban;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

/**
 * Created by Administrator on 2016/5/28.
 */
public class RefreshFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    private SwipeRefreshLayout swipeRefreshLayout;

    private List<String> list = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.refreshlist,container, false);
        ListView listView = (ListView) view.findViewById(R.id.listView);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.content);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        initData();
        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        return  view;
    }

    private void initData() {
        for(int i = 0; i < 20; i++)
        {
            list.add("This is a refresh list " + i);
        }
    }

    @Override
    public void onRefresh() {
      new  android.os.Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              swipeRefreshLayout.setRefreshing(false);
          }
      }, 3000);
    }
}
