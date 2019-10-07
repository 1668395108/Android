package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  static final String autoString[]=new String[]{"湖南","湖南长沙","湖南师范大学","湖南理工","湖南辣椒"};
    private AutoCompleteTextView autoCompleteTextView=null;
    private Button button1=null;
    private Button button2=null;
    private Button button3=null;
    private Button button4=null;
    private Button button5=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,autoString);
        this.autoCompleteTextView=super.findViewById(R.id.auto);
        this.autoCompleteTextView.setAdapter(adapter);
        this.button1=super.findViewById(R.id.button1);
        this.button2=super.findViewById(R.id.button2);
        this.button3=super.findViewById(R.id.button3);
        this.button4=super.findViewById(R.id.button4);
        this.button5=super.findViewById(R.id.button5);
        this.button1.setOnClickListener(new ButtonImp1());
        this.button2.setOnClickListener(new ButtonImp2());
        this.button3.setOnClickListener(new ButtonImp3());
        this.button4.setOnClickListener(new ButtonImp4());
        this.button5.setOnClickListener(new ButtonImp5());
    }

        private class ButtonImp1 implements View.OnClickListener {
              @Override
              public void onClick(View view) {
                  Dialog dialog=new AlertDialog.Builder(MainActivity.this).setIcon(R.mipmap.ic_launcher).setTitle("雷电警告").setMessage("雷雨多发季节，注意雷电！").create();
                  dialog.show();
              }
          }
        private class ButtonImp2 implements View.OnClickListener {
            @Override
            public void onClick(View view) {
                Dialog dialog=new AlertDialog.Builder(MainActivity.this).setIcon(R.mipmap.ic_launcher).setTitle("确定删除？").setMessage("您确定要删除这个文件吗?").setPositiveButton("确定", new DialogInterface.OnClickListener() {
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
        }
        private class ButtonImp3 implements View.OnClickListener{
            boolean[] flags=new boolean[]{false,false,false,false,false,false};
            @Override
            public void onClick(View view) {
                final String[] items={"登山","跑步","跑步","篮球","羽毛球","兵乓球"};
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("请选择您喜爱的运动");
                builder.setMultiChoiceItems(items, flags, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                      flags[i]=b;
                      String result="您的选择是？";
                      for(int j=0;j<flags.length;j++){
                          if(flags[j]){
                              result=result+items[j]+"、";
                          }
                      }
                      Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AlertDialog alert=builder.create();
                alert.show();
            }
        }
        private class ButtonImp4 implements View.OnClickListener{

            @Override
            public void onClick(View view) {
                final CharSequence[] items={"A  1+1=2","B  2+2=5","C  2+3=6","D  3+3=8"};
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("请选择你认为正确的答案");
                builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"您的选择是："+items[i],Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AlertDialog alert=builder.create();
                alert.show();
            }
        }
        private class ButtonImp5 implements View.OnClickListener{
            @Override
            public void onClick(View view) {
                final CharSequence[] items={"飞机","轮船","火车"};
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("选择您喜爱的交通工具");
                builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"您的选择是："+items[i],Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alert=builder.create();
                alert.show();
            }
        }
}
