package com.example.loginapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class ThirdActivity extends AppCompatActivity {

    private EditText messageEditText;
    private ImageButton saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        findViews();

        Intent intent = getIntent();
        String message = intent.getStringExtra(SecondActivity.EXTRA_MESSAGE);
        messageEditText.setText(message);

        saveButton.setOnClickListener(this::onSaveButtonClicked);

    }

    private void findViews() {
        messageEditText = findViewById(R.id.message_edit_text);
        saveButton = findViewById(R.id.save_button);
    }

    private void onSaveButtonClicked(View view) {
        String message = messageEditText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(SecondActivity.EXTRA_MESSAGE, message);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}