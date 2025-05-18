package com.example.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Make sure you have this layout file

        // Initialize UI elements
        usernameEditText = findViewById(R.id.usernameEditText); // Replace with your actual IDs
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        messageTextView = findViewById(R.id.messageTextView);

        // Set click listener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            messageTextView.setText("Please enter both username and password");
            //Or use a Toast
            //Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show();

        } else {
            messageTextView.setText("Login Successful");
            // Or use a Toast
            //Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
        }
    }

    private String validateUsername(String username) {
        if (username.isEmpty()) {
            return "Username cannot be empty";
        }
        if (username.length() < 4) {
            return "Username must be at least 4 characters long";
        }
        // Add more rules as needed
        return null; // null means valid
    }

    private String validatePassword(String password) {
        if (password.isEmpty()) {
            return "Password cannot be empty";
        }
        if (password.length() < 8) {
            return "Password must be at least 8 characters long";
        }
        // Add more rules:  e.g., require a digit, a special character
        return null;
    }
}

