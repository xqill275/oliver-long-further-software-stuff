package com.example.session_two;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    Button sendButton;
    TextInputEditText subjectText;
    TextInputEditText messageText;
    TextInputEditText emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendButton = findViewById(R.id.button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailText = findViewById(R.id.EmailText);
                subjectText = findViewById(R.id.textInputEditText);
                messageText = findViewById(R.id.textInputEditText2);
                String emailContent = String.valueOf(emailText.getText());
                String subjectContent = String.valueOf(subjectText.getText());
                String messageContent = String.valueOf(messageText.getText());
                String message = "";
                if (emailContent.isEmpty()) {
                    message = "Error: no email address entered";
                } else if (subjectContent.isEmpty()) {
                    message = "Error: no Subject entered";
                } else if (messageContent.isEmpty()) {
                    message = "Error: no message enetered";
                } else {
                    message = "Succsess: message sent";
                }


                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}