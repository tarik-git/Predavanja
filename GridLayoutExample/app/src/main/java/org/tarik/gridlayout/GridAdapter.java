package org.tarik.gridlayout;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.tarik.gridlayout.databinding.ItemUserGridBinding;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridViewHolder> {

    private List<Person> personList = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    public void setPersonList(List<Person> personList) {
        this.personList = personList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemUserGridBinding binding = ItemUserGridBinding.inflate(inflater, parent, false);
        return new GridViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        holder.onBind(personList.get(position));
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }
}
