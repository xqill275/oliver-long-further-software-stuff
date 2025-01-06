package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button timesButton;
    Button addButton;
    Button subButton;
    TextView resultText;
    EditText numberInput1;
    EditText numberInput2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        numberInput1 = findViewById(R.id.editTextNumber);
        numberInput2 = findViewById(R.id.editTextNumber2);
        resultText = findViewById(R.id.textViewResult);
        addButton = findViewById(R.id.buttonPlus);
        subButton = findViewById(R.id.buttonMinus);
        timesButton = findViewById(R.id.buttonTimes);
    }

    public void Minus(View view) {
       int num1 = Integer.parseInt(numberInput1.getText().toString());
       int num2 = Integer.parseInt(numberInput2.getText().toString());
       int temp = num1 - num2;
        resultText.setText(String.valueOf(temp));

    }

    public void Times(View view) {
        int num1 = Integer.parseInt(numberInput1.getText().toString());
        int num2 = Integer.parseInt(numberInput2.getText().toString());
        int temp = num1 * num2;
        resultText.setText(String.valueOf(temp));
    }

    public void Add(View view) {
        int num1 = Integer.parseInt(numberInput1.getText().toString());
        int num2 = Integer.parseInt(numberInput2.getText().toString());
        int temp = num1 + num2;
        resultText.setText(String.valueOf(temp));
    }

    public void Divide(View view) {
        int num1 = Integer.parseInt(numberInput1.getText().toString());
        int num2 = Integer.parseInt(numberInput2.getText().toString());
        int temp = num1 / num2;
        resultText.setText(String.valueOf(temp));
    }
}