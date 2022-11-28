package com.mrbojler.predavanje5;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class StateAdapter extends FragmentStateAdapter {

    public StateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {

        } else if (position == 1) {

        } else {
            return null;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
