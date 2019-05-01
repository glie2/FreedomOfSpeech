package com.example.freedomofspeech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Button startButton;
    Button rulesButton;
    TextView numberOfPlayers;
    SeekBar seekBar;
    Switch themeSwitch;

    static int[] scoreBoard = new int[8];
    static String starterWords[] = {"stress", "toys", "scant", "answer", "trap",
    "free", "sit", "unarmed", "detail", "romantic", "sign", "subtract", "impossible",
    "jolly", "kill", "beast", "dizzy", "lake", "few", "phobic"};
    static boolean beginningOfGame = true;
    static String previousWord;
    static ArrayList<String> usedWords;


    static int jackpot = 1;
    static int numPlayers = 1;
    static int playerIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darktheme);
        } else {
            setTheme(R.style.AppTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        themeSwitch = findViewById(R.id.themeSwitch);
        usedWords = new ArrayList<>();
        startButton = findViewById(R.id.startButton);
        rulesButton = findViewById(R.id.rules_button);
        numberOfPlayers = findViewById(R.id.numberOfPlayers);
        seekBar = findViewById(R.id.seekBar);

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            themeSwitch.setChecked(true);
        }
        themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    restartApp();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    restartApp();
                }
            }
        });
        /**
         * SeekBar : Dotted scroll bar for user to select the desired number of players
         */
        numberOfPlayers.setText("1");
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                numPlayers = progress + 1;
                numberOfPlayers.setText(Integer.toString(progress + 1));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        /**
         * startButton : Begins game by launching GameActivity screen
         */
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, GameActivity.class));
            }
        });
        /**
         * rulesButton: launches rules page
         */
        rulesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RulesActivity.class));
            }
        });
    }

    public void restartApp() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }
}
