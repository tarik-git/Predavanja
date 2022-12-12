package org.tarik.numberfacts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

        binding.bottomNavigationView.setOnItemSelectedListener(this::onItemSelectedListener);

    }

    private boolean onItemSelectedListener(@NonNull MenuItem item) {
        int itemId = item.getItemId();


        if(itemId == R.id.menu_item_trivia) {
            
        } else if (itemId == R.id.menu_item_date) {

        } else if (itemId == R.id.menu_item_year) {

        } else if (itemId == R.id.menu_item_math) {

        } else {
            return false;
        }
        return true;
    }

}