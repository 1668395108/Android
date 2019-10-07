package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Recevie extends AppCompatActivity {
    private TextView name=null;
    private TextView phone=null;
    private TextView address=null;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receive);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        address=findViewById(R.id.address);
        button=findViewById(R.id.buttonBack);
        Intent intent=getIntent();
        String info=intent.getStringExtra("na");
        this.name.setText(info);
        Intent intent1=getIntent();
        String ph=intent.getStringExtra("ph");
        this.phone.setText(ph);
        Intent intent2=getIntent();
        String ad=intent.getStringExtra("ad");
        this.address.setText(ad);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent3=new Intent(Recevie.this,MainActivity.class);
               startActivity(intent3);
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(this, "触摸", Toast.LENGTH_SHORT).show();
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Toast.makeText(this, "按下", Toast.LENGTH_SHORT).show();
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Toast.makeText(this, "抬起", Toast.LENGTH_SHORT).show();
        return super.onKeyUp(keyCode, event);
    }
}
