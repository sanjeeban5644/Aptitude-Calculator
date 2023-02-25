package com.example.aptitudecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ProfitLoss extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profit_loss);



        EditText profit_i = findViewById(R.id.profit_i);
        EditText loss_i = findViewById(R.id.loss_i);
        EditText profitper = findViewById(R.id.profit_p);
        EditText lossper = findViewById(R.id.loss_p);
        EditText cp = findViewById(R.id.cp);
        EditText sp = findViewById(R.id.sp);
        Button submit = findViewById(R.id.pl_submit);
        Button clear = findViewById(R.id.pl_clear);
        //answers
        TextView plheading = findViewById(R.id.plheading);
        TextView plperheading = findViewById(R.id.plperheading);
        TextView plval = findViewById(R.id.plvalue);
        TextView plperval = findViewById(R.id.plpervalue);
        TextView spheading = findViewById(R.id.spheading);
        TextView cpheading = findViewById(R.id.cpheading);
        TextView sellpval = findViewById(R.id.spvalue);
        TextView costpval = findViewById(R.id.cpvalue);


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profit_i.setText("");
                loss_i.setText("");
                profitper.setText("");
                lossper.setText("");
                cp.setText("");
                sp.setText("");
                plheading.setText("");
                plperheading.setText("");
                plval.setText("");
                plperval.setText("");
                spheading.setText("");
                cpheading.setText("");
                sellpval.setText("");
                costpval.setText("");
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int space=0;
                String profit = profit_i.getText().toString();  if(profit.equals("")) space++;
                String loss = loss_i.getText().toString(); if(loss.equals("")) space++;
                String pp = profitper.getText().toString();  if(pp.equals("")) space++;
                String lp = lossper.getText().toString();   if(lp.equals("")) space++;
                String costprice = cp.getText().toString();   if(costprice.equals("")) space++;
                String sellprice = sp.getText().toString();  if(sellprice.equals("")) space++;
                float g_p=0.0f;
                float g_l=0.0f;
                float g_pp=0.0f;
                float g_lp=0.0f;
                float g_sp=0.0f;
                float g_cp=0.0f;
                int fill = 6-space;
                if(fill>=2){
                     if(!profit.isEmpty() && !sellprice.isEmpty()){
                         g_p=Float.parseFloat(profit);
                         g_sp=Float.parseFloat(sellprice);
                         g_cp=g_sp-g_p;
                         g_pp=calc_pper(g_sp,g_cp);
                         display_profit(g_cp,g_sp,g_p,g_pp);
                     }else if(!profit.isEmpty() && !costprice.isEmpty()){
                         g_p=Float.parseFloat(profit);
                         g_cp=Float.parseFloat(costprice);
                         g_sp=g_p+g_cp;
                         g_pp=calc_pper(g_sp,g_cp);
                         display_profit(g_cp,g_sp,g_p,g_pp);
                     }else if(!pp.isEmpty() && !sellprice.isEmpty()){
                         g_pp=Float.parseFloat(pp);
                         g_sp=Float.parseFloat(sellprice);
                         g_cp=((100/(g_pp+100))*g_sp);
                         g_p=g_sp-g_cp;
                         display_profit(g_cp,g_sp,g_p,g_pp);
                     }else if(!pp.isEmpty() && !costprice.isEmpty()){
                         g_pp=Float.parseFloat(pp);
                         g_cp=Float.parseFloat(costprice);
                         g_sp=(((g_pp/100)+1)*g_cp);
                         g_p=g_sp-g_cp;
                         display_profit(g_cp,g_sp,g_p,g_pp);
                     }else if(!profit.isEmpty() && !pp.isEmpty()){
                         g_p=Float.parseFloat(profit);
                         g_pp=Float.parseFloat(pp);
                         g_cp=((100/g_pp)*g_p);
                         g_sp=g_p+g_cp;
                         display_profit(g_cp,g_sp,g_p,g_pp);
                     }else if(!loss.isEmpty() && !sellprice.isEmpty()){
                         g_l=Float.parseFloat(loss);
                         g_sp=Float.parseFloat(sellprice);
                         g_cp=g_l+g_sp;
                         g_lp=calc_lper(g_sp,g_cp);
                         display_loss(g_cp,g_sp,g_l,g_lp);
                     }else if(!loss.isEmpty() && !costprice.isEmpty()){
                         g_l=Float.parseFloat(loss);
                         g_cp=Float.parseFloat(costprice);
                         g_sp=g_cp-g_l;
                         g_lp=calc_lper(g_sp,g_cp);
                         display_loss(g_cp,g_sp,g_l,g_lp);
                     }else if(!lp.isEmpty() && !sellprice.isEmpty()){
                         g_lp=Float.parseFloat(lp);
                         g_sp=Float.parseFloat(sellprice);
                         g_cp=((g_sp*100)/(100-g_lp));
                         g_l=g_cp-g_sp;
                         display_loss(g_cp,g_sp,g_l,g_lp);
                     }else if(!lp.isEmpty() && !costprice.isEmpty()){
                         g_lp=Float.parseFloat(lp);
                         g_cp=Float.parseFloat(costprice);
                         g_sp=(1-(g_lp/100))*g_cp;
                         g_l=g_cp-g_sp;
                         display_loss(g_cp,g_sp,g_l,g_lp);
                     }else if(!loss.isEmpty() && !lp.isEmpty()){
                         g_l=Float.parseFloat(loss);
                         g_lp=Float.parseFloat(lp);
                         g_cp=(g_l*100)/g_lp;
                         g_sp=g_cp-g_l;
                         display_loss(g_cp,g_sp,g_l,g_lp);
                     }else if(!costprice.isEmpty() && !sellprice.isEmpty()){
                         g_cp=Float.parseFloat(costprice);
                         g_sp=Float.parseFloat(sellprice);
                         if(g_cp>g_sp){
                             g_l=g_cp-g_sp;
                             g_lp=calc_lper(g_sp,g_cp);
                             display_loss(g_cp,g_sp,g_l,g_lp);
                         }else{
                             g_p=g_sp-g_cp;
                             g_pp=calc_pper(g_sp,g_cp);
                             display_profit(g_cp,g_sp,g_p,g_pp);
                         }
                     }
                     Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
                }else{
                    //invalid output toast
                    Toast.makeText(getApplicationContext(),"Inadequate or Invalid Data",Toast.LENGTH_SHORT).show();
                }

            }

            //functions here
                float calc_pper(float sp,float cp){
                    return ((sp/cp)-1)*100;
                }
                float calc_lper(float sp,float cp){
                    return ((1-(sp/cp))*100);
                }
                void display_profit(float cp,float sp,float p,float pp){
                    plheading.setText("Profit");
                    plval.setText(Float.toString(p));
                    plperheading.setText("Profit %");
                    plperval.setText(Float.toString(pp)+"%");
                    spheading.setText("Selling Price");
                    sellpval.setText(Float.toString(sp));
                    cpheading.setText("Cost Price");
                    costpval.setText(Float.toString(cp));
                }
            void display_loss(float cp,float sp,float l,float lp){
                plheading.setText("Loss");
                plval.setText(Float.toString(l));
                plperheading.setText("Loss %");
                plperval.setText(Float.toString(lp)+"%");
                spheading.setText("Selling Price");
                sellpval.setText(Float.toString(sp));
                cpheading.setText("Cost Price");
                costpval.setText(Float.toString(cp));
            }
            //till here
        });


    }
}