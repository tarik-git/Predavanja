package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String HARDCODED_EMAIL = "erazmo@gmail.com";
    private static final String HARDCODED_PASSWORD = "Test123!";

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        loginButton.setOnClickListener(this::onLoginClickListener);

    }

    private void findViews() {
        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        loginButton = findViewById(R.id.login_button);
    }

    private void onLoginClickListener(View view) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (email == null || email.isEmpty()) {
            emailEditText.setError(getString(R.string.field_cannot_be_empty));
            return;
        }

        if (password == null || password.isEmpty()) {
            passwordEditText.setError(getString(R.string.field_cannot_be_empty));
            return;
        }

        boolean isAuthenticated = authenticate(email, password);

        if (isAuthenticated) {
            Intent intent = new Intent(getBaseContext(), SecondActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getBaseContext(), "Credentials are wrong", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean authenticate(String email, String password) {
        return HARDCODED_EMAIL.equals(email) && HARDCODED_PASSWORD.equals(password);
    }

}