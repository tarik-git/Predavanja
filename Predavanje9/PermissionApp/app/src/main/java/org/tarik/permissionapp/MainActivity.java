package org.tarik.permissionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import org.tarik.permissionapp.adapter.ChatAdapter;
import org.tarik.permissionapp.databinding.ActivityMainBinding;
import org.tarik.permissionapp.model.ChatSession;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ChatAdapter.OnChatItemClickListener {

    private ActivityMainBinding binding;
    private ChatAdapter adapter = new ChatAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbar.setTitle(R.string.chats);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(getBaseContext(), LinearLayout.VERTICAL));

        List<ChatSession> list = Arrays.asList(
                new ChatSession("Anes", "Hi how are you"),
                new ChatSession("John", "Hello there")
        );
        adapter.setList(list);

    }

    @Override
    public void onClick(ChatSession chatSession) {
        Intent intent = new Intent(getBaseContext(), ChatActivity.class);
        startActivity(intent);
    }
}