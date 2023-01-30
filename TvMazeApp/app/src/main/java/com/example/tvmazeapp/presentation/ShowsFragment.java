package com.example.tvmazeapp.presentation;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tvmazeapp.data.local.AppDatabase;
import com.example.tvmazeapp.data.local.ShowDAO;
import com.example.tvmazeapp.databinding.FragmentShowsBinding;
import com.example.tvmazeapp.models.Show;

import java.util.List;

public class ShowsFragment extends Fragment implements ShowAdapter.OnShowClickListener {

    private FragmentShowsBinding binding;

    private ShowAdapter showAdapter = new ShowAdapter(this);

    private AppDatabase appDatabase = null;
    private ShowDAO showDAO = null;

    public ShowsFragment() {
        // Required empty public constructor
    }

    public static ShowsFragment newInstance(String param1, String param2) {
        ShowsFragment fragment = new ShowsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        appDatabase = AppDatabase.getInstance(requireActivity().getApplicationContext());
        showDAO = appDatabase.showDAO();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentShowsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.showsRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        binding.showsRecyclerView.setAdapter(showAdapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        updateList();
    }

    private void updateList() {
        if (showDAO != null) {
            List<Show> showList = showDAO.getAllShows();
            if (showList.size() > 0) {
                binding.showsRecyclerView.setVisibility(View.VISIBLE);
                binding.emptyTextView.setVisibility(View.GONE);
                showAdapter.setList(showList);
            } else {
                binding.showsRecyclerView.setVisibility(View.GONE);
                binding.emptyTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(Show show) {
        Intent intent = new Intent(getContext(), SingleShowActivity.class);
        intent.putExtra(SingleShowFragment.BUNDLE_SHOW_ID, show.showId);
        startActivity(intent);
    }
}