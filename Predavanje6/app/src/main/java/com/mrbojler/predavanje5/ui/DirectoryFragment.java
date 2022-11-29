package com.mrbojler.predavanje5.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayoutMediator;
import com.mrbojler.predavanje5.databinding.FragmentDirectoryBinding;
import com.mrbojler.predavanje5.ui.adapters.StateAdapter;

public class DirectoryFragment extends Fragment {

    private FragmentDirectoryBinding binding;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        binding = FragmentDirectoryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        StateAdapter stateAdapter = new StateAdapter(requireActivity());
        binding.viewPager.setAdapter(stateAdapter);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                binding.tabLayout,
                binding.viewPager,
                (tab, position) -> tab.setText(stateAdapter.getItemTitle(position))
        );
        tabLayoutMediator.attach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
