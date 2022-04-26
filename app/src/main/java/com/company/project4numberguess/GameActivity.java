package com.company.project4numberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    TextView lastguess,hint,guess;

    EditText enterguess;

    Button confirm;

    boolean twodigit,threedigit,fourdigit;



    Random random= new Random();
    int numrandom;

    int userattempts;
    int guessleft=10;

    ArrayList<Integer> userguesses= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        lastguess = findViewById(R.id.lastguess);
        hint = findViewById(R.id.hint);
        guess = findViewById(R.id.Guess);

        enterguess = findViewById( R.id.guessenter);

        confirm = findViewById( R.id.button);
        Intent intent = getIntent() ;

        twodigit =intent.getBooleanExtra("two", false);
        threedigit =intent.getBooleanExtra("three", false);
        fourdigit = intent.getBooleanExtra("four", false);


        if(twodigit){
            numrandom = random.nextInt(90)+10;


        }if(threedigit){
            numrandom = random.nextInt(900)+100;

        }if(fourdigit){
            numrandom = random.nextInt(9000)+1000;
        }





        confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String userinput = enterguess.getText().toString();

                if(userinput.equals("")){
                    Toast.makeText(getApplicationContext(), "please enter guess", Toast.LENGTH_SHORT).show();
                }else{
                    lastguess.setVisibility(View.VISIBLE);
                    hint.setVisibility(View.VISIBLE);
                    userattempts++;
                    guessleft--;
                    int userguess = Integer.parseInt(userinput);

                    userguesses.add(userguess);
                    lastguess.setText("Your last guess " +userguess);
                    if(numrandom== userguess){

                        Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                        intent.putExtra("userattempts",userattempts);
                        intent.putExtra("userguess", userguesses);
                        intent.putExtra("guessleft", guessleft);
                        startActivity(intent);
                        finish();

                    }
                    if(numrandom> userguess){

                        hint.setText("Your guess is smaller, Try bigger ! Guess left"  +guessleft);


                    } if(numrandom < userguess){

                        hint.setText("Your guess is bigger, Try smaller ! Guess left"  +guessleft);
                    }
                    if(guessleft==0){


                        Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                        intent.putExtra("userattempts",userattempts);
                        intent.putExtra("userguess", userguesses);
                        intent.putExtra("guessleft",guessleft);
                        startActivity(intent);
                        finish();
                    }
                    enterguess.setText("");
                }










            }
        });

    }
}