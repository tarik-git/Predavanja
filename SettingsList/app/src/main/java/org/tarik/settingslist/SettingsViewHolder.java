package org.tarik.settingslist;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.tarik.settingslist.databinding.ItemSettingsBinding;

public class SettingsViewHolder extends RecyclerView.ViewHolder {

    public ItemSettingsBinding binding;

    public SettingsViewHolder(@NonNull ItemSettingsBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

}
