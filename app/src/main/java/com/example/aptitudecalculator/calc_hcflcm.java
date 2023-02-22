package com.example.aptitudecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class calc_hcflcm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_hcflcm);

        //dsa portion

        //String num ;
        List<Float> list = new ArrayList<>();
        Stack<Float> st = new Stack<>();


        //defing the buton and edittext and textview
        EditText inputnumber = findViewById(R.id.hcflcmenternumber);
        Button continue_entering = findViewById(R.id.continue_entering_hcflcm);
        Button submit = findViewById(R.id.submit_hcflcm);
        TextView display_hcf = findViewById(R.id.showhcf);
        TextView display_lcm = findViewById(R.id.showlcm);


        continue_entering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = inputnumber.getText().toString();
                try{
                        float val = Float.parseFloat(num);
                        st.push(val);
                        Toast.makeText(getApplicationContext(),"Number successfully added",Toast.LENGTH_SHORT).show();
                }catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Invalid Input",Toast.LENGTH_SHORT).show();

                }
                inputnumber.setText(null);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(st.isEmpty()){
                    Intent intent = new Intent(calc_hcflcm.this,Apticalculator.class);
                    startActivity(intent);
                }
                float temp_hcf = 1.0f;
                float temp_lcm = 0.0f;
                try{
                    temp_hcf = st.pop();
                    temp_lcm = temp_hcf;

                    while(!st.isEmpty()){
                        float num = st.pop();
                        float new_hcf = hcf(temp_hcf,num);
                        temp_hcf=new_hcf;
                        float new_lcm = lcm(temp_lcm,num);
                        temp_lcm=new_lcm;
                    }
                    //displaying the output;

                    display_hcf.setText("The HCF of the given numbers are: "+Float.toString(temp_hcf));
                    display_lcm.setText("The LCM of the given numbers are: "+Float.toString(temp_lcm));
                    Toast.makeText(getApplicationContext(),"Operation Performed successfully",Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),"Invalid",Toast.LENGTH_SHORT).show();
                    st.clear();
                }








            }


        });

    }

    private float hcf(float a,float b){
            float small = Math.min(a,b);
            float ans = 1;
            for(int i = 2;i<=small;i++){
                if(a%i==0 && b%i==0){
                    ans = i;
                }
            }
            return ans;

    }
    private float lcm(float a,float b){
        float gcd = hcf(a,b);
        return ((a*b)/gcd);
    }
}