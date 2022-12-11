package org.tarik.gridlayout;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.tarik.gridlayout.databinding.ItemUserLinearBinding;

import java.util.ArrayList;
import java.util.List;

public class LinearAdapter extends RecyclerView.Adapter<LinearViewHolder> {

    private List<Person> personList = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    public void setPersonList(List<Person> personList) {
        this.personList = personList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemUserLinearBinding binding = ItemUserLinearBinding.inflate(inflater, parent, false);
        return new LinearViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder holder, int position) {
        holder.onBind(personList.get(position));
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

}
