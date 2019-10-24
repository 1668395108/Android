package com.example.wiper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView_show;
    private SeekBar seekBar1,seekBar2;
    private int n,m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_show=findViewById(R.id.textView_show);
        seekBar1=findViewById(R.id.seekBar);
        seekBar2=findViewById(R.id.seekBar2);
        /*
        *当控制杆处于关时，雨刷不摆动；当控制杆处于间歇时，如果刻度盘在1挡，
        * 雨刷每分钟摆4次；在2挡，雨刷每分钟摆6次；在3挡，雨刷每分钟摆12次；
        * else if(i==1){
                    if(n==0){
                        textView_show.setText(String.valueOf(4));
                    }else if(n==1){
                        textView_show.setText(String.valueOf(6));
                    }else if(n==2){
                        textView_show.setText(String.valueOf(12));
                    }
                }
        * 当控制杆处于低速时，雨刷每分钟摆30次；当控制杆处于高速时，雨刷每分钟摆60次*/
        textView_show.setText("雨刷  "+0);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                m=i;
                if (i==0){
                    if(n==0)
                        textView_show.setText("雨刷  "+0);
                } else if(i==1){
                    if(n==0){
                        textView_show.setText("雨刷  "+4);
                    }else if(n==1){
                        textView_show.setText("雨刷  "+6);
                    }else if(n==2){
                        textView_show.setText("雨刷  "+12);
                    }
                }else if(i==2){
                    textView_show.setText("雨刷  "+30);
                }else if(i==3){
                    textView_show.setText("雨刷  "+60);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                n = i;
                if (m == 1) {
                    if (i == 0) {
                        textView_show.setText("雨刷  "+4);
                    } else if (i == 1) {
                        textView_show.setText("雨刷  "+6);
                    } else if (i == 2) {
                        textView_show.setText("雨刷  "+12);
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
