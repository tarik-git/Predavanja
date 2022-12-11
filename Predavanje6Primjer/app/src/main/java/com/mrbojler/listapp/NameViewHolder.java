package com.mrbojler.listapp;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mrbojler.listapp.databinding.ItemNameBinding;

public class NameViewHolder extends RecyclerView.ViewHolder {

    public ItemNameBinding binding;

    public NameViewHolder(@NonNull ItemNameBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

}
