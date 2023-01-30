package com.example.tvmazeapp.presentation;

import android.text.TextUtils;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tvmazeapp.databinding.ItemShowBinding;
import com.example.tvmazeapp.models.Show;

public class ShowViewHolder extends RecyclerView.ViewHolder {

    private ItemShowBinding binding;

    public ShowViewHolder(@NonNull ItemShowBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void onBind(@NonNull Show show, ShowAdapter.OnShowClickListener listener) {
        if (!TextUtils.isEmpty(show.posterUrl)) {
            Glide.with(binding.getRoot()).load(show.posterUrl).into(binding.posterImageView);
        }
        binding.showNameTextView.setText(show.showName);
        binding.getRoot().setOnClickListener(v -> {
            listener.onClick(show);
        });
    }

}
