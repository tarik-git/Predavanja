package org.tarik.gridlayout;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.tarik.gridlayout.databinding.ItemUserGridBinding;

public class GridViewHolder extends RecyclerView.ViewHolder {

    private ItemUserGridBinding binding;

    public GridViewHolder(@NonNull ItemUserGridBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void onBind(Person person) {
        binding.gridNameTextView.setText(person.getName());
        if (person.getAvatarUrl() != null && !person.getAvatarUrl().isEmpty()) {
//            Glide.with(binding.getRoot().getContext())
//                    .load(person.getAvatarUrl())
//                    .into(binding.gridImageView);
            binding.gridImageView.setImageResource(R.drawable.ic_baseline_person);
        }
    }

}
