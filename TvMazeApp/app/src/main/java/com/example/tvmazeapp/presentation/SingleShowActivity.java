package com.example.tvmazeapp.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.tvmazeapp.R;
import com.example.tvmazeapp.databinding.ActivitySingleShowBinding;

public class SingleShowActivity extends AppCompatActivity {

    private ActivitySingleShowBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySingleShowBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        long showId = -1;
        Intent intent = getIntent();
        if (intent != null) {
            showId = intent.getLongExtra(SingleShowFragment.BUNDLE_SHOW_ID, -1);
        }

        setupFragment(SingleShowFragment.newInstance(showId));
    }


    private void setupFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.single_show_frame_layout, fragment);
        ft.commit();
    }
}