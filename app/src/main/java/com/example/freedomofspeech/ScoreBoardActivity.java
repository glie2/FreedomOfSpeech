package com.example.freedomofspeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreBoardActivity extends AppCompatActivity {

    // text boxes for the scoreboard
    TextView scoreTitle;
    TextView p1score;
    TextView p2score;
    TextView p3score;
    TextView p4score;
    TextView p5score;
    TextView p6score;
    TextView p7score;
    TextView p8score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        // the number of players participating
        int numberOfPlayers = MainActivity.numPlayers;

        // variables for the text boxes on the scoreboard
        scoreTitle = findViewById(R.id.scoreTitle);
        p1score = findViewById(R.id.player1score);
        p2score = findViewById(R.id.player2score);
        p3score = findViewById(R.id.player3score);
        p4score = findViewById(R.id.player4score);
        p5score = findViewById(R.id.player5score);
        p6score = findViewById(R.id.player6score);
        p7score = findViewById(R.id.player7score);
        p8score = findViewById(R.id.player8score);

        p1score.setText("Player 1 score: " + Integer.toString(MainActivity.scoreBoard[0]));
        p2score.setText("Player 2 score: " + Integer.toString(MainActivity.scoreBoard[1]));
        p3score.setText("Player 3 score: " + Integer.toString(MainActivity.scoreBoard[2]));
        p4score.setText("Player 4 score: " + Integer.toString(MainActivity.scoreBoard[3]));
        p5score.setText("Player 5 score: " + Integer.toString(MainActivity.scoreBoard[4]));
        p6score.setText("Player 6 score: " + Integer.toString(MainActivity.scoreBoard[5]));
        p7score.setText("Player 7 score: " + Integer.toString(MainActivity.scoreBoard[6]));
        p8score.setText("Player 8 score: " + Integer.toString(MainActivity.scoreBoard[7]));



        // set scoreboard according to how many people are playing
        if (numberOfPlayers < 8) {
            p8score.setVisibility(View.INVISIBLE);
        }
        if (numberOfPlayers < 7) {
            p7score.setVisibility(View.INVISIBLE);
        }
        if (numberOfPlayers < 6) {
            p6score.setVisibility(View.INVISIBLE);
        }
        if (numberOfPlayers < 5) {
            p5score.setVisibility(View.INVISIBLE);
        }
        if (numberOfPlayers < 4) {
            p4score.setVisibility(View.INVISIBLE);
        }
        if (numberOfPlayers < 3) {
            p3score.setVisibility(View.INVISIBLE);
        }
        if (numberOfPlayers < 2) {
            p2score.setVisibility(View.INVISIBLE);
        }
    }


}
