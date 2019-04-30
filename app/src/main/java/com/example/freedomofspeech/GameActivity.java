package com.example.freedomofspeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class GameActivity extends AppCompatActivity {

    TextView mainWord;
    TextView jackpotNumber;
    TextView errorMessage;
    EditText guessBox;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mainWord = findViewById(R.id.mainWord);
        jackpotNumber = findViewById(R.id.jackpotNumber);
        errorMessage = findViewById(R.id.errorMessage);
        guessBox = findViewById(R.id.guessBox);
        submitButton = findViewById(R.id.submitButton);

        //Initial State
        jackpotNumber.setText("1");

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * When the submit button is clicked :
                 *
                 * 1) call Dictionary method to check if word is valid or not
                 * 2) If valid, increase jackpot counter and move onto next player screen
                 * 3) If invalid, display error message and refresh screen
                 */
            }
        });
    }
}
