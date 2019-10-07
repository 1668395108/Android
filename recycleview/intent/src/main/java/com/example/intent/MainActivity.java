package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button=null;
    EditText name=null;
    EditText phone=null;
    EditText address=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.xingming);
        phone=findViewById(R.id.dianhua);
        address=findViewById(R.id.zhuzhi);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Recevie.class);
                String na=name.getText().toString();
                String ph=phone.getText().toString();
                String ad=address.getText().toString();
                intent.putExtra("na",na);
                intent.putExtra("ph",ph);
                intent.putExtra("ad",ad);
                MainActivity.this.startActivityForResult(intent,1);
            }
        });
    }
}
