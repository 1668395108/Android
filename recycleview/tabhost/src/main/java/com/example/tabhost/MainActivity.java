package com.example.tabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TabHost;


public class MainActivity extends AppCompatActivity {

    private TabHost myTabHost;					//定义TabHost
    private int[] layRes = { R.id.file, R.id.edit, R.id.seek, R.id.time };//定义内嵌布局管理器ID
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TabHost代码
        this.myTabHost=findViewById(R.id.tabhost);
        //this.myTabHost.setup();
        TabHost.TabSpec myTab1=myTabHost.newTabSpec("文件");
        myTab1.setIndicator("文件");
        myTab1.setContent(this.layRes[0]);
        this.myTabHost.addTab(myTab1);

        TabHost.TabSpec myTab2=myTabHost.newTabSpec("编辑");
        myTab2.setIndicator("编辑");
        myTab2.setContent(this.layRes[1]);
        this.myTabHost.addTab(myTab2);

        TabHost.TabSpec myTab3=myTabHost.newTabSpec("查看");
        myTab3.setIndicator("查看");
        myTab3.setContent(this.layRes[2]);
        this.myTabHost.addTab(myTab3);

        TabHost.TabSpec myTab4=myTabHost.newTabSpec("设置时间");
        myTab4.setIndicator("设置时间");
        myTab4.setContent(this.layRes[3]);
        this.myTabHost.addTab(myTab4);

        this.myTabHost.setCurrentTab(0);

        myTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                final Dialog dialog=new AlertDialog.Builder(MainActivity.this)
                        .setTitle("提示").setMessage("当前选中："+s+"选项")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        }).create();
                dialog.show();
            }
        });
   }
}
