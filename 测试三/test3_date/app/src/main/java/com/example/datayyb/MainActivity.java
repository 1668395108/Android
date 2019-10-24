package com.example.datayyb;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText_year,editText_month,editText_day;
    private TextView textView_year,textView_month,textView_day,textView_showerr;
    private Button button_test,button_reset;
    private int year,month,day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_year=findViewById(R.id.editText_year);
        editText_month=findViewById(R.id.editText_month);
        editText_day=findViewById(R.id.editText_day);
        textView_year=findViewById(R.id.textView_year);
        textView_month=findViewById(R.id.textView_month);
        textView_day=findViewById(R.id.textView_day);
        textView_showerr=findViewById(R.id.textView_shoeerr);
        button_test=findViewById(R.id.button_test);
        button_reset=findViewById(R.id.button_reset);
        button_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                year=Integer.valueOf(editText_year.getText().toString());
                month=Integer.valueOf(editText_month.getText().toString());
                day=Integer.valueOf(editText_day.getText().toString());
                    //Toast.makeText(MainActivity.this, "请输入年月日！", Toast.LENGTH_SHORT).show();
                    if(!((year>=1812)&&(year<=2012) &&(month>=1)&&(month<=12) &&(day>=1)&&(day<=31) &&ValidDate(year,month,day)))
                    {
                        Toast.makeText(MainActivity.this, "失败!日期不正确", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    day++;
                    if(!ValidDate(year,month,day))
                    {
                        day=1;
                        month++;
                    }
                    if(!ValidDate(year,month,day))
                    {
                        day=1;
                        month=1;
                        year++;
                    }

                    String Year=String.valueOf(year);
                    String Month=String.valueOf(month);
                    String Day=String.valueOf(day);
                    textView_year.setText(Year+"年");
                    textView_month.setText(Month+"月");
                    textView_day.setText(Day);
                }
        });
        button_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText_year.setText("");
                editText_month.setText("");
                editText_day.setText("");
                textView_year.setText("");
                textView_month.setText("");
                textView_day.setText("");
            }
        });

    }
    public boolean ValidDate(int intYear,int intMonth,int intDate)
    {
        if(intDate>31||intMonth>12)
            return false;

        switch (intMonth)
        {
            case 4:
                if(intDate>30)return false;
                break;
            case 6:
                if(intDate>30)return false;
                break;
            case 9:
                if(intDate>30)return false;
                break;
            case 11:
                if(intDate>30)return false;
                break;
            case 2:
                if(intDate>29)return false;
                if(intDate>28&&(!((intYear%400==0)||((intYear%4==0)&&(intYear%100!=0)))))return false;
                return true;
        }
        return true;
    }
}
