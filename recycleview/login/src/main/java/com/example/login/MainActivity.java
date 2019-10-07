package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    private Button button=null;
    private Button previous=null;
    private Button next=null;
    private int count=0;
    private ImageSwitcher imageSwitcher=null;
    private int[] images=new int[]{R.drawable.lj1,R.drawable.ljc1,R.drawable.lqd1,R.drawable.lyh1,R.drawable.lyh1,R.drawable.lzj1,R.drawable.my1,R.drawable.wjl1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.loginbutton);

        //登录代码
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater=LayoutInflater.from(MainActivity.this);
                View dialogView=layoutInflater.inflate(R.layout.login,null);
                Dialog dialog=new AlertDialog.Builder(MainActivity.this).setIcon(R.drawable.zygxy1)
                        .setTitle("用户登录界面")
                        .setView(dialogView)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).create();
                dialog.show();
            }
        });
        previous=findViewById(R.id.previous);
        next=findViewById(R.id.next);
        imageSwitcher=findViewById(R.id.myImages);
        previous.setOnClickListener(new OnPreButClickImp());
        next.setOnClickListener(new OnNexButClickImp());
        imageSwitcher.setFactory(new ViewFactoryImp());
        imageSwitcher.setImageResource(this.images[this.count]);
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
    }
    public class OnPreButClickImp implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(MainActivity.this.count!=0){
                MainActivity.this.imageSwitcher.setImageResource(MainActivity.this.images[--MainActivity.this.count]);
            }else {
                Toast.makeText(MainActivity.this, "已经是第一张了，不能再往前了", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public class OnNexButClickImp implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(MainActivity.this.count!=MainActivity.this.images.length-1){
                MainActivity.this.imageSwitcher.setImageResource(MainActivity.this.images[++MainActivity.this.count]);
            }else {
                Toast.makeText(MainActivity.this, "已经是最后一张了，不能再往后了", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private  class ViewFactoryImp implements ViewSwitcher.ViewFactory{
        @Override
        public View makeView() {
            ImageView imageView=new ImageView(MainActivity.this);
            imageView.setBackgroundColor(0xFFFFFF);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return imageView;
        }
    }
}
