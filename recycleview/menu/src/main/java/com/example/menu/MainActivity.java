package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.com.viewmodel.ViewModelSHP;
import com.multimedia.Audio;
import com.multimedia.Video;

public class MainActivity extends AppCompatActivity {

    private static String TAG="MainActivity";
    private Button button1=null;
    private Button button2=null;
    private Button button4=null;
    private Button button8=null;
    private Button button9=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.button2);
        button2=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button8=findViewById(R.id.button8);
        button9=findViewById(R.id.button9);
        button1.setOnClickListener(new OnClickListenerDate());
        button2.setOnClickListener(new OnClickListenerTime());
        Log.e(TAG,"hello world");
        Log.w(TAG,"hello world");
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Audio.class);
                startActivity(intent);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Video.class);
                startActivity(intent);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), ViewModelSHP.class);
                startActivity(intent);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater=new MenuInflater(this);
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Setting.class);
                startActivity(intent);

                break;
            case R.id.regrads:
                Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(MainActivity.this,Regard.class);
                startActivity(intent1);break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }

    private class OnClickListenerDate implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Dialog dialog=new DatePickerDialog(MainActivity.this,new DatePickerDialog.OnDateSetListener(){
                public void onDateSet(DatePicker view,int year,int mouthOfYear,int day) {
                    TextView textView = findViewById(R.id.tet);
                    textView.setText("更新日期为：" + year + "-" + (mouthOfYear + 1) + "-" + day);
                }
            },2019,9,22);
            dialog.show();
        }
    }

    private class OnClickListenerTime implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Dialog dialog=new TimePickerDialog(MainActivity.this,new TimePickerDialog.OnTimeSetListener(){
                public void onTimeSet(TimePicker view, int hourofday, int minute){
                    TextView textView=findViewById(R.id.tet);
                    textView.setText("更新时间为："+hourofday+"："+minute);
                }
            },11,42,true);
            dialog.show();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(MainActivity.this, "触摸了屏幕", Toast.LENGTH_SHORT).show();
        return super.onTouchEvent(event);
    }
}
