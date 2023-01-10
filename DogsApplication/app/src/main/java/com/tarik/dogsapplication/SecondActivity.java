package com.tarik.dogsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.tarik.dogsapplication.databinding.ActivitySecondBinding;
import com.tarik.dogsapplication.ui.DogFragment;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        String breedName = null;
        Intent intent = getIntent();
        if (intent != null) {
            breedName = intent.getStringExtra(DogFragment.BUNDLE_BREED_NAME);
        }

        setupFragment(DogFragment.getInstance(breedName));

    }

    private void setupFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.second_frame_layout, fragment);
        ft.commit();
    }

}