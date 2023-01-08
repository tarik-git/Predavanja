package com.tarik.dogsapplication.ui.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tarik.dogsapplication.databinding.ItemBreedBinding;

public class BreedItemViewHolder extends RecyclerView.ViewHolder {

    private ItemBreedBinding binding;

    public BreedItemViewHolder(@NonNull ItemBreedBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void onBind(String breedName) {
        binding.breedNameTextView.setText(breedName);
    }

}
