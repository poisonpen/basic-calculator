package com.example.thecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.*;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView answer;
    TextView input;
    ImageButton bcsp;
    Button clr1;
    Button clr2;
    Button plus;
    Button division;
    String currText = " ";

public String string;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answer = (TextView)findViewById(R.id.answer);
        input = (TextView)findViewById(R.id.input);
        bcsp = (ImageButton)findViewById(R.id.bcsp);
        clr1 = (Button)findViewById(R.id.clr1);
        clr2 = (Button)findViewById(R.id.clr2);
        plus = (Button)findViewById(R.id.plus);
        division = (Button)findViewById(R.id.division);
    }

    public void ShowText(View view) {
        Button button = (Button)view;
        String buttonText = button.getText().toString();
        currText = input.getText().toString();
        input.setText(currText+buttonText);

    }
    public void bcsp(View view) {
        currText = input.getText().toString();
        if ((currText != null) && (currText.length() > 0)) {
            input.setText(currText.substring(0, currText.length() - 1));
        }

    }

}

// show the plus / minus signs when clicked, and the equal sign evaluates
// split the function 123 + 456 = to (string1) (operator) (string 2)
// shrink the text to fit the view