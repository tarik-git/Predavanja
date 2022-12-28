package com.tarik.dogsapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;
import com.tarik.dogsapplication.R;
import com.tarik.dogsapplication.databinding.ActivityMainBinding;
import com.tarik.dogsapplication.ui.DogFragment;
import com.tarik.dogsapplication.ui.SearchFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        setupFragment(new DogFragment());
        binding.bottomNavigationView.setSelectedItemId(R.id.menu_item_home);
        binding.bottomNavigationView.setOnItemSelectedListener(this::onNavigationItemSelected);
    }

    private boolean onNavigationItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_item_home) {
            setupFragment(new DogFragment());
        } else if (itemId == R.id.menu_item_discover) {
            setupFragment(new SearchFragment());
        } else {
            return false;
        }
        return true;
    }

    private void setupFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_layout, fragment);
        ft.commit();
    }

}