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
import java.math.BigDecimal;

public class calc_hcflcm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_hcflcm);

        //dsa portion

        //String num ;
        List<Float> list = new ArrayList<>();
        Stack<Float> st = new Stack<>();
        final int[] max_scale = {0};


        //defing the buton and edittext and textview
        EditText inputnumber = findViewById(R.id.hcflcmenternumber);
        Button continue_entering = findViewById(R.id.continue_entering_hcflcm);
        Button submit = findViewById(R.id.submit_hcflcm);
        TextView display_hcf = findViewById(R.id.showhcf);
        TextView display_lcm = findViewById(R.id.showlcm);
        Button clear = findViewById(R.id.clear_1);


        continue_entering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String num = inputnumber.getText().toString();
                try{
                        float val = Float.parseFloat(num);
                        BigDecimal bd = new BigDecimal(num);
                        int sc = bd.scale();
                        if(sc> max_scale[0]) max_scale[0] =sc;
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
//                if(st.isEmpty()){
//                    Intent intent = new Intent(calc_hcflcm.this,Apticalculator.class);
//                    startActivity(intent);
//                }


                float temp_hcf = 1.0f;
                float temp_lcm = 0.0f;
                try{
                    float t = st.pop();
                    for(int i = 1;i<=max_scale[0];i++){
                        t*=10;
                    }
                    temp_hcf = t;
                    temp_lcm = temp_hcf;

                    while(!st.isEmpty()){

                        float num = st.pop();

                        for(int i = 1; i<= max_scale[0]; i++){
                            num*=10;
                        }

                        float new_hcf = hcf(temp_hcf,num);
                        temp_hcf=new_hcf;
                        float new_lcm = lcm(temp_lcm,num);
                        temp_lcm=new_lcm;
                    }
                    //calculating the output;
                    for(int i = 1;i<=max_scale[0];i++){
                        temp_hcf/=10;
                    }
                    for(int i = 1;i<=max_scale[0];i++){
                        temp_lcm/=10;
                    }


                    //displaying the output;

                    display_hcf.setText("HCF : "+Float.toString(temp_hcf));
                    display_lcm.setText("LCM : "+Float.toString(temp_lcm));
                    Toast.makeText(getApplicationContext(),"Operation Performed successfully",Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),"Invalid",Toast.LENGTH_SHORT).show();
                    st.clear();
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st.clear();
                display_hcf.setText("");
                display_lcm.setText("");
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