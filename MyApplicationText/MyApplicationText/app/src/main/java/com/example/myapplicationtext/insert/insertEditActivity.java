package com.example.myapplicationtext.insert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplicationtext.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class insertEditActivity extends AppCompatActivity {

    private EditText edittitle, editdestory;
    private frag_insert frag_insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_edit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        frag_insert = new frag_insert();
        fragmentTransaction.replace(R.id.contentFrame, frag_insert);
        fragmentTransaction.commit();
        addevent();
    }

    private void addevent() {
        FloatingActionButton fab = findViewById(R.id.fab_edit_task_done);
        fab.setImageResource(R.drawable.ic_done);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(insertEditActivity.this, frag_insert.getdata(),Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
