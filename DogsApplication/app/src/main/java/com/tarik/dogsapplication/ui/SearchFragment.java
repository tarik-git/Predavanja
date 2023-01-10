package com.tarik.dogsapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.tarik.dogsapplication.SecondActivity;
import com.tarik.dogsapplication.databinding.FragmentSearchBinding;
import com.tarik.dogsapplication.model.BreedResponse;
import com.tarik.dogsapplication.retrofit.DogRetrofitInstance;
import com.tarik.dogsapplication.retrofit.DogsRetrofitService;
import com.tarik.dogsapplication.ui.adapter.DogBreedAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SearchFragment extends Fragment implements DogBreedAdapter.OnBreedClickListener {

    private FragmentSearchBinding binding;
    private DogBreedAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        binding = FragmentSearchBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new DogBreedAdapter(this);
        binding.recyclerView.setAdapter(adapter);

        Retrofit retrofit = DogRetrofitInstance.getInstance();
        DogsRetrofitService dogsRetrofitService = retrofit.create(DogsRetrofitService.class);
        dogsRetrofitService.getBreedList().enqueue(new Callback<BreedResponse>() {
            @Override
            public void onResponse(Call<BreedResponse> call, Response<BreedResponse> response) {
                if (response.isSuccessful()) {
                    BreedResponse breedResponse = response.body();
                    if (breedResponse != null && breedResponse.isSuccessful()) {

                        List<String> list = new ArrayList<>();
                        Map<String, List<String>> map = breedResponse.message;

                        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                            if (entry.getValue().isEmpty()) {
                                list.add(entry.getKey());
                            } else {
                                for (String s : entry.getValue()) {
                                    list.add(entry.getKey() + "-" + s);
                                }
                            }
                        }

                        adapter.setList(list);

                    }
                }
            }

            @Override
            public void onFailure(Call<BreedResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(String breed) {
        Intent intent = new Intent(requireContext(), SecondActivity.class);
        intent.putExtra(DogFragment.BUNDLE_BREED_NAME, breed);
        startActivity(intent);
    }


}
