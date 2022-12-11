package org.tarik.gridlayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.tarik.gridlayout.databinding.ItemUserLinearBinding;

public class LinearViewHolder extends RecyclerView.ViewHolder {

    public ItemUserLinearBinding binding;

    public LinearViewHolder(@NonNull ItemUserLinearBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void onBind(Person person) {
        binding.linearNameTextView.setText(person.getName());

        if (person.getAvatarUrl() != null && !person.getAvatarUrl().isEmpty()) {
//            Glide.with(binding.getRoot().getContext())
//                    .load(person.getAvatarUrl())
//                    .into(binding.linearImageView);
            binding.linearImageView.setImageResource(R.drawable.ic_baseline_person);
        }

    }

}
