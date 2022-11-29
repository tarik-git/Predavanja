package com.mrbojler.predavanje5.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrbojler.predavanje5.InfoActivity;
import com.mrbojler.predavanje5.Repository;
import com.mrbojler.predavanje5.databinding.FragmentContactsBinding;
import com.mrbojler.predavanje5.model.Contact;
import com.mrbojler.predavanje5.ui.adapters.ContactsAdapter;

import java.util.ArrayList;
import java.util.List;

public class ContactsFragment extends Fragment implements ContactsAdapter.OnContactClickListener {

    private ContactsAdapter adapter = new ContactsAdapter(this);
    private FragmentContactsBinding binding;

    public static ContactsFragment newInstance() {
        ContactsFragment fragment = new ContactsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentContactsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Contact> list = Repository.getListOfContacts();

        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter.setList(list);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onContactClick(Contact contact) {
        Intent intent = new Intent(requireContext(), InfoActivity.class);
        intent.putExtra(ProfileFragment.BUNDLE_NAME, contact.getName());
        intent.putExtra(ProfileFragment.BUNDLE_NUMBER, contact.getNumber());
        intent.putExtra(ProfileFragment.BUNDLE_AVATAR, contact.getImageUrl());
        startActivity(intent);
    }

}