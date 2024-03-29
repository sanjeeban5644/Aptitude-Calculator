package com.example.aptitudecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//
//}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LottieAnimationView animationView = findViewById(R.id.anim1);
        animationView.setAnimation(R.raw.maths_anim2);
        animationView.playAnimation(); // Optional: Play the animation programmatically




        // Get the Button view from the layout
        Button myButton = findViewById(R.id.my_button);
//
        // Set a click listener to navigate to another activity
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Apticalculator.class);
                startActivity(intent);
            }
        });
    }
}
