package org.tarik.permissionapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.tarik.permissionapp.databinding.ItemChatBinding;
import org.tarik.permissionapp.model.ChatSession;

import java.util.ArrayList;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatSessionViewHolder> {

    public interface OnChatItemClickListener {
        public void onClick(ChatSession chatSession);
    }

    List<ChatSession> list = new ArrayList<>();
    private OnChatItemClickListener listener;

    public ChatAdapter(OnChatItemClickListener listener) {
        this.listener = listener;
    }

    public void setList(List<ChatSession> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ChatSessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemChatBinding binding = ItemChatBinding.inflate(inflater, parent, false);
        return new ChatSessionViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatSessionViewHolder holder, int position) {
        holder.onBind(list.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
