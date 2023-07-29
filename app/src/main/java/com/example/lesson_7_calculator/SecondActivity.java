package com.example.lesson_7_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String text1 = getIntent().getStringExtra("key1");
        TextView text_CP = findViewById(R.id.text_CP);
        text_CP.setText(text1);

    }


}