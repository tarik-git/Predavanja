package com.mrbojler.predavanje5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;
import com.mrbojler.predavanje5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupFragment(new ProfileFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(this::onItemSelectListener);
    }

    private void setupFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    private boolean onItemSelectListener(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_item_profile) {
            setupFragment(new ProfileFragment());
            return true;
        } else if (itemId == R.id.menu_item_contact) {
            setupFragment(new DirectoryFragment());
            return true;
        } else {
            return false;
        }
    }

}