package com.example.kockadobas;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
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
    private boolean isTwoDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        oneDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOneDice();
                isTwoDice=false;
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
                dice2.setVisibility(View.VISIBLE);
                isTwoDice=true;
            }
        });
        throwDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diceOneValue = (int) (Math.random() * 6) + 1;
                diceTwoValue = (int) (Math.random() * 6) + 1;
                if(isTwoDice){
                    setDiceValue(diceOneValue, dice1);
                    setDiceValue(diceTwoValue, dice2);
                    log.append(diceOneValue+diceTwoValue+" ("+diceOneValue+"+"+diceTwoValue+")\n");
                }else{
                    setDiceValue(diceOneValue, dice1);
                    log.append(diceOneValue+"\n");
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init();
            }
        });
    }

    private void setDiceValue(int diceValue, ImageView dice) {
        switch (diceValue) {
            case 1:
                dice.setImageResource(R.drawable.kocka1);
                break;
            case 2:
                dice.setImageResource(R.drawable.kocka2);
                break;
            case 3:
                dice.setImageResource(R.drawable.kocka3);
                break;
            case 4:
                dice.setImageResource(R.drawable.kocka4);
                break;
            case 5:
                dice.setImageResource(R.drawable.kocka5);
                break;
            case 6:
                dice.setImageResource(R.drawable.kocka6);
                break;

        }
    }

    private void setOneDice() {
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
        dice2.setVisibility(View.INVISIBLE);
    }

    private void init() {
        dice1 = findViewById(R.id.k1);
        dice2 = findViewById(R.id.k2);
        oneDice = findViewById(R.id.oneDice);
        twoDice = findViewById(R.id.twoDice);
        throwDice = findViewById(R.id.throwDice);
        reset = findViewById(R.id.reset);
        log = findViewById(R.id.log);

        dice1.setImageResource(R.drawable.kocka1);
        dice2.setImageResource(R.drawable.kocka1);
        log.setText("");

        //1 dice in the middle by default
        setOneDice();
        isTwoDice=false;

        diceOneValue = 0;
        diceTwoValue = 0;
    }
}