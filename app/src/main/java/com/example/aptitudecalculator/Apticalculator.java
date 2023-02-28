package com.example.aptitudecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Apticalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apticalculator);

        Button hcflcm = findViewById(R.id.hcf_lcm);
        Button profitloss = findViewById(R.id.profitloss);
        Button divisible = findViewById(R.id.divisibility);
        Button percentage = findViewById(R.id.percentages);

        hcflcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Apticalculator.this,calc_hcflcm.class);
                startActivity(intent);
            }
        });

        profitloss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Apticalculator.this,ProfitLoss.class);
                startActivity(intent);
            }
        });

        divisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Apticalculator.this,divisibility.class);
                startActivity(intent);
            }
        });

        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Apticalculator.this,Percentages.class);
                startActivity(intent);
            }
        });

    }
}