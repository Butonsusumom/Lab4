package com.tsybulko.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String TEXT_KEY = "TEXT";
    public final static String BGD_KEY = "BGD";

    private View mainLayout;
    private TextView textColor;
    private Button buttonBlue, buttonViolet, buttonPink;

    private String strBlue,strViolet,strPink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = (View) findViewById(R.id.mainLayout);
        textColor = (TextView) findViewById(R.id.textColor);
        buttonBlue = (Button) findViewById(R.id.buttonBlue);
        buttonViolet = (Button) findViewById(R.id.buttonViolet);
        buttonPink = (Button) findViewById(R.id.buttonPink);

        strBlue = getResources().getString(R.string.blue);
        strViolet = getResources().getString(R.string.violet);
        strPink = getResources().getString(R.string.pink);

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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Drawable bgd = mainLayout.getBackground();
        outState.putString(TEXT_KEY,textColor.getText().toString());
        outState.putInt(BGD_KEY, getCurrBackground());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedState) {
        super.onRestoreInstanceState(savedState);
        textColor.setText(savedState.getString(TEXT_KEY));
        mainLayout.setBackgroundResource(savedState.getInt(BGD_KEY));
    }

    private int getCurrBackground(){
        switch (textColor.getText().toString()){
            case "Blue" : return  R.drawable.gradient_background_blue;
            case "Violet" : return  R.drawable.gradient_background_violet;
            case "Pink" : return  R.drawable.gradient_background_pink;
            default:
                return 0;
        }
    }
}