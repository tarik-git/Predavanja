package com.example.loginapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_MESSAGE = 2134;

    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    private TextView nameTextView;
    private TextView surnameTextView;
    private TextView messageTextView;
    private Button changeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViews();
        nameTextView.setText("Tarik");
        surnameTextView.setText("Fazlic");

        changeButton.setOnClickListener(this::onChangeButtonClicked);

    }

    private void findViews() {
        nameTextView = findViewById(R.id.name_text_view);
        surnameTextView = findViewById(R.id.surname_text_view);
        messageTextView = findViewById(R.id.message_text_view);
        changeButton = findViewById(R.id.change_button);
    }

    private void onChangeButtonClicked(View view) {
        String message = messageTextView.getText().toString();
        Intent intent = new Intent(getBaseContext(), ThirdActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, REQUEST_CODE_MESSAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CODE_MESSAGE && data != null) {
                String message = data.getStringExtra(EXTRA_MESSAGE);
                messageTextView.setText(message);
            }
        }
    }
}