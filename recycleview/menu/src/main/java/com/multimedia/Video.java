package com.multimedia;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.menu.R;

public class Video extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);
        //SharedPreferences shp=getPreferences(Context.MODE_PRIVATE);   //保存数据到文件中
        SharedPreferences shp=getSharedPreferences("MY_DATA",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=shp.edit();
        editor.putInt("NUMBER",900);
        editor.apply();


        int x=shp.getInt("NUMBER",0);
        String TAG= "myLog";
        Log.d(TAG,"OnCrate" + x);
    }
}
