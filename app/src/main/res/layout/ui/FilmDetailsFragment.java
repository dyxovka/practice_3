package com.ctacekscompany.cinemateque.ui;

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

import com.ctacekscompany.cinemateque.MainActivity;
import com.ctacekscompany.cinemateque.CustomService;
import com.ctacekscompany.cinemateque.R;
import com.ctacekscompany.cinemateque.databinding.FragmentFilmdetailsBinding;


public class FilmDetailsFragment extends Fragment {
    private FragmentFilmdetailsBinding binding;
    private MainActivity mainActivity;

    public FilmDetailsFragment() {
        super(R.layout.fragment_filmdetails);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmdetailsBinding.inflate(inflater, container, false);
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

                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        requireContext(),
                        "My Notification");

                builder.setSmallIcon(R.drawable.user);
                builder.setContentTitle("My Title");
                builder.setContentText("Hello");
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

