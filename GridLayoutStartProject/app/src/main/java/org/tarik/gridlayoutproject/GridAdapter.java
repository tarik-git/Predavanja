package org.tarik.gridlayoutproject;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.tarik.gridlayoutproject.databinding.GridItemBinding;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridViewHolder>{

    private List<Person> personList = new ArrayList<>();

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        GridItemBinding binding = GridItemBinding.inflate(inflater, parent, false);
        return new GridViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Person person = personList.get(position);
        holder.onBind(person);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }
}
