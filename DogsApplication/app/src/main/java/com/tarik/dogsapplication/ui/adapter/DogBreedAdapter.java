package com.tarik.dogsapplication.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tarik.dogsapplication.databinding.ItemBreedBinding;

import java.util.ArrayList;
import java.util.List;

public class DogBreedAdapter extends RecyclerView.Adapter<BreedItemViewHolder> {

    private List<String> list = new ArrayList<>();

    public void setList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BreedItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemBreedBinding binding = ItemBreedBinding.inflate(inflater, parent, false);
        return new BreedItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BreedItemViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
