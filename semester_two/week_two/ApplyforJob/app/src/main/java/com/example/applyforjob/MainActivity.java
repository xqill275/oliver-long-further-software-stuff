package com.example.applyforjob;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    Button applyButton;
    TextInputEditText firstName;
    TextInputEditText lastName;
    TextInputEditText dob;
    TextInputEditText country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        applyButton = findViewById(R.id.applyButton);
        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName = findViewById(R.id.firstName);
                lastName = findViewById(R.id.lastName);
                country = findViewById(R.id.countryID);

                Toast.makeText(MainActivity.this, "Applied Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}