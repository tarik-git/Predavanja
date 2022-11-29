package com.mrbojler.predavanje5.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrbojler.predavanje5.Repository;
import com.mrbojler.predavanje5.databinding.FragmentFavoriteBinding;
import com.mrbojler.predavanje5.model.Contact;
import com.mrbojler.predavanje5.ui.adapters.FavoriteAdapter;

import java.util.List;

public class FavoriteFragment extends Fragment {

    private FavoriteAdapter adapter = new FavoriteAdapter();
    private FragmentFavoriteBinding binding;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    public static FavoriteFragment newInstance() {
        FavoriteFragment fragment = new FavoriteFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<Contact> list = Repository.getListOfFavoriteContacts();

        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        adapter.setList(list);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}