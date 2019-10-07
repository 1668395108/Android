package com.example.addressactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class AddressActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textshow);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String name=bundle.getString("name");
        String phone=bundle.getString("phone");
        TextView tv_name=findViewById(R.id.name);
        TextView tv_phone=findViewById(R.id.phone);
        tv_name.setText(name);
        tv_phone.setText(phone);
    }
}
