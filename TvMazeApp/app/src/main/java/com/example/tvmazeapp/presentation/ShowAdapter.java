package com.example.tvmazeapp.presentation;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tvmazeapp.databinding.ItemShowBinding;
import com.example.tvmazeapp.models.Show;

import java.util.ArrayList;
import java.util.List;

public class ShowAdapter extends RecyclerView.Adapter<ShowViewHolder> {

    public interface OnShowClickListener {
        void onClick(Show show);
    }

    private List<Show> list = new ArrayList<>();
    private OnShowClickListener listener = null;

    public void setList(List<Show> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public ShowAdapter(@NonNull OnShowClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemShowBinding binding = ItemShowBinding.inflate(inflater, parent, false);
        return new ShowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowViewHolder holder, int position) {
        holder.onBind(list.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
