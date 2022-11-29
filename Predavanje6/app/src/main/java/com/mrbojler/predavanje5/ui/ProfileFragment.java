package com.mrbojler.predavanje5.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.mrbojler.predavanje5.R;
import com.mrbojler.predavanje5.databinding.FragmentProfileBinding;
import com.mrbojler.predavanje5.model.Contact;

public class ProfileFragment extends Fragment {

    public static final String BUNDLE_NAME = "BUNDLE_NAME";
    public static final String BUNDLE_NUMBER = "BUNDLE_NUMBER";
    public static final String BUNDLE_AVATAR = "BUNDLE_AVATAR";

    private FragmentProfileBinding binding;
    private Contact currentContact = new Contact(
            "Tarik Fazlic",
            "+387 11 11 11",
            "",
            false
    );

    public ProfileFragment(){
        // Requires empty default constructor
    }

    public static ProfileFragment newInstance(String name, String number, String avatar) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(BUNDLE_NAME, name);
        args.putString(BUNDLE_NUMBER, number);
        args.putString(BUNDLE_AVATAR, avatar);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String name = getArguments().getString(BUNDLE_NAME);
            String number = getArguments().getString(BUNDLE_NUMBER);
            String avatar = getArguments().getString(BUNDLE_AVATAR);
            currentContact.setName(name);
            currentContact.setNumber(number);
            currentContact.setImageUrl(avatar);
        }
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.profileNameTextView.setText(currentContact.getName());
        binding.profileNumberTextView.setText(currentContact.getNumber());
        if (currentContact.getImageUrl() != null && !currentContact.getImageUrl().isEmpty()) {
            Glide.with(requireContext()).load(currentContact.getImageUrl()).into(binding.profileImageView);
        } else {
            binding.profileImageView.setImageResource(R.drawable.ic_baseline_person);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
