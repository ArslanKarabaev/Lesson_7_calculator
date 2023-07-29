package com.example.lesson_7_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String text1 = getIntent().getStringExtra("key1");
        TextView text_CP = findViewById(R.id.text_CP);
        text_CP.setText(text1);

        MaterialButton btn_destroy = findViewById(R.id.btn_destroy);
        btn_destroy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
    protected void onDestroy(){
        Process.killProcess(Process.myPid());
        super.onDestroy();
    }

}