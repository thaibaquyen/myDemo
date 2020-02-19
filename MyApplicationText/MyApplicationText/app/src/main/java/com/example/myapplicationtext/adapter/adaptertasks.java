package com.example.myapplicationtext.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.myapplicationtext.R;
import com.example.myapplicationtext.been.tasks;

import java.util.ArrayList;

public class adaptertasks extends BaseAdapter {

    private Context context;
    private ArrayList<tasks> arrayList;
    private int layout;

    public adaptertasks(Context context, ArrayList<tasks> arrayList, int layout) {
        this.context = context;
        this.arrayList = arrayList;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(layout, null);
        CheckBox checkBox = view.findViewById(R.id.complete);
        TextView textView = view.findViewById(R.id.title);

        tasks tasks = arrayList.get(i);
        if(tasks.getMchecked() == 0){
            checkBox.setChecked(false);
        }else {
            checkBox.setChecked(true);
        }
        textView.setText(tasks.getMtitle());
        return view;
    }
}
