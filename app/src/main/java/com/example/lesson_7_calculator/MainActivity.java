package com.example.lesson_7_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private TextView text;
    private Boolean isOperationClicked;
    private Boolean isPlusClicked;
    private Boolean isMinusClicked;
    private Boolean isDelitClicked;
    private Boolean isUmnojClicked;
    private ArrayList<Integer> sum = new ArrayList<>();
    private ArrayList<Integer> raz = new ArrayList<>();

    private ArrayList<Integer> umnoj = new ArrayList<>();

    private ArrayList<Integer> delit = new ArrayList<>();

    private MaterialButton btn_setRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.nolik);
        btn_setRes = findViewById(R.id.btn_setRes);

        btn_setRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String text1 = text.getText().toString();
                intent.putExtra("key1", text1);
                startActivity(intent);
            }
        });
    }

    public void OnNumberClick(View view) {
       if(view.getId() == R.id.btn_clear){
           text.setText("0");
           sum.clear();
           raz.clear();
           btn_setRes.setVisibility(View.GONE);
       }else if(view.getId() == R.id.btn_one){
           check(1);
       }else if(view.getId() == R.id.btn_two){
           check(2);
       } else if (view.getId() == R.id.btn_three) {
           check(3);
       }else if(view.getId() == R.id.btn_four){
           check(4);
       }else if(view.getId() == R.id.btn_five) {
           check(5);
       }else if(view.getId() == R.id.btn_six) {
           check(6);
       }else if(view.getId() == R.id.btn_seven) {
           check(7);
       }else if(view.getId() == R.id.btn_eight) {
           check(8);
       }else if(view.getId() == R.id.btn_nine) {
           check(9);
       }else if(view.getId() == R.id.btn_zero){
           check(0);
       }
        isOperationClicked = false;
    }

    public void check(int num){
        if(text.getText().toString().equals("0") || isOperationClicked){
            text.setText(Integer.toString(num));
        }else{
            text.append(Integer.toString(num));
        }
    }

    private int summa = 0;
    private int raznost = 0;
    private int umnojenie = 1;
    private int delenie;
    public void OnOrangeClick(View view) {
        if(view.getId() == R.id.btn_plus){
            isPlusClicked = true;
            sum.add(Integer.parseInt(text.getText().toString()));
            text.setText("0");
        }else if(view.getId() == R.id.btn_minus){
            isMinusClicked = true;
            raz.add(Integer.parseInt(text.getText().toString()));
            text.setText("0");
        }else if(view.getId() == R.id.btn_umnoj){
            isUmnojClicked = true;
            umnoj.add(Integer.parseInt(text.getText().toString()));
            text.setText("0");

        }else if(view.getId() == R.id.btn_delit){
            isDelitClicked = true;
            delit.add(Integer.parseInt(text.getText().toString()));
            text.setText("0");
        }

        else if (view.getId() == R.id.btn_ravno) {
            if (isPlusClicked){
                for (int number:sum) {
                    summa += number;
                }
                summa += Integer.parseInt(text.getText().toString());
                text.setText(Integer.toString(summa));
                sum.clear();
                summa = 0;
            }else if(isMinusClicked){
                raznost = raz.get(0);
                for (int j = 1; j < raz.size(); j++){
                    raznost -= raz.get(j);
                }
                 raznost -= Integer.parseInt(text.getText().toString());
                text.setText(Integer.toString(raznost));
                raz.clear();
                raznost = 0;
            }else if (isUmnojClicked){
                for (int number: umnoj) {
                    umnojenie *= number;
                }
                umnojenie *= Integer.parseInt(text.getText().toString());
                text.setText(Integer.toString(umnojenie));
                umnoj.clear();
                umnojenie = 1;
            }else if(isDelitClicked){
                delenie = delit.get(0);
                for (int k = 1; k < delit.size(); k++) {
                    delenie /= delit.get(k);
                }
                delenie /= Integer.parseInt(text.getText().toString());
                text.setText(Integer.toString(delenie));
                delit.clear();
            }

            btn_setRes.setVisibility(View.VISIBLE);

            isPlusClicked = false;
            isMinusClicked = false;
            isDelitClicked = false;
            isUmnojClicked = false;
        }
        isOperationClicked = true;
    }


}