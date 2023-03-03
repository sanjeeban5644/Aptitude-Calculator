package com.example.aptitudecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class speedtime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speedtime);

        Button convert = findViewById(R.id.convert1);
        EditText kmvalue = findViewById(R.id.kminput);
        EditText mvalue = findViewById(R.id.minput);
        TextView answer = findViewById(R.id.ans_std);
        Button clear = findViewById(R.id.clear_std);


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kmvalue.setText("");
                mvalue.setText("");
                answer.setText("");
            }
        });

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String km = kmvalue.getText().toString();
                String m = mvalue.getText().toString();
                if(!km.equals("") && m.equals("")){
                    //convert km/hr to m/s
                    float km_val = Float.parseFloat(km);
                    float m_val=(km_val*5)/18;
                    answer.setText(Float.toString(km_val)+" km/hr is:  "+Float.toString(m_val)+" m/sec");


                }else if(!m.equals("") && km.equals("")){
                    //convert m/s to km/hr
                    float m_val = Float.parseFloat(m);
                    float km_val=(18*m_val)/5;
                    answer.setText(Float.toString(m_val)+" km/hr is:  "+Float.toString(km_val)+" m/sec");

                }else{
                    Toast.makeText(getApplicationContext(),"Invalid Input",Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}