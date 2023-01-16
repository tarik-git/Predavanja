package org.tarik.permissionapp.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.tarik.permissionapp.R;
import org.tarik.permissionapp.databinding.ItemChatBinding;
import org.tarik.permissionapp.model.ChatSession;

public class ChatSessionViewHolder extends RecyclerView.ViewHolder {

    private ItemChatBinding binding;

    public ChatSessionViewHolder(@NonNull ItemChatBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void onBind(ChatSession chatSession, ChatAdapter.OnChatItemClickListener listener) {
        binding.avatarImageView.setImageResource(R.drawable.ic_baseline_person_24);
        binding.titleTextView.setText(chatSession.title);
        binding.subtitleTextView.setText(chatSession.subtitle);
        binding.getRoot().setOnClickListener(view -> {
            listener.onClick(chatSession);
        });
    }

}
