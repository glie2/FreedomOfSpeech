package com.example.freedomofspeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = findViewById(R.id.startButton);
        final TextView resultsTextView = findViewById(R.id.resultsTextView);
        SeekBar seekBar = findViewById(R.id.seekBar);

        /**
         * SeekBar : Dotted scroll bar for user to select the desired number of players
         */
        resultsTextView.setText("1");
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int numPlayers = progress + 1;
                String numPlayersStr = Integer.toString(numPlayers);
                resultsTextView.setText(numPlayersStr);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
