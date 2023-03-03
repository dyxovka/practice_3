package com.example.practice_3;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practice_3.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {
    public FragmentLoginBinding fragmentLoginBinding;
    ProductsFragment productsFragment;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    public LoginFragment() {

        // Required empty public constructor
    }


    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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

        /*return inflater.inflate(R.layout.fragment_login, container, false);*/
    }

    private void buttonsBinding(Bundle bundle) {
        fragmentLoginBinding.buttonGotovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragm = getFragmentManager().beginTransaction();

                productsFragment = new ProductsFragment();

                bundle.putString("arg1", "спорт");
                fragm.replace(R.id.fragment_container, productsFragment).commit();
                /*FragmentTransaction ft = fragmentManager.beginTransaction();
                LoginFragment catFragment = LoginFragment.newInstance("6", "Васька");
                ft.replace(R.id.your_placeholder, catFragment);
                ft.commit();*/


            }
        });
    }
}