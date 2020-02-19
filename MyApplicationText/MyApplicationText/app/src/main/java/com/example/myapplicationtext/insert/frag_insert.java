package com.example.myapplicationtext.insert;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.myapplicationtext.R;

public class frag_insert extends Fragment {

    private EditText edittitle, editdestory;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_frag_insert, container, false);
        addcontrol();
        getdata();
        return view;
    }

    private void addcontrol() {
        edittitle = view.findViewById(R.id.add_task_title);
        editdestory = view.findViewById(R.id.add_task_description);
    }
    public String getdata() {
         String s = edittitle.getText().toString() + editdestory.getText().toString();
         return s;
    }
}
