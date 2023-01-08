package org.tarik.sharedprefsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;

import org.tarik.sharedprefsapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String BUNDLE_COUNT_KEY = "BUNDLE_COUNT_KEY";
    private static final String BUNDLE_COLOR_KEY = "BUNDLE_COLOR_KEY";

    private ActivityMainBinding binding;

    private int mCount = 0;
    private int mColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mColor = ContextCompat.getColor(this, R.color.default_background);

        binding.blackBackgroundButton.setOnClickListener(v -> changeBackground(v, getResources().getColor(R.color.black)));
        binding.redBackgroundButton.setOnClickListener(v -> changeBackground(v, getResources().getColor(R.color.red_background)));
        binding.blueBackgroundButton.setOnClickListener(v -> changeBackground(v, getResources().getColor(R.color.blue_background)));
        binding.greenBackgroundButton.setOnClickListener(v -> changeBackground(v, getResources().getColor(R.color.green_background)));

        binding.countButton.setOnClickListener(this::countUp);
        binding.resetButton.setOnClickListener(this::reset);

        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt(BUNDLE_COUNT_KEY);
            if (mCount != 0) {
                binding.countTextview.setText(String.format("%s", mCount));
            }

            mColor = savedInstanceState.getInt(BUNDLE_COLOR_KEY);
            binding.countTextview.setBackgroundColor(mColor);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_COUNT_KEY, mCount);
        outState.putInt(BUNDLE_COLOR_KEY, mColor);
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
