package com.example.practice_3;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.practice_3.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {
    public FragmentLoginBinding fragmentLoginBinding;
    private static final String CHANNEL_ID = "channel";
    private static final int NOTIFICATION_ID = 2;
    public LoginFragment() {

    }
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        new Bundle();
        fragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false);
        buttonsBinding(new Bundle());
        return fragmentLoginBinding.getRoot();

    }

    private void buttonsBinding(Bundle bundle) {
        fragmentLoginBinding.buttonGotovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductsFragment productsFragment1 = new ProductsFragment();
                String name = fragmentLoginBinding.editTextTextPersonName.getText().toString();
                String phone = fragmentLoginBinding.editTextPhone.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putString("phone", phone);
                productsFragment1.setArguments(bundle);
                FragmentTransaction fragm = getFragmentManager().beginTransaction();
                fragm.replace(R.id.fragment_container,  productsFragment1).commit();
            }
        });

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String name = bundle.getString("name");
            TextView editText1 = view.findViewById(R.id.editTextTextPersonName);
            editText1.setText(name);
            String phone = bundle.getString("phone");
            TextView editText2 = view.findViewById(R.id.editTextPhone);
            editText2.setText(phone);

        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "канал";
            String description = "канал для уведомлений об акциях и скидках";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = requireContext().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
        // Реакция на уведомления
        Intent notificationIntent = new Intent(getActivity(), MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 0, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        fragmentLoginBinding.buttonGotovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // проверка можно ли отправлять уведомления
                if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.
                        POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                    // запрашиваем разрешение в случае нехватки прав у приложения показать уведомление
                    requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 2);
                }
                // Формирование уведомления
                NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(),
                        CHANNEL_ID)
                        .setContentText("Сделайте заказ букета и получите второй в подарок!")
                        .setContentTitle("Акция, 2 по цене 1")
                        .setSmallIcon(R.mipmap.ic_launcher_round)

                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                // Отправляем уведомление
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(requireContext());
                notificationManager.notify(NOTIFICATION_ID, builder.build());
                ProductsFragment productsFragment1 = new ProductsFragment();
                String name = fragmentLoginBinding.editTextTextPersonName.getText().toString();
                String phone = fragmentLoginBinding.editTextPhone.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putString("phone", phone);
                productsFragment1.setArguments(bundle);
                FragmentTransaction fragm = getFragmentManager().beginTransaction();
                fragm.replace(R.id.fragment_container,  productsFragment1).commit();
            }
        });
    }
}