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

//        hcflcm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Apticalculator.this,MainActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}