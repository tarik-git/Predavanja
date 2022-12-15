package org.tarik.numberfacts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;

import org.tarik.numberfacts.databinding.ActivityMainBinding;

//        implementation 'com.squareup.retrofit2:retrofit:2.9.0'
//        implementation 'com.google.code.gson:gson:2.9.0'
//        implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupFragment(MainFragment.getInstance(MainFragment.TYPE_TRIVIA));
        binding.bottomNavigationView.setSelectedItemId(R.id.menu_item_trivia);

        binding.bottomNavigationView.setOnItemSelectedListener(this::onItemSelectedListener);
    }

    private boolean onItemSelectedListener(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if(itemId == R.id.menu_item_trivia) {
            setupFragment(MainFragment.getInstance(MainFragment.TYPE_TRIVIA));
        } else if (itemId == R.id.menu_item_date) {
            setupFragment(MainFragment.getInstance(MainFragment.TYPE_DATE));
        } else if (itemId == R.id.menu_item_year) {
            setupFragment(MainFragment.getInstance(MainFragment.TYPE_YEAR));
        } else if (itemId == R.id.menu_item_math) {
            setupFragment(MainFragment.getInstance(MainFragment.TYPE_MATH));
        } else {
            return false;
        }
        return true;
    }

    private void setupFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

}