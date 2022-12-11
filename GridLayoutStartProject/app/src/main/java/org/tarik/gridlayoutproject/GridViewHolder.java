package org.tarik.gridlayoutproject;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.tarik.gridlayoutproject.databinding.GridItemBinding;

public class GridViewHolder extends RecyclerView.ViewHolder {

    private GridItemBinding binding;

    public GridViewHolder(@NonNull GridItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void onBind(Person person) {
        binding.gridNameTextView.setText(person.getName());
        if (person.getAvatarUrl() != null && !person.getAvatarUrl().isEmpty()) {
            Glide.with(binding.getRoot())
                    .load(person.getAvatarUrl())
                    .into(binding.gridAvatarImageView);
        }
    }

}
