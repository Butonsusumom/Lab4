package com.tsybulko.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    View mainLayout;
    TextView textColor;
    Button buttonBlue, buttonViolet, buttonPink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = (View) findViewById(R.id.mainLayout);
        textColor = (TextView) findViewById(R.id.textColor);
        buttonBlue = (Button) findViewById(R.id.buttonBlue);
        buttonViolet = (Button) findViewById(R.id.buttonViolet);
        buttonPink = (Button) findViewById(R.id.buttonPink);

        String strBlue = getResources().getString(R.string.blue);
        String strViolet = getResources().getString(R.string.violet);
        String strPink = getResources().getString(R.string.pink);

        buttonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textColor.setText(strBlue);
                mainLayout.setBackgroundResource(R.drawable.gradient_background_blue);
            }
        });

        buttonViolet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textColor.setText(strViolet);
                mainLayout.setBackgroundResource(R.drawable.gradient_background_violet);
            }
        });

        buttonPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textColor.setText(strPink);
                mainLayout.setBackgroundResource(R.drawable.gradient_background_pink);
            }
        });
    }

}