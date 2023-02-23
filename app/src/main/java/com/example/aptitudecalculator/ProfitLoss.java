package com.example.aptitudecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

                if(space>4){

                }

            }
        });


    }
}