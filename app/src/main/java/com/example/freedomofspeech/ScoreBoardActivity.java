package com.example.freedomofspeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ScoreBoardActivity extends AppCompatActivity {

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

        scoreTitle = findViewById(R.id.scoreTitle);
        p1score = findViewById(R.id.player1score);
        p2score = findViewById(R.id.player2score);
        p3score = findViewById(R.id.player3score);
        p4score = findViewById(R.id.player4score);
        p5score = findViewById(R.id.player5score);
        p6score = findViewById(R.id.player6score);
        p7score = findViewById(R.id.player7score);
        p8score = findViewById(R.id.player8score);
    }


}
