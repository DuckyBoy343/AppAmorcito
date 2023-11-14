package com.example.apppreguntasdu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class ResultActivity extends AppCompatActivity {

    MaterialCardView home;
    TextView correctt, wrongt, resultinfo, resultscore;
    ImageView resultImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        home = findViewById(R.id.returnHome);
        correctt = findViewById(R.id.correctScore);
        wrongt = findViewById(R.id.wrongScore);
        resultinfo = findViewById(R.id.resultInfo);
        resultscore = findViewById(R.id.resultScore);
        resultImage = findViewById(R.id.resultImage);

        int correct = getIntent().getIntExtra("correct", 0);
        int wrong = getIntent().getIntExtra("wrong", 0);
        int score = correct;

        correctt.setText("" + correct);
        wrongt.setText("" + wrong);
        resultscore.setText("" + score);

        if (correct >= 0 && correct <= 1) {
            resultinfo.setText("Intentalo de nuevo amorcito <3");
            resultImage.setImageResource(R.drawable.sad);
        } else if (correct >= 1 && correct <= 2) {
            resultinfo.setText("Animo preciosa");
            resultImage.setImageResource(R.drawable.baseline_sentiment_neutral_24);
        } else if (correct >= 2 && correct <= 3) {
            resultinfo.setText("Eres muy buena <3");
            resultImage.setImageResource(R.drawable.smile);
        } else {
            resultinfo.setText("Eres increible amor :) <3");
            resultImage.setImageResource(R.drawable.smile);
        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ResultActivity.this, MainActivity.class));
        finish();
    }
}