package org.tarik.settingslist;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.tarik.settingslist.databinding.ItemSettingsBinding;

import java.util.ArrayList;
import java.util.List;

public class SettingAdapter extends RecyclerView.Adapter<SettingsViewHolder> {

    private List<SettingsItem> settingsItemList = new ArrayList<>();
    public void setSettingsItemList(@NonNull List<SettingsItem> list) {
        if (list != null) {
            settingsItemList = list;
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public SettingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemSettingsBinding binding = ItemSettingsBinding.inflate(inflater, parent, false);
        return new SettingsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingsViewHolder holder, int position) {
        SettingsItem item = settingsItemList.get(position);
        holder.binding.titleTextView.setText(item.title);
        holder.binding.descTextView.setText(item.desc);
        holder.binding.iconImageView.setImageResource(item.imgRes);
    }

    @Override
    public int getItemCount() {
        return settingsItemList.size();
    }
}
