package com.example.aptitudecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class divisibility extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divisibility);

        Button submit = findViewById(R.id.button_s);
        EditText number = findViewById(R.id.number);
        TextView out = findViewById(R.id.output);
        Button clear = findViewById(R.id.d_clear);


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                out.setText("");
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    String str_num = number.getText().toString();
                    float f_num = Float.parseFloat(str_num);
                    StringBuilder sb = new StringBuilder();
                    for(int i = 2;i<=(int)f_num/2;i++){
                        if(f_num%i==0){
                            sb.append("\n\n-> Divisible by "+i+"");

                        }
                    }
                    String output = sb.toString();
                    out.setText(output);
                    Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
                }catch(RuntimeException e){
                    Toast.makeText(getApplicationContext(),"Invlid Input",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}