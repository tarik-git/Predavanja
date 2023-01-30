package com.example.tvmazeapp.presentation;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tvmazeapp.R;
import com.example.tvmazeapp.data.remote.RetrofitProvider;
import com.example.tvmazeapp.data.remote.RetrofitService;
import com.example.tvmazeapp.data.remote.dto.ShowResponse;
import com.example.tvmazeapp.databinding.FragmentDicoverBinding;
import com.example.tvmazeapp.models.Show;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiscoverFragment extends Fragment implements ShowAdapter.OnShowClickListener {

    private static final String TAG = "DiscoverFragment";
    private FragmentDicoverBinding binding;
    private ShowAdapter adapter = new ShowAdapter(this);

    private Callback<List<ShowResponse>> callback = new Callback<List<ShowResponse>>() {
        @Override
        public void onResponse(Call<List<ShowResponse>> call, Response<List<ShowResponse>> response) {
            Log.d(TAG, "onResponse: " + response);
            if (response.isSuccessful()) {
                List<ShowResponse> list = response.body();
                List<Show> showList = new ArrayList<>();
                if (list != null) {
                    for (ShowResponse sr : list) {
                        showList.add(sr.getShow().toShow());
                    }
                }
                adapter.setList(showList);
            }
        }

        @Override
        public void onFailure(Call<List<ShowResponse>> call, Throwable t) {
            Log.d(TAG, "onFailure: ");
        }
    };

    public DiscoverFragment() {
        // Required empty public constructor
    }

    public static DiscoverFragment newInstance() {
        DiscoverFragment fragment = new DiscoverFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDicoverBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.searchImageButton.setOnClickListener(this::onSearchClicked);

        LinearLayoutManager manager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.discoverRecyclerView.setLayoutManager(manager);
        binding.discoverRecyclerView.setAdapter(adapter);


    }

    private void onSearchClicked(View view) {
        RetrofitService retrofitService = RetrofitProvider.getInstance().create(RetrofitService.class);

        String query = binding.showEditText.getText().toString();
        if (!TextUtils.isEmpty(query)) {
            retrofitService.searchShow(query).enqueue(callback);
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