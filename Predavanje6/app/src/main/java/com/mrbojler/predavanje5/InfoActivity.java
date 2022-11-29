package com.mrbojler.predavanje5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.mrbojler.predavanje5.ui.ProfileFragment;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        String name = intent.getStringExtra(ProfileFragment.BUNDLE_NAME);
        String number = intent.getStringExtra(ProfileFragment.BUNDLE_NUMBER);
        String avatar = intent.getStringExtra(ProfileFragment.BUNDLE_AVATAR);

        setupFragment(ProfileFragment.newInstance(name, number, avatar));
    }

    private void setupFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

}