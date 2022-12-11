package org.tarik.settingslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import org.tarik.settingslist.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        1. korak
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
//       2. napraviti layout item_settings.xml
//        3. napraviti SettingsViewHolder
//        4. napraviti SettingAdapter
        List<SettingsItem> list = new ArrayList<>();
        list.add(new SettingsItem("Display", "Display settings and other", R.drawable.ic_baseline_smart_display));

        SettingAdapter settingAdapter = new SettingAdapter();
        settingAdapter.setSettingsItemList(list);

        binding.recyclerView.setAdapter(settingAdapter);


    }
}