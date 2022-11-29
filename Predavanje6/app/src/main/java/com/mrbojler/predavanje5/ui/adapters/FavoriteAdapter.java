package com.mrbojler.predavanje5.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mrbojler.predavanje5.R;
import com.mrbojler.predavanje5.databinding.ItemContactBinding;
import com.mrbojler.predavanje5.databinding.ItemFavoriteBinding;
import com.mrbojler.predavanje5.model.Contact;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder> {

    private List<Contact> list;

    @SuppressLint("NotifyDataSetChanged")
    public void setList(List<Contact> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemFavoriteBinding itemBinding = ItemFavoriteBinding.inflate(
                inflater,
                parent,
                false
        );
        return new FavoriteViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onViewRecycled(@NonNull FavoriteViewHolder holder) {
        super.onViewRecycled(holder);
        holder.binding.favoriteAvatarImageView.setImageResource(R.drawable.ic_baseline_person);
    }

    static class FavoriteViewHolder extends RecyclerView.ViewHolder {

        private ItemFavoriteBinding binding;

        public FavoriteViewHolder(@NonNull ItemFavoriteBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Contact item) {
            binding.favoriteNameTextView.setText(item.getName());
            binding.favoriteNumberTextView.setText(item.getNumber());
            if (item.getImageUrl() != null && !item.getImageUrl().isEmpty()) {
                Glide.with(binding.getRoot().getContext())
                        .load(item.getImageUrl())
                        .into(binding.favoriteAvatarImageView);
            }
        }

    }

}
