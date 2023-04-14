package com.example.practice_3.ui;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;


import com.example.practice_3.MainActivity;
import com.example.practice_3.CustomService;
import com.example.practice_3.R;
import com.example.practice_3.databinding.FragmentOneflowerBinding;


public class OneFlowerFragment extends Fragment {

    private FragmentOneflowerBinding binding;



    private MainActivity mainActivity;

    public OneFlowerFragment() {
        super(R.layout.fragment_oneflower);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOneflowerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            binding.textViewFilmName.setText(getArguments().getString("filmName"));
            binding.filmPoster.setImageResource(getArguments().getInt("posterId"));
        }

        binding.getNotificationButton.setOnClickListener(view1 -> {
            if (ContextCompat.checkSelfPermission(requireContext(),
                    Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {

                NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), "notif");
                builder.setContentTitle("заголовок");
                builder.setContentText("закажи букет уже");
                builder.setAutoCancel(true);
                builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(requireContext());
                managerCompat.notify(1, builder.build());
            }
        });

        binding.getServiceButton.setOnClickListener(view12 -> {
            Intent intent = new Intent(mainActivity, CustomService.class);
            mainActivity.startService(intent);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

