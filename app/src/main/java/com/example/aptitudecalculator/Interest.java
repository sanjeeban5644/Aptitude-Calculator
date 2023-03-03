package com.example.aptitudecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Interest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        EditText si_i = findViewById(R.id.si_input);
        EditText r_i = findViewById(R.id.rate_input);
        EditText t_i = findViewById(R.id.time_input);
        EditText a_i = findViewById(R.id.amount_input);
        Button cal1 = findViewById(R.id.calculate_si);
        TextView ans1 = findViewById(R.id.ans_si);
        Button clear = findViewById(R.id.si_clear);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                si_i.setText("");
                r_i.setText("");
                t_i.setText("");
                a_i.setText("");
                ans1.setText("");
            }
        });



        cal1.setOnClickListener(new View.OnClickListener() {
            int em = 0;
            @Override
            public void onClick(View view) {
                String s_si = si_i.getText().toString(); if(s_si.equals("")) em++;
                String s_r = r_i.getText().toString(); if(s_r.equals("")) em++;
                String s_t = t_i.getText().toString();  if(s_t.equals("")) em++;
                String s_a = a_i.getText().toString();  if(s_a.equals("")) em++;
                int full = 4-em;
                if(full>=3){
                    float si = 0.0f;
                    float r = 0.0f;
                    float t = 0.0f;
                    float p = 0.0f;
                    if(s_si.equals("")){
                        r = Float.parseFloat(s_r);
                        t = Float.parseFloat(s_t);
                        p = Float.parseFloat(s_a);
                        si = (p*r*t)/100;
                        ans1.setText("SI is: "+Float.toString(si)+" & Amount is: "+Float.toString(si+p));
                    }else if(s_r.equals("")){
                        si = Float.parseFloat(s_si);
                        t = Float.parseFloat(s_t);
                        p = Float.parseFloat(s_a);
                        r = (si*100)/(p*t);
                        ans1.setText("Rate of Interest is: "+Float.toString(r)+"% & Amount is: "+Float.toString(si+p));
                    }else if(s_t.equals("")){
                        si = Float.parseFloat(s_si);
                        r = Float.parseFloat(s_r);
                        p = Float.parseFloat(s_a);
                        t = (si*100)/(p*r);
                        ans1.setText("Time Period is: "+Float.toString(t)+"years & Amount is: "+Float.toString(si+p));
                    }else if(s_a.equals("")){
                        si = Float.parseFloat(s_si);
                        r = Float.parseFloat(s_r);
                        t = Float.parseFloat(s_t);
                        p = (si*100)/(r*t);
                        ans1.setText("Principal is: "+Float.toString(p)+" & Amount is: "+Float.toString(si+p));
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Invalid Input",Toast.LENGTH_SHORT).show();
                }
            }
        });






    }
}