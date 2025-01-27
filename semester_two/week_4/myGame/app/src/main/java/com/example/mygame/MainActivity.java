package com.example.mygame;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";  // Tag for logging lifecycle events

    private TextView scoreTextView;  // UI element to display the score
    private int score = 0;  // Variable to store the current game score
    private boolean isPlaying = false;  // Flag to track if the game is running
    private Handler gameHandler = new Handler();  // Handler to schedule repeated tasks


    // Runnable task that updates the score every second
    private Runnable gameRunnable = new Runnable() {
        @Override
        public void run() {
            if (isPlaying) {  // Check if the game is active
                score++;  // Increase the score by 1
                scoreTextView.setText("Score: " + score);  // Update score display
                gameHandler.postDelayed(this, 1000);  // Run again after 1 second
            }
        }
    };

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

        scoreTextView = findViewById(R.id.scoreTextView);  // Find the TextView by ID

        // Restore saved state if available (e.g., after a screen rotation)
        if (savedInstanceState != null) {
            score = savedInstanceState.getInt("SCORE");  // Retrieve saved score
            isPlaying = savedInstanceState.getBoolean("IS_PLAYING");  // Retrieve playing state
            scoreTextView.setText("Score: " + score);  // Update UI with restored score
            Log.d(TAG, "State restored: Score = " + score);  // Log restoration
        }

        Log.d(TAG, "onCreate called");  // Log activity creation

    }

    // Called when the activity becomes visible to the user
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart called - Game visible");
    }

    // Called when the user starts interacting with the app
    @Override
    protected void onResume() {
        super.onResume();
        isPlaying = true;  // Set the game to active
        gameHandler.post(gameRunnable);  // Start updating the score
        Log.d(TAG, "onResume called - Game running");
    }

    // Called when the app goes into the background (e.g., home button pressed)
    @Override
    protected void onPause() {
        super.onPause();
        isPlaying = false;  // Pause the game
        gameHandler.removeCallbacks(gameRunnable);  // Stop score updates
        Log.d(TAG, "onPause called - Game paused");
    }

    // Called when the app is no longer visible to the user
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called - Game hidden");
    }

    // Called when the app is being destroyed (e.g., manually closed)
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called - Game closed");
    }

    // Save the game state when the app is about to be stopped or restarted
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("SCORE", score);  // Save current score
        outState.putBoolean("IS_PLAYING", isPlaying);  // Save playing state
        Log.d(TAG, "onSaveInstanceState: Score saved = " + score);
    }

    // Restore the game state when the activity is recreated (e.g., after rotation)
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        score = savedInstanceState.getInt("SCORE");  // Restore saved score
        isPlaying = savedInstanceState.getBoolean("IS_PLAYING");  // Restore playing state
        scoreTextView.setText("Score: " + score);  // Update UI with restored score
        Log.d(TAG, "onRestoreInstanceState: Score restored = " + score);
    }
}