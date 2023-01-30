package com.example.tvmazeapp.presentation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.tvmazeapp.R;
import com.example.tvmazeapp.data.local.AppDatabase;
import com.example.tvmazeapp.data.local.ShowDAO;
import com.example.tvmazeapp.data.remote.RetrofitProvider;
import com.example.tvmazeapp.data.remote.RetrofitService;
import com.example.tvmazeapp.data.remote.dto.ShowResponse;
import com.example.tvmazeapp.databinding.FragmentSingleShowBinding;
import com.example.tvmazeapp.models.Show;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleShowFragment extends Fragment {

    public static final String BUNDLE_SHOW_ID = "BUNDLE_SHOW_ID";
    private FragmentSingleShowBinding binding;
    private static final String TAG = "SingleShowFragment";

    private AppDatabase appDatabase = null;
    private ShowDAO showDAO = null;

    private long showId = -1;

    private Callback<ShowResponse.ShowDto> callback = new Callback<ShowResponse.ShowDto>() {
        @Override
        public void onResponse(Call<ShowResponse.ShowDto> call, Response<ShowResponse.ShowDto> response) {
            Log.d(TAG, "onResponse: " + response);
            if (response.isSuccessful()) {
                ShowResponse.ShowDto showDto = response.body();
                if (showDto != null) {
                    Log.d(TAG, "onResponse: show: " + showDto.toShow());
                    renderShow(showDto.toShow());
                }
            }
        }

        @Override
        public void onFailure(Call<ShowResponse.ShowDto> call, Throwable t) {
            Log.d(TAG, "onFailure: " + t);
        }
    };

    public SingleShowFragment() {
        // Required empty public constructor
    }

    public static SingleShowFragment newInstance(long showId) {
        SingleShowFragment fragment = new SingleShowFragment();
        Bundle args = new Bundle();
        args.putLong(BUNDLE_SHOW_ID, showId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            showId = bundle.getLong(BUNDLE_SHOW_ID, -1);
        }

        appDatabase = AppDatabase.getInstance(requireActivity().getApplicationContext());
        showDAO = appDatabase.showDAO();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSingleShowBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (showId > 0) {
            RetrofitService retrofitService = RetrofitProvider.getInstance().create(RetrofitService.class);

            retrofitService.getShowById(showId).enqueue(callback);
        }

    }

    private void renderShow(Show show) {
        if (!TextUtils.isEmpty(show.originalPosterUrl)) {
            Glide.with(requireContext()).load(show.originalPosterUrl).into(binding.showImageImageView);
        }
        binding.nameTextView.setText(show.showName);
        binding.ratingBar.setRating((float)show.showRating/2);
        binding.premieredTextView.setText(show.showPremiered);
        binding.officialSiteTextView.setText(show.showSite);
        binding.summaryTextArea.setText(Html.fromHtml(show.showSummary));

        if (showDAO != null) {
            long showIdFromDB = showDAO.isShowPresent(show.showId);
            boolean isPresent = showIdFromDB == show.showId;
            if (isPresent) {
                binding.floatingActionButton.setImageResource(R.drawable.baseline_remove);
                binding.floatingActionButton.setOnClickListener(v -> {
                    onRemoveShowClick(v, show);
                });
            } else {
                binding.floatingActionButton.setImageResource(R.drawable.baseline_add);
                binding.floatingActionButton.setOnClickListener(v -> {
                    onAddShowClick(v, show);
                });
            }
        }

    }

    private void onAddShowClick(View view, Show show) {
        if (showDAO != null) {
            showDAO.insertShow(show);
        }
        renderShow(show);
    }

    private void onRemoveShowClick(View view, Show show) {
        if (showDAO != null) {
            showDAO.deleteShow(show);
        }
        renderShow(show);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}