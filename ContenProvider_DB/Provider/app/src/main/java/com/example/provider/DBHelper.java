package com.example.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private  String TAG="myLog";

    public DBHelper(@Nullable Context context) {
        super(context, "persondb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(TAG,"onCreateDB");
        sqLiteDatabase.execSQL("create table person ("+"_id integer primary key autoincrement,"+"name text)");
        sqLiteDatabase.execSQL("insert into person (name) values ('杨亚斌')");
        Log.d(TAG,"数据创建成功！");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
