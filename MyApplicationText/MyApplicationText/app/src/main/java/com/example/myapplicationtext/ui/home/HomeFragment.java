package com.example.myapplicationtext.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplicationtext.R;
import com.example.myapplicationtext.data.DatabaseHandler;
import com.example.myapplicationtext.been.*;
import com.example.myapplicationtext.adapter.*;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private View root;
    private View noTasks;
    private ListView listView;
    private ArrayList<tasks> arrayList;
    private adaptertasks adaptertasks;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        addcontrol();
        addevent();
        return root;
    }

    private void addevent() {
        DatabaseHandler db = new DatabaseHandler(getActivity());
        if(db.checkdata() == 0 ){
            listView.setVisibility(root.GONE);
            noTasks.setVisibility(root.VISIBLE);
        }else {
            listView.setVisibility(root.VISIBLE);
            noTasks.setVisibility(root.GONE);
            arrayList = (ArrayList<tasks>) db.getAlltasks();
            adaptertasks = new adaptertasks(getActivity(),arrayList,R.layout.task_item);
            listView.setAdapter(adaptertasks);
        }
    }

    private void addcontrol() {
        listView = root.findViewById(R.id.tasks_list);
        noTasks = root.findViewById(R.id.noTasks);
        arrayList = new ArrayList<>();
    }
}