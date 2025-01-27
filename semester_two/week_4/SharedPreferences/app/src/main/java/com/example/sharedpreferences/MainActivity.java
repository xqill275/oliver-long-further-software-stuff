package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;  // Add this import statement



public class MainActivity extends AppCompatActivity {
    String TAG = "MainActiity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button saveBtn = findViewById(R.id.Save);
        Button loadBtn = findViewById(R.id.Load);
    }

    public void onClickSave(View view) {
        EditText lname_edit = findViewById(R.id.LastName);
        EditText fname_edit = findViewById(R.id.FirstName);

        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();

        String lname = lname_edit.getText().toString();
        String fname = fname_edit.getText().toString();
        edit.putString("lname", lname);
        edit.putString("fname", fname);
        edit.apply();

        Toast.makeText(MainActivity.this, "Saved it", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onClickSave: Toast is an Android class which is used to display messages to the user");
    }

    public void onClickLoad(View view){
        TextView name_text = findViewById(R.id.textView);
        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        String lname = sp.getString("lname", "na");
        String fname = sp.getString("fname", "na");
        name_text.setText(String.format("%s, %s", lname, fname));

    }


}