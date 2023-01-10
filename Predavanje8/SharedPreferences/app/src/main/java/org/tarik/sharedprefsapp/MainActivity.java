package org.tarik.sharedprefsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import org.tarik.sharedprefsapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String BUNDLE_COUNT_KEY = "BUNDLE_COUNT_KEY";
    private static final String BUNDLE_COLOR_KEY = "BUNDLE_COLOR_KEY";
    private static final String SHARED_PREF_FILE_NAME = "org.tarik.sharedprefsapp";

    private ActivityMainBinding binding;

    private int mCount = 0;
    private int mColor;

    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences(SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE);

        mColor = ContextCompat.getColor(this, R.color.default_background);

        binding.blackBackgroundButton.setOnClickListener(v -> changeBackground(v, getResources().getColor(R.color.black)));
        binding.redBackgroundButton.setOnClickListener(v -> changeBackground(v, getResources().getColor(R.color.red_background)));
        binding.blueBackgroundButton.setOnClickListener(v -> changeBackground(v, getResources().getColor(R.color.blue_background)));
        binding.greenBackgroundButton.setOnClickListener(v -> changeBackground(v, getResources().getColor(R.color.green_background)));

        binding.countButton.setOnClickListener(this::countUp);
        binding.resetButton.setOnClickListener(this::reset);

        mCount = sharedPreferences.getInt(BUNDLE_COUNT_KEY, 0);
        binding.countTextview.setText(String.format("%s", mCount));
        mColor = sharedPreferences.getInt(BUNDLE_COLOR_KEY, mColor);
        binding.countTextview.setBackgroundColor(mColor);

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(BUNDLE_COUNT_KEY, mCount);
        editor.putInt(BUNDLE_COLOR_KEY, mColor);

        editor.apply();
    }

    public void changeBackground(View view, int color) {

        binding.countTextview.setBackgroundColor(color);
        mColor = color;
    }


    public void countUp(View view) {
        mCount++;
        binding.countTextview.setText(String.format("%s", mCount));
    }

    public void reset(View view) {
        mCount = 0;
        binding.countTextview.setText(String.format("%s", mCount));
        mColor = ContextCompat.getColor(this, R.color.default_background);
        binding.countTextview.setBackgroundColor(mColor);
    }
}
