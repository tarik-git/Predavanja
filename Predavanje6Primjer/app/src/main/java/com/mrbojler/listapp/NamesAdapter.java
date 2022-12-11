package com.mrbojler.listapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mrbojler.listapp.databinding.ItemNameBinding;

import java.util.ArrayList;
import java.util.List;

public class NamesAdapter extends RecyclerView.Adapter<NameViewHolder>{

    private List<String> listOfNames = new ArrayList<>();

    public void setListOfNames(List<String> names) {
        listOfNames = names;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemNameBinding binding = ItemNameBinding.inflate(inflater, parent, false);
        return new NameViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        String name = listOfNames.get(position);
        holder.binding.nameTextView.setText(name);
    }

    @Override
    public int getItemCount() {
        return listOfNames.size();
    }
}
