package com.company.project4numberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RadioButton twodigit,threedigit,fourdigit;

    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);
        twodigit = findViewById(R.id.twodigit);
        threedigit = findViewById(R.id.threedigit);
        fourdigit = findViewById( R.id.fourdigit);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);

                if(!twodigit.isChecked() && !threedigit.isChecked() && !fourdigit.isChecked()){
                    Snackbar.make(view, "Please select digits", Snackbar.LENGTH_SHORT).show();

                }else{
                    if(twodigit.isChecked()){
                        intent.putExtra("two",true);
                    }
                    if(threedigit.isChecked()){
                        intent.putExtra("three",true);
                    }
                    if(fourdigit.isChecked()){
                        intent.putExtra("four",true);
                    }
                }

                startActivity(intent);
            }
        });

    }
}