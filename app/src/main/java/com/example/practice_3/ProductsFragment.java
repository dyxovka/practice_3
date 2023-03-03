package com.example.practice_3;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice_3.databinding.FragmentLoginBinding;
import com.example.practice_3.databinding.FragmentProductsBinding;

public class ProductsFragment extends Fragment {
    private static String TAG = "tag";
    FragmentProductsBinding fragmentProductsBinding;

    public ProductsFragment() {
        // Required empty public constructor
    }

    public static ProductsFragment newInstance(String param1, String param2) {
        ProductsFragment fragment = new ProductsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast toast = Toast.makeText(getContext(), "onCreate", Toast.LENGTH_LONG);
        toast.show();
        Log.d(TAG, "onCreate");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
        Toast toast = Toast.makeText(getContext(), "onAttach", Toast.LENGTH_LONG);
        toast.show();
    }

    private void buttonsBinding(Bundle bundle) {
        fragmentProductsBinding.buttonGotovo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginFragment loginFragment = new LoginFragment();
                Bundle bundle = getArguments();
                String name = "";
                String phone = "";
                if (bundle != null) {
                    name = bundle.getString("name");
                    phone = bundle.getString("phone");
                }

                Bundle bundle1 = new Bundle();
                bundle1.putString("name", name);
                bundle1.putString("phone", phone);
                loginFragment.setArguments(bundle1);
                FragmentTransaction fragm = getFragmentManager().beginTransaction();
                fragm.replace(R.id.fragment_container, loginFragment).commit();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentProductsBinding = fragmentProductsBinding.inflate(inflater, container, false);
        buttonsBinding(new Bundle());
        Log.d(TAG, "onCreateView");
        Toast toast = Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_LONG);
        toast.show();
        return fragmentProductsBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated");
        Toast toast = Toast.makeText(getContext(), "onViewCreated", Toast.LENGTH_LONG);
        toast.show();
        Bundle bundle = getArguments();
        if (bundle != null) {
            String recieveInfo = bundle.getString("name");
            TextView editText = view.findViewById(R.id.textView5_for_name);
            editText.setText(recieveInfo);
        }
    }
}

/*
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d(TAG, "onViewStateRestored");
        Toast toast = Toast.makeText(getContext(), "onViewStateRestored", Toast.LENGTH_LONG );
        toast.show();
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        Toast toast = Toast.makeText(getContext(), "onStart", Toast.LENGTH_LONG );
        toast.show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        Toast toast = Toast.makeText(getContext(), "onResume", Toast.LENGTH_LONG );
        toast.show();
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        Toast toast = Toast.makeText(getContext(), "onPause", Toast.LENGTH_LONG );
        toast.show();
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
        Toast toast = Toast.makeText(getContext(), "onStop", Toast.LENGTH_LONG );
        toast.show();
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
        Toast toast = Toast.makeText(getContext(), "onSaveInstanceState", Toast.LENGTH_LONG );
        toast.show();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
        Toast toast = Toast.makeText(getContext(), "onDestroyView", Toast.LENGTH_LONG );
        toast.show();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        Toast toast = Toast.makeText(getContext(), "onDestroy", Toast.LENGTH_LONG );
        toast.show();
    }
}*/
