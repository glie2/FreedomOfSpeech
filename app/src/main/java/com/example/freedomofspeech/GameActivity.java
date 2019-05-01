package com.example.freedomofspeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mainWord;
    TextView jackpotNumber;
    TextView errorMessage;
    EditText guessBox;
    Button submitButton;
    TextView defBox;


    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        url = dictionaryEntries();

        mainWord = findViewById(R.id.mainWord);
        jackpotNumber = findViewById(R.id.jackpotNumber);
        errorMessage = findViewById(R.id.errorMessage);

        submitButton = findViewById(R.id.submitButton);

        //Initial State
        jackpotNumber.setText("1");

        submitButton.setOnClickListener(this);



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

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submitButton:
                guessBox = findViewById(R.id.guessBox);
                String word = guessBox.getText().toString();
                Log.d("shit", word);
                final String word_id = word.toLowerCase();
                url += word_id;
                Dictionary myDictionaryRequest = new Dictionary(this);
                myDictionaryRequest.execute(url);
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
                Log.d("fuck", Boolean.toString(myDictionaryRequest.validity));
                /*
                if (myDictionaryRequest.validity) {
                    // clear word, bring to top, next player
                } else {
                    // display error message
                }
                break;
            case R.id.jackpotNumber:
            */

        }
    }



    private String dictionaryEntries() {

        final String language = "en";
      //  final String word = "ace";
        // dictionary is case-sensitive, so this fixes it
        return "https://od-api.oxforddictionaries.com:443/api/v2/lemmas/" + language + "/";
    }

}
