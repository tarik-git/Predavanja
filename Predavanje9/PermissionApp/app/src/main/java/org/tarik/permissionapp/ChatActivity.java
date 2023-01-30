package org.tarik.permissionapp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.tarik.permissionapp.databinding.ActivityChatBinding;

public class ChatActivity extends AppCompatActivity {

    private ActivityChatBinding binding;

    private ActivityResultLauncher<String> launcher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    Toast.makeText(getBaseContext(), "Opening ...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), "Permission not granted", Toast.LENGTH_SHORT).show();
                }
    });



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.chatToolbar);
        binding.chatToolbar.setTitle("Anes");
        binding.chatToolbar.setSubtitle("Last seen a moment ago");
        binding.chatToolbar.setNavigationOnClickListener(view -> onBackPressed());


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }


        binding.cameraImageButton.setOnClickListener(this::onCameraClick);

        binding.galleryImageButton.setOnClickListener(this::onGalleryClick);

        binding.microphoneImageButton.setOnClickListener(this::onMicrophoneClick);

    }

    public void onCameraClick(View view) {
        checkPermission(
                Manifest.permission.CAMERA,
                "Please grant camera permission",
                "To use feature please grant camera permission"
        );
    }

    public void onGalleryClick(View view) {
        checkPermission(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                "Please grant storage permission",
                "To use feature please grant storage permission"
        );
    }

    public void onMicrophoneClick(View view) {
        checkPermission(
                Manifest.permission.RECORD_AUDIO,
                "Please grant record audio permission",
                "To use feature please grant record audio permission"
        );
    }

    private void checkPermission(
            String permission,
            String title,
            String message
    ) {
        if (ContextCompat.checkSelfPermission(getBaseContext(), permission) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && shouldShowRequestPermissionRationale(permission)) {
                showRationaleDialog(title, message);
            } else {
                launcher.launch(permission);
            }
        } else {
            Toast.makeText(getBaseContext(), "Opening ...", Toast.LENGTH_SHORT).show();
        }
    }

    private void showRationaleDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(android.R.string.ok, (dialogInterface, i) -> {
            dialogInterface.dismiss();
        });
        builder.setCancelable(false);
        builder.show();
    }

}