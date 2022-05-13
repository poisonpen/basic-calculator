package com.example.thecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
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
    Button times;
    Button minus;
    String currText = "";
    String operate = "";
    Button equal;
    float num1;
    float num2;
    String first = "yes";

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
        times = (Button)findViewById(R.id.times);
        minus = (Button)findViewById(R.id.minus);
        equal = (Button)findViewById(R.id.equal);
    }

    public void ShowText(View view) {
        Button button = (Button)view;
        String buttonText = button.getText().toString();
        currText = input.getText().toString();
        Log.v("inputstring",currText);
        if (currText == "0") {
            input.setText(buttonText);
        } else {
            input.setText(currText+buttonText);
        }

        currText = input.getText().toString();
    }

    public void bcsp(View view) {
        currText = input.getText().toString();
        if ((currText != null) && (currText.length() > 0)) {
            input.setText(currText.substring(0, currText.length() - 1));
            currText = input.getText().toString();
        }
    }

    public void plus(View view) {
        num1 = Float.parseFloat(currText); // difficult
        operate = "+";
        input.setText("");
        answer.setText(num1+" +");
    }
    public void division(View view) {
        num1 = Float.parseFloat(currText);
        operate = "/";
        input.setText("");
        answer.setText(num1+" ÷");
    }
    public void minus(View view) {
        num1 = Float.parseFloat(currText);
        operate = "-";
        input.setText("");
        answer.setText(num1+" -");
    }
    public void times(View view) {
        num1 = Float.parseFloat(currText);
        operate = "*";
        input.setText("");
        answer.setText(num1+" x");
    }

    public void equal(View view) {
        if (operate=="+") {
            num2 = Float.parseFloat(input.getText().toString());
            input.setText(num1+num2+"");
        } else if (operate=="-") {
            num2 = Float.parseFloat(input.getText().toString());
            input.setText(num1-num2+"");
        }
        else if (operate=="/") {
            num2 = Float.parseFloat(input.getText().toString());
            input.setText(num1/num2+"");
        }
        else if (operate=="*") {
            num2 = Float.parseFloat(input.getText().toString());
            input.setText(num1*num2+"");
        } else {
            input.setText("whaat?");
        }
        currText = input.getText().toString();
        input.setText(currText);
        answer.setText(currText);
    }

    public void clear(View view) {
        num1 = 0;
        num2 = 0;
    }


}

// if it can be reduced to
// split the function 123 + 456 = to (string1) (operator) (string 2)
// shrink the text to fit the view