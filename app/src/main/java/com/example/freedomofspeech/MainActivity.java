package com.example.freedomofspeech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    TextView numberOfPlayers;
    SeekBar seekBar;

    static List<Integer> score;
    static int jackpot = 1;
    static int numPlayers = 1;
    static int playerIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);
        numberOfPlayers = findViewById(R.id.numberOfPlayers);
        seekBar = findViewById(R.id.seekBar);

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

                score = new ArrayList<>(numPlayers);
                startActivity(new Intent(MainActivity.this, GameActivity.class));
            }
        });
    }
}
