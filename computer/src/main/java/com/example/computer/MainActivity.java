package com.example.computer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView1 = null;
    private TextView textView2 = null;
    private Button button0 = null;
    private Button button1 = null;
    private Button button2 = null;
    private Button button3= null;
    private Button button4 = null;
    private Button button5 = null;
    private Button button6= null;
    private Button button7 = null;
    private Button button8 = null;
    private Button button9 = null;
    private Button buttonjj=null;
    private Button buttonjf=null;
    private Button buttonxf=null;
    private Button buttoncf=null;
    private Button buttondh=null;
    private Button buttonC=null;
    private Button buttonqc=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textView1 = super.findViewById(R.id.input);
        this.textView2 = super.findViewById(R.id.output);
        this.button0 = super.findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = button0.getText().toString();
                textView1.append(info);

            }
        });
        this.button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = button1.getText().toString();
                textView1.append(info);
            }
        });
        this.button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = button2.getText().toString();
                textView1.append(info);
            }
        });
        this.button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = button3.getText().toString();
                textView1.append(info);
            }
        });
        this.button4= findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = button4.getText().toString();
                textView1.append(info);
            }
        });
        this.button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = button5.getText().toString();
                textView1.append(info);
            }
        });
        this.button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = button6.getText().toString();
                textView1.append(info);
            }
        });
        this.button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = button7.getText().toString();
                textView1.append(info);
            }
        });
        this.button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = button8.getText().toString();
                textView1.append(info);
            }
        });
        this.button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = button9.getText().toString();
                textView1.append(info);
            }
        });
        this.buttonjj = findViewById(R.id.buttonjh);
        buttonjj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = buttonjj.getText().toString();
                textView1.append(info);
            }
        });
        this.buttonjf = findViewById(R.id.buttonjj);
        buttonjf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = buttonjf.getText().toString();
                textView1.append(info);
            }
        });
        this.buttonxf = findViewById(R.id.buttonx);
        buttonxf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = buttonxf.getText().toString();
                textView1.append(info);
            }
        });
        this.buttoncf = findViewById(R.id.buttonxh);
        buttoncf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = buttoncf.getText().toString();
                textView1.append(info);
            }
        });
        this.buttondh = findViewById(R.id.buttondh);
        buttondh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = textView1.getText().toString();
                for(int i=0;i<info.length();i++){
                    if(info.charAt(i)=='+'){
                        int x1=0,x2=0,x=0;
                        for(int j=i-1,s=1;j>=0;j--,s=s*10){
                            x1=x1+(info.charAt(j)-48)*s;
                        }
                        for(int l=info.length()-1,s=1;l>i;l--,s*=10){
                            x2+=(info.charAt(l)-48)*s;
                        }
                        x=x1+x2;
                        String s = Integer.toString(x);
                      textView2.setText(s);
                    }
                    if(info.charAt(i)=='-'){
                        int x1=0,x2=0,x=0;
                        for(int j=i-1,s=1;j>=0;j--,s=s*10){
                            x1=x1+(info.charAt(j)-48)*s;
                        }
                        for(int l=info.length()-1,s=1;l>i;l--,s*=10){
                            x2+=(info.charAt(l)-48)*s;
                        }
                        x=x1-x2;
                        String s = Integer.toString(x);
                        textView2.setText(s);
                    }
                    if(info.charAt(i)=='*'){
                        int x1=0,x2=0,x=0;
                        for(int j=i-1,s=1;j>=0;j--,s=s*10){
                            x1=x1+(info.charAt(j)-48)*s;
                        }
                        for(int l=info.length()-1,s=1;l>i;l--,s*=10){
                            x2+=(info.charAt(l)-48)*s;
                        }
                        x=x1*x2;
                        String s = Integer.toString(x);
                        textView2.setText(s);
                    }
                    if(info.charAt(i)=='÷'){
                        int x1=0,x2=0,x=0;
                        for(int j=i-1,s=1;j>=0;j--,s=s*10){
                            x1=x1+(info.charAt(j)-48)*s;
                        }
                        for(int l=info.length()-1,s=1;l>i;l--,s*=10){
                            x2+=(info.charAt(l)-48)*s;
                        }
                        x=x1/x2;
                        String s = Integer.toString(x);
                        textView2.setText(s);
                    }
                }

            }
        });
        this.buttonC=findViewById(R.id.buttonc);
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText("");
                textView2.setText("");
            }
        });
        this.buttonqc=findViewById(R.id.buttonqc);
        buttonqc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ss=textView1.getText().toString();
                int s=ss.length()-1;
                String qc=ss.substring(0,ss.length()-1); //删除最后一个字符
                textView1.setText(qc);
            }
        });


    }
}