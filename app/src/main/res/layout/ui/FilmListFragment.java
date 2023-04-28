package com.ctacekscompany.cinemateque.ui;


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
import  com.example.practice_3.R;
import  com.example.practice_3.databinding.FragmentFilmlistBinding;
import com.example.practice_3.viewmodels.FlowerVM;


public class FilmListFragment extends Fragment {
    private FragmentFilmlistBinding binding;
    private String clientName;

    private FlowerVM filmListViewModel;

    private CustomAdapter filmRecycleAdapter;

    public FilmListFragment() {
        super(R.layout.fragment_catalog);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        filmListViewModel = new ViewModelProvider(this).get(FlowerVM.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmlistBinding.inflate(inflater, container, false);
        filmRecycleAdapter = new CustomAdapter(getContext(), (film, position) -> {
            Bundle bundle = new Bundle();
            bundle.putString("filmName", film.getName());
            bundle.putInt("posterId", film.get_pic());

            Navigation.findNavController(requireView()).navigate(R.id.action_mainFragment_to_filmInfoFragment, bundle);

            Log.i("TAG", "Был выбран фильм: " + film.getName() + " " + film.get_pic());
        });

        return binding.getRoot();
    }

    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        clientName = "Noname";

        if (getArguments() != null) {
            clientName = getArguments().getString("secretKey2");
        }

        binding.recyclerView.setAdapter(filmRecycleAdapter);
        filmListViewModel.flower.observe(getViewLifecycleOwner(), filmArrayList ->
                filmRecycleAdapter.updateFilmList(filmArrayList));


        binding.textView.setText(getString(R.string.hello_client) + clientName);

        binding.buttonLogin.setOnClickListener(v -> {
                    Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_loginFragment);
                }
        );
        binding.buttonSettings.setOnClickListener(v -> {
                    Bundle bundle = new Bundle();
                    bundle.putString("secretKey", clientName);
                    Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_settingsFragment, bundle);
                }
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}