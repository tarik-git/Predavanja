package com.mrbojler.predavanje5.ui.adapters;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mrbojler.predavanje5.R;
import com.mrbojler.predavanje5.databinding.ItemContactBinding;
import com.mrbojler.predavanje5.model.Contact;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {

    private static final String TAG = "ContactsAdapter";
    private List<Contact> list;
    private OnContactClickListener listener;

    public ContactsAdapter(OnContactClickListener listener) {
        this.listener = listener;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setList(List<Contact> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemContactBinding itemBinding = ItemContactBinding.inflate(
                inflater,
                parent,
                false
        );
        return new ContactsViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {
        holder.onBind(list.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onViewRecycled(@NonNull ContactsViewHolder holder) {
        super.onViewRecycled(holder);
        holder.binding.avatarImageView.setImageResource(R.drawable.ic_baseline_person);
    }

    static class ContactsViewHolder extends RecyclerView.ViewHolder {

        private final ItemContactBinding binding;

        ContactsViewHolder(ItemContactBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Contact item, OnContactClickListener listener) {

            binding.getRoot().setOnClickListener(v -> {
                listener.onContactClick(item);
            });

            binding.nameTextView.setText(item.getName());
            binding.numberTextView.setText(item.getNumber());

            binding.starImageButton.setSelected(item.isFavorite());

            binding.starImageButton.setOnClickListener(v -> {
                item.setFavorite(!item.isFavorite());
                binding.starImageButton.setSelected(item.isFavorite());
            });

            if (item.getImageUrl() != null && !item.getImageUrl().isEmpty()) {
                Glide.with(binding.getRoot().getContext())
                        .load(item.getImageUrl())
                        .into(binding.avatarImageView);
            }

        }

    }

    public interface OnContactClickListener {
        public void onContactClick(Contact contact);
    }

}
