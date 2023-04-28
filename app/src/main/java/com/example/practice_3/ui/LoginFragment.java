package com.example.practice_3.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.practice_3.R;
import com.example.practice_3.databinding.FragmentLoginBinding;
import com.example.practice_3.viewmodels.LoginViewModel;


public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private LoginViewModel loginViewModel;

    public LoginFragment() {
        super(R.layout.fragment_login);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.loginButton.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_mainFragment2));
        binding.loginButton.setOnClickListener(v -> {
            loginViewModel.createFileAppSpecific(requireContext(), "",
                    binding.editTextPersonEmail.getText() + " " +
                            binding.editTextPersonPassword.getText());

            loginViewModel.createFileExtWithToast(requireActivity(), "",
                    binding.editTextPersonEmail.getText() + " " +
                            binding.editTextPersonPassword.getText());

            loginViewModel.createFileSharedPreferences(requireContext(), "",
                    binding.editTextPersonEmail.getText() + " " +
                            binding.editTextPersonPassword.getText());
        });



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}