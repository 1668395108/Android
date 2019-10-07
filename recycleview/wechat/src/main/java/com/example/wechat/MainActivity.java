package com.example.wechat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button imageView1=findViewById(R.id.wechat);
        Button imageView2=findViewById(R.id.theaddressbook);
        Button imageView3=findViewById(R.id.find);
        Button imageView4=findViewById(R.id.me);
        imageView1.setOnClickListener(I);
        imageView2.setOnClickListener(I);
        imageView3.setOnClickListener(I);
        imageView4.setOnClickListener(I);
    }
    View.OnClickListener I=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            Fragment f=null;
            switch (view.getId()){
                case R.id.wechat:
                f=new WeChat_Fragment();
                break;
                case R.id.theaddressbook:
                    f=new TheAddressBook_Fragment();
                    break;
                case R.id.find:
                    f=new Find_Fragment();
                    break;
                case R.id.me:
                    f=new Me_Fragment();
                    break;
                default:break;
            }
            ft.replace(R.id.fragment,f);
            ft.commit();
        }
    };
}
