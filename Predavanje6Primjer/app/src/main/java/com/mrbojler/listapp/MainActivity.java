package com.mrbojler.listapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.mrbojler.listapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 1. Korak odrediti koji cemo layout manager koristiti
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        // 2. Napraviti layout za ViewHolder
        // res -> layout -> item_name.xml
        // 3. Napraviti ViewHolder


    }
}