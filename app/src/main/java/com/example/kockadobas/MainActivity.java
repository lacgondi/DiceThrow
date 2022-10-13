package com.example.kockadobas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView dice1;
    private ImageView dice2;
    private Button oneDice;
    private Button twoDice;
    private Button throwDice;
    private Button reset;
    private TextView log;

    private int diceOneValue;
    private int diceTwoValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        oneDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOneDice();
            }
        });
        twoDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dice1.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        0.5f
                ));
                dice2.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        0.5f
                ));
                dice2.setImageResource(R.drawable.kocka1);
            }
        });
        throwDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init();
            }
        });
    }

    private void setOneDice(){
        dice1.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                1.0f
        ));
        dice2.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                0f
        ));
    }

    private void init(){
        dice1=findViewById(R.id.k1);
        dice2=findViewById(R.id.k2);
        oneDice=findViewById(R.id.oneDice);
        twoDice=findViewById(R.id.twoDice);
        throwDice = findViewById(R.id.throwDice);
        reset = findViewById(R.id.reset);
        log=findViewById(R.id.log);
        dice1.setImageResource(R.drawable.kocka1);

        //1 dice in the middle by default
        setOneDice();

        diceOneValue=0;
        diceTwoValue=0;
    }
}