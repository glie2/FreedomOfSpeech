package com.example.freedomofspeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import java.util.Random;



public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mainWord;
    TextView jackpotNumber;
    TextView errorMessage;
    TextView playerNumberTag;
    EditText guessBox;
    Button submitButton;
    Button scoreboardButton;

    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        url = dictionaryEntries();

        mainWord = findViewById(R.id.mainWord);
        jackpotNumber = findViewById(R.id.jackpotNumber);
        errorMessage = findViewById(R.id.errorMessage);
        guessBox = findViewById(R.id.guessBox);
        submitButton = findViewById(R.id.submitButton);
        scoreboardButton = findViewById(R.id.scoreboardButton);
        playerNumberTag = findViewById(R.id.playerNumberTag);
        jackpotNumber.setText(Integer.toString(MainActivity.jackpot));
        //new

        initialize();

  /*      submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                /**
                 * When the submit button is clicked :
                 *
                 * 1) call Dictionary method to check if word is valid or not
                 * 2) If valid, increase jackpot counter and move onto next player screen
                 * 3) If invalid, display error message and refresh screen
                 *
            }
        });
        */
    }

    private void initialize () {
        //Sets up Screen w/ correct jackpot value, palyer id, word at top
        jackpotNumber.setText(Integer.toString(MainActivity.jackpot));
        playerNumberTag.setText("Player : " + (MainActivity.playerIndex + 1));
        errorMessage.setVisibility(TextView.INVISIBLE);
        //mainWord.setText(#getLastword)
        if (MainActivity.beginningOfGame) {
            Random randomStarter = new Random();
            int randIndex = randomStarter.nextInt(19);
            mainWord.setText(MainActivity.starterWords[randIndex]);
            MainActivity.previousWord = MainActivity.starterWords[randIndex];
            MainActivity.beginningOfGame = false;
        } else {
            mainWord.setText(MainActivity.previousWord);
        }



        submitButton.setOnClickListener(this);
        scoreboardButton.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submitButton:
                guessBox = findViewById(R.id.guessBox);
                String word = guessBox.getText().toString();
                //Log.d("shit", word);
                final String word_id = word.toLowerCase();
                url += word_id;
                Dictionary myDictionaryRequest = new Dictionary(this);
                myDictionaryRequest.execute(url);
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
                //If word passed is valid
                if (myDictionaryRequest.validity) {
                    //increment to next player
                    MainActivity.playerIndex++;
                    if (MainActivity.playerIndex >= MainActivity.numPlayers) {
                        MainActivity.playerIndex = 0;
                        MainActivity.jackpot+=1;
                    }
                    //make the "previousWord" this new word
                    MainActivity.previousWord = word;
                    finish();
                    startActivity(getIntent());
                } else {
                    errorMessage.setVisibility(TextView.VISIBLE);
                    for (int i = 0; i < MainActivity.scoreBoard.length; i++) {
                        if (i == MainActivity.playerIndex) {
                            continue;
                        }
                        MainActivity.scoreBoard[i] += MainActivity.jackpot;
                    }
                    MainActivity.jackpot = 1;
                }

                break;
            case R.id.scoreboardButton:
                startActivity(new Intent(GameActivity.this, ScoreBoardActivity.class));

        }
    }






    private String dictionaryEntries() {

        final String language = "en";
      //  final String word = "ace";
        // dictionary is case-sensitive, so this fixes it
        return "https://od-api.oxforddictionaries.com:443/api/v2/lemmas/" + language + "/";
    }

}
