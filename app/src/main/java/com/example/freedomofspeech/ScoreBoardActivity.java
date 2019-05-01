package com.example.freedomofspeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ScoreBoardActivity extends AppCompatActivity {

    TextView scoreTitle;
    TextView actualScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        scoreTitle = findViewById(R.id.scoreTitle);
        actualScores = findViewById(R.id.actualScores);


        actualScores.setText(Integer.toString(MainActivity.score.size()));
    }


}
