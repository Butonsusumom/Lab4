package com.tsybulko.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String TEXT_KEY = "TEXT";
    public final static String BGD_KEY = "BGD";

    View mainLayout;
    TextView textColor;
    Button buttonBlue, buttonViolet, buttonPink;
    int currBackground = R.drawable.gradient_background_pink;

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
                currBackground = R.drawable.gradient_background_blue;
                mainLayout.setBackgroundResource(currBackground);
            }
        });

        buttonViolet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textColor.setText(strViolet);
                currBackground = R.drawable.gradient_background_violet;
                mainLayout.setBackgroundResource(currBackground);
            }
        });

        buttonPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textColor.setText(strPink);
                currBackground = R.drawable.gradient_background_pink;
                mainLayout.setBackgroundResource(currBackground);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TEXT_KEY,textColor.getText().toString());
        outState.putInt(BGD_KEY, currBackground);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedState) {
        super.onRestoreInstanceState(savedState);
        textColor.setText(savedState.getString(TEXT_KEY));
        mainLayout.setBackgroundResource(savedState.getInt(BGD_KEY));
    }
}