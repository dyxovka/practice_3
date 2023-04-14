package com.example.practice_3.ui;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.practice_3.CustomAdapter;
import com.example.practice_3.R;
import com.example.practice_3.databinding.FragmentCatalogBinding;
import com.example.practice_3.viewmodels.FilmListViewModel;


public class CatalogFragment extends Fragment {

    private FragmentCatalogBinding binding;
    private String name_user;

    private FilmListViewModel listViewModel;

    private CustomAdapter adapter;

    public CatalogFragment() {
        super(R.layout.fragment_catalog);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listViewModel = new ViewModelProvider(this).get(FilmListViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCatalogBinding.inflate(inflater, container, false);
        adapter = new CustomAdapter(getContext(), (flower, position) -> {
            Bundle bundle = new Bundle();
            bundle.putString("filmName", flower.getName());
            bundle.putInt("posterId", flower.get_pic());

            Navigation.findNavController(requireView()).navigate(R.id.action_mainFragment_to_filmInfoFragment, bundle);

        });

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        name_user = "var";

        if (getArguments() != null) {
            name_user = getArguments().getString("secretKey2");
        }

        binding.recyclerView.setAdapter(adapter);
        listViewModel.films.observe(getViewLifecycleOwner(), filmArrayList ->
                adapter.updateFilmList(filmArrayList));


        binding.textView.setText("Хай " + name_user);

        binding.buttonLogin.setOnClickListener(v -> {
                    Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_loginFragment);
                }
        );

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}