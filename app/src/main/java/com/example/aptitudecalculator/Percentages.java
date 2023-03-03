package com.example.aptitudecalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Percentages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percentages);

        Button submit1 = findViewById(R.id.per_submit_1);
        Button submit2 = findViewById(R.id.per_submit_2);
        EditText percent = findViewById(R.id.per_pertoval);
        EditText value = findViewById(R.id.val_pertoval);
        TextView ans1 = findViewById(R.id.ans_pertoval);
        EditText val1 = findViewById(R.id.val1_valtoper);
        EditText val2 = findViewById(R.id.val2_valtoper);
        TextView ans2 = findViewById(R.id.ans_valtoper);
        Button clear = findViewById(R.id.clear_per);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = getIntent();
//                finish();
//                startActivity(intent);
                percent.setText("");
                value.setText("");
                ans1.setText("");
                val1.setText("");
                val2.setText("");
                ans2.setText("");
            }
        });

        //calculate percentage from value
        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String value_1 = val1.getText().toString();
                    String value_2 = val2.getText().toString();
                    float value1 = Float.parseFloat(value_1);
                    float value2 = Float.parseFloat(value_2);
                    float answer = ((value1/value2)*100);
                    ans2.setText(Float.toString(answer));

                }catch(IllegalArgumentException e){
                    Toast.makeText(getApplicationContext(),"Invalid Input",Toast.LENGTH_SHORT).show();
                }
            }
        });


        //calculate value from percentage
        submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String percentage = percent.getText().toString();
                    String totvalue = value.getText().toString();
                    float percentage_val = Float.parseFloat(percentage);
                    float tot_value = Float.parseFloat(totvalue);
                    float answer = ((percentage_val/100)*tot_value);
                    ans1.setText(Float.toString(answer));

                }catch(IllegalArgumentException e){
                    Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}