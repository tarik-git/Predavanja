package org.tarik.gridlayoutproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import org.tarik.gridlayoutproject.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Person> personList = Arrays.asList(
            new Person(
                    "https://xsgames.co/randomusers/assets/avatars/male/6.jpg",
                    "Raul Durance"
            ),
            new Person(
                    "https://xsgames.co/randomusers/assets/avatars/female/23.jpg",
                    "Tamra Heulitt"
            ),
            new Person(
                    "https://xsgames.co/randomusers/assets/avatars/female/58.jpg",
                    "Celsa Radel"
            ),
            new Person(
                    "https://xsgames.co/randomusers/assets/avatars/male/62.jpg",
                    "Barrett Esquivel"
            ),
            new Person(
                    "https://xsgames.co/randomusers/assets/avatars/female/9.jpg",
                    "Althea Neafsey"
            ),
            new Person(
                    "https://xsgames.co/randomusers/assets/avatars/male/34.jpg",
                    "Palmer Bilella"
            ),
            new Person(
                    "https://xsgames.co/randomusers/assets/avatars/female/54.jpg",
                    "Rima Bernaiche"
            ),
            new Person(
                    "https://xsgames.co/randomusers/assets/avatars/female/51.jpg",
                    "Sherice Hamma"
            ),
            new Person(
                    "https://xsgames.co/randomusers/assets/avatars/female/28.jpg",
                    "Maryjo Moermond"
            ),
            new Person(
                    "https://xsgames.co/randomusers/assets/avatars/female/31.jpg",
                    "Sherell Braendle"
            ),
            new Person(
                    "https://xsgames.co/randomusers/assets/avatars/male/48.jpg",
                    "Otto Vandenakker"
            ),
            new Person(
                    "https://xsgames.co/randomusers/assets/avatars/male/0.jpg",
                    "Antony Kosanovich"
            )
    );

    private ActivityMainBinding binding;
    private LinearAdapter linearAdapter = new LinearAdapter();
    private GridAdapter gridAdapter = new GridAdapter();
    private boolean toggleLayout = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        linearAdapter.setPersonList(personList);
        gridAdapter.setPersonList(personList);

        setupAdapter();

        binding.changeLayoutButton.setOnClickListener(v -> {
            toggleLayout = !toggleLayout;
            setupAdapter();
        });

    }

    private void setupAdapter() {
        if (toggleLayout) {
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
            binding.recyclerView.setAdapter(linearAdapter);
        } else {
            binding.recyclerView.setLayoutManager(new GridLayoutManager(getBaseContext(), 3));
            binding.recyclerView.setAdapter(gridAdapter);
        }

    }

}