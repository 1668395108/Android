package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText_1,editText_2,editText_3;
    private TextView textView_show;
    private Button button_test,button_reset;
    private int e1,e2,e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_1=findViewById(R.id.editText_1);
        editText_2=findViewById(R.id.editText_2);
        editText_3=findViewById(R.id.editText_3);
        textView_show=findViewById(R.id.textView_show);
        button_test=findViewById(R.id.button_test);
        button_reset=findViewById(R.id.button_reset);
        button_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1=Integer.valueOf(editText_1.getText().toString());
                e2=Integer.valueOf(editText_2.getText().toString());
                e3=Integer.valueOf(editText_3.getText().toString());
                if(e1<200&&e2<200&&e3<200){
                    if(e1+e2>e3&&e1+e3>e2&&e2+e3>e1){
                        if( e1==e2&&e2==e3&&e1==e3){
                            textView_show.setText("等边三角形");
                        }else if(e1==e2||e2==e3 ){
                            textView_show.setText("等腰三角形");
                        }else {
                            textView_show.setText("一般三角形");
                        }
                    }else {
                        textView_show.setText("不能构成三角形");
                    }
                }else {
                    Toast.makeText(MainActivity.this, "请输入小于200的数字！", Toast.LENGTH_SHORT).show();
                  //  textView_show.setText("请输入小于200的数字！");
                }
            }
        });
        button_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText_1.setText("");editText_2.setText("");editText_3.setText("");
            }
        });
    }
}
