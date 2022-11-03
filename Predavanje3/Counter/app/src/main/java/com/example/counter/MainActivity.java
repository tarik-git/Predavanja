package com.example.counter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String BUNDLE_COUNTER_VALUE = "BUNDLE_COUNTER_VALUE";
    int counterValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button toastButton = findViewById(R.id.toast_button);
        TextView counterTextView = findViewById(R.id.counter_text_view);
        Button countButton = findViewById(R.id.count_button);
        Button restartButton = findViewById(R.id.restart_button);
        Button decrementButton = findViewById(R.id.decrement_button);

        if (savedInstanceState != null) {
            counterValue = savedInstanceState.getInt(BUNDLE_COUNTER_VALUE);
            updatedCounterText();
        }

        toastButton.setOnClickListener(view -> {
                    String text = getString(R.string.toast_msg, counterValue);
                    Toast.makeText(getBaseContext(), text, Toast.LENGTH_SHORT).show();
                }
        );

        countButton.setOnClickListener(view -> {
            ++counterValue;
            updatedCounterText();
        });

        restartButton.setOnClickListener(view -> {
            counterValue = 0;
            updatedCounterText();
        });

        decrementButton.setOnClickListener(view -> {
            --counterValue;
            updatedCounterText();
        });

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void updatedCounterText() {
        TextView counterTextView = findViewById(R.id.counter_text_view);
        String counterValueString = counterValue + "";
        counterTextView.setText(counterValueString);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_COUNTER_VALUE, counterValue);
    }
}