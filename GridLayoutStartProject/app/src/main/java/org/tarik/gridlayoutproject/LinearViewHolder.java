package org.tarik.gridlayoutproject;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.tarik.gridlayoutproject.databinding.LinearItemBinding;

public class LinearViewHolder extends RecyclerView.ViewHolder {

    private LinearItemBinding binding;

    public LinearViewHolder(@NonNull LinearItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void onBind(Person person) {
        binding.linearNameTextView.setText(person.getName());
        if (person.getAvatarUrl() != null && !person.getAvatarUrl().isEmpty()) {
            Glide.with(binding.getRoot())
                    .load(person.getAvatarUrl())
                    .into(binding.linearAvatarImageView);
        }
    }

}
