package com.example.myapplicationtext.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import com.example.myapplicationtext.been.tasks;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "tasks.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "tasks";

    private static final String KEY_ID = "mid";
    private static final String KEY_TITLE = "mtitle";
    private static final String KEY_DESCRIPTION = "mDescription";
    private static final String KEY_CHECKED = "mchecked";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_students_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s INTEGER)", TABLE_NAME, KEY_ID, KEY_TITLE, KEY_DESCRIPTION, KEY_CHECKED);
        db.execSQL(create_students_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_students_table);
        onCreate(db);
    }

    public int checkdata(){
        int count = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select count(*) as 'sl' from "+TABLE_NAME, null);
        cursor.moveToFirst();
        count = cursor.getInt(0);
        return count;
    }

    public List<tasks> getAlltasks() {
        List<tasks>  studentList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            tasks tasks = new tasks(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
            studentList.add(tasks);
            cursor.moveToNext();
        }
        return studentList;
    }

    public Boolean inserted(tasks tasks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID,tasks.getMid());
        values.put(KEY_TITLE,tasks.getMtitle());
        values.put(KEY_DESCRIPTION,tasks.getmDescription());
        values.put(KEY_CHECKED,tasks.getMchecked());
        db.insert(TABLE_NAME, null, values);
        return true;
    }

    public void update(tasks tasks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, tasks.getMtitle());
        values.put(KEY_DESCRIPTION, tasks.getmDescription());
        values.put(KEY_CHECKED,tasks.getMchecked());

        db.update(TABLE_NAME, values, KEY_ID + " = ?", new String[] { String.valueOf(tasks.getMid()) });
        db.close();
    }

    public boolean deleted(int mid){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + " = ?", new String[] { String.valueOf(mid) });
        db.close();
        return true;
    }
}
