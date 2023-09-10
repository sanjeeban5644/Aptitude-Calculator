package com.example.aptitudecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class Apticalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apticalculator);


//        LottieAnimationView anim = findViewById(R.id.anim1);
//        anim.setAnimation("maths_anim.json");
//        anim.playAnimation();



        MediaPlayer transition = MediaPlayer.create(this,R.raw.transition2);
        try{
            transition.start();

            transition.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    transition.release();
                }
            });
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Media cannot be played",Toast.LENGTH_SHORT).show();
        }






        Button hcflcm = findViewById(R.id.hcf_lcm);
        Button profitloss = findViewById(R.id.profitloss);
        Button divisible = findViewById(R.id.divisibility);
        Button percentage = findViewById(R.id.percentages);
        Button speed = findViewById(R.id.speed);
        Button interest = findViewById(R.id.simplecompound);




        interest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Apticalculator.this,Interest.class);
                startActivity(intent);

            }
        });



        speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Apticalculator.this,speedtime.class);
                startActivity(intent);
            }
        });


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