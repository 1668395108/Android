package com.example.software_testing;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText_a;
    private EditText editText_b;
    private EditText editText_c;
    private EditText editText_d;
    private EditText editText_x;
    private EditText editText_y;
    private TextView textView_a;
    private TextView textView_b;
    private TextView textView_c;
    private TextView textView_d;
    private TextView textView_x;
    private TextView textView_y;
    private String A,B,C,D,X,Y;
    private Integer a,b,c,d,x,y;
    private TextView textView_path;
    private  TextView textView_judge;
    private  TextView textView_condition;
    private Button testData;
    private Button Reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.editText_a=findViewById(R.id.editText2);this.textView_a=findViewById(R.id.textView9);

        editText_b=findViewById(R.id.editText4);textView_b=findViewById(R.id.textView10);

        editText_c=findViewById(R.id.editText5);textView_c=findViewById(R.id.textView11);

        editText_d=findViewById(R.id.editText7);textView_d=findViewById(R.id.textView12);

        editText_x=findViewById(R.id.editText8);textView_x=findViewById(R.id.textView22);

        editText_y=findViewById(R.id.editText9);textView_y=findViewById(R.id.textView23);

        textView_path=findViewById(R.id.textView25);textView_judge=findViewById(R.id.textView27);
        textView_condition=findViewById(R.id.textView29);
        testData=findViewById(R.id.button);
        testData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                A=editText_a.getText().toString();try{a= Integer.parseInt(A); }catch(Exception e){ return; }
                B=editText_b.getText().toString();try{b= Integer.parseInt(B); }catch(Exception e){ return; }
                C=editText_c.getText().toString();try{c= Integer.parseInt(C); }catch(Exception e){ return; }
                D=editText_d.getText().toString();try{d= Integer.parseInt(D);}catch(Exception e){ return; }
                X=editText_x.getText().toString();try{x= Integer.parseInt(X);}catch(Exception e){ return; }
                Y=editText_y.getText().toString();try{y= Integer.parseInt(Y); }catch(Exception e){ return; }
                textView_path.append("a");
                    if(a>1&&b<0)
                    {
                        x++;
                        textView_path.append("c");
                        textView_judge.append("M");
                    }
                    else
                    {
                        textView_path.append("b");
                        textView_judge.append("/M");
                    }
                    if(c==10||d!=5)
                    {
                        y=y/2;
                        textView_path.append("e");
                        textView_judge.append("N");
                    }
                    else
                    {
                        textView_path.append("d");
                        textView_judge.append("/N");
                    }

                    if(a>1)
                    {
                        textView_condition.append("T1");
                    }
                    else
                    {
                        textView_condition.append("F1");
                    }

                    if(b<0)
                    {
                        textView_condition.append("T2");
                    }
                    else
                    {
                        textView_condition.append("F2");
                    }

                    if(c==10)
                    {
                        textView_condition.append("T3");
                    }
                    else
                    {
                        textView_condition.append("F3");
                    }

                    if(d!=5)
                    {
                        textView_condition.append("T4");
                    }
                    else
                    {
                        textView_condition.append("F4");
                    }
                    X=Integer.toString(x); Y=Integer.toString(y);
                    textView_a.setText(A);textView_b.setText(B);textView_c.setText(C);
                    textView_d.setText(D);textView_x.setText(X);textView_y.setText(Y);
                }
        });
        Reset=findViewById(R.id.button2);
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText_a.setText("");editText_b.setText("");editText_c.setText("");editText_d.setText("");editText_x.setText("");editText_y.setText("");
                textView_a.setText("");textView_b.setText("");textView_c.setText("");textView_d.setText("");textView_x.setText("");textView_y.setText("");
                textView_condition.setText("");textView_judge.setText("");textView_path.setText("");
            }
        });
    }
}
