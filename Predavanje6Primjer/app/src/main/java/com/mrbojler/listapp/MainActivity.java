package com.mrbojler.listapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.mrbojler.listapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

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
        // 4. Napraviti Adapter
        NamesAdapter adapter = new NamesAdapter();
        binding.recyclerView.setAdapter(adapter);
        List<String> nameList = new ArrayList<>();
        nameList.add("Ena");
        nameList.add("Nedzad");
        nameList.add("Edin");
        nameList.add("Anes");
        nameList.add("Tarik");
        nameList.add("Elmin");
        adapter.setListOfNames(nameList);
    }
}