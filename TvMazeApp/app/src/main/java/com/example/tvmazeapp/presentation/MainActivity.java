package com.example.tvmazeapp.presentation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.tvmazeapp.R;
import com.example.tvmazeapp.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupFragment(DiscoverFragment.newInstance());
        binding.bottomNavigationView.setSelectedItemId(R.id.menu_item_discover);
        binding.bottomNavigationView.setOnItemSelectedListener(this::onNavigationItemSelected);

    }

    private boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_item_discover) {
            setupFragment(DiscoverFragment.newInstance());
        } else if (itemId == R.id.menu_item_shows) {
            setupFragment(ShowsFragment.newInstance("",""));
        } else {
            return false;
        }
        return true;
    }

    private void setupFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_frame_layout, fragment);
        ft.commit();
    }

}