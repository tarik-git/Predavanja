package com.tarik.dogsapplication.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.tarik.dogsapplication.databinding.FragmentDogBinding;
import com.tarik.dogsapplication.model.DogResponse;
import com.tarik.dogsapplication.retrofit.DogRetrofitInstance;
import com.tarik.dogsapplication.retrofit.DogsRetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DogFragment extends Fragment {

    private FragmentDogBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDogBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Retrofit retrofit = DogRetrofitInstance.getInstance();
        DogsRetrofitService retrofitService = retrofit.create(DogsRetrofitService.class);

        binding.reloadImageButton.setOnClickListener(v -> {
            retrofitService.getRandomDogImage().enqueue(new Callback<DogResponse>() {
                @Override
                public void onResponse(@NonNull Call<DogResponse> call, @NonNull Response<DogResponse> response) {
                    Log.d("DogFragment", "onResponse: ");
                    if (response.isSuccessful()) {
                        DogResponse dogResponse = response.body();
                        if (dogResponse != null && dogResponse.isSuccessful()) {
                            Glide.with(requireContext()).load(dogResponse.message).into(binding.dogImageView);
                        }
                    }
                }

                @Override
                public void onFailure(Call<DogResponse> call, Throwable t) {
                    Log.d("DogFragment", "onFailure: ");
                }
            });
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
