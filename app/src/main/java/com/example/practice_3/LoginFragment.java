package com.example.practice_3;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.practice_3.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {
    public FragmentLoginBinding fragmentLoginBinding;
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
        fragmentLoginBinding.buttonGotovo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductsFragment1 productsFragment1 = new ProductsFragment1();
                String name = fragmentLoginBinding.editTextTextPersonName.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_productsFragment1, bundle);
            }
        });
        fragmentLoginBinding.buttonGotovo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductsFragment2 productsFragment2 = new ProductsFragment2();
                String name = fragmentLoginBinding.editTextTextPersonName.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_productsFragment2, bundle);
            }
        });
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String done = bundle.getString("done");
            TextView editText1 = view.findViewById(R.id.textView_done);
            editText1.setText(done);
        }
    }
}