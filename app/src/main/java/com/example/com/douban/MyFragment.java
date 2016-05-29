package com.example.com.douban;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Vector;

/**
 * Created by Administrator on 2016/5/28.
 */
public class MyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragemt_layout, container, false);

        TextView textView = (TextView) view.findViewById(R.id.textView);
        String str = getArguments().getString("key");
        textView.setText(str);
        return view;
    }
}
