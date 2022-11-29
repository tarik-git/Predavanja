package com.mrbojler.predavanje5.ui.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.mrbojler.predavanje5.R;
import com.mrbojler.predavanje5.ui.ContactsFragment;
import com.mrbojler.predavanje5.ui.FavoriteFragment;

public class StateAdapter extends FragmentStateAdapter {

    private Context context;

    public StateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        context = fragmentActivity.getBaseContext();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = ContactsFragment.newInstance();
        if (position == 0) {
            fragment = ContactsFragment.newInstance();
        } else if (position == 1) {
            fragment = FavoriteFragment.newInstance();
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public String getItemTitle(int position) {
        String title = "";
        if (position == 0) {
            title = context.getString(R.string.contacts);
        } else if (position == 1) {
            title = context.getString(R.string.favorites);
        }
        return title;
    }

}
