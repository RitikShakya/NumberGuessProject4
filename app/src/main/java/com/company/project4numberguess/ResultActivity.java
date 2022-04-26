package com.company.project4numberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView result;

    Button playagain, exit;

    int attempts;
    int guesslft;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = findViewById(R.id.resulttext);

        playagain = findViewById(R.id.playagain);
        exit = findViewById(R.id.exit);

        Intent intent = getIntent();
        attempts =intent.getIntExtra("userattempts",0);
        guesslft = intent.getIntExtra("guessleft",0);
        if(guesslft==0){
            result.setText("Sorry You did not guess it right attempts   " + attempts +"Your all guesses were    "+ intent.getIntegerArrayListExtra("userguess"));
        }else {

            result.setText("Congratulations You guessed it right in attempts   " + attempts + "Your all guesses were    " + intent.getIntegerArrayListExtra("userguess"));
        }

        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}