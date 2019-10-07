package com.example.addressactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=((EditText)findViewById(R.id.editText)).getText().toString();
                String phone=((EditText)findViewById(R.id.editText3)).getText().toString();
                if(!"".equals(name)&&!"".equals(phone)){
                   Intent intent=new Intent(MainActivity.this,AddressActivity.class);
                   Bundle bundle=new Bundle();
                   bundle.putCharSequence("name",name);
                   bundle.putCharSequence("phone",phone);
                   intent.putExtras(bundle);
                   startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this,"请将信息填写完整",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
