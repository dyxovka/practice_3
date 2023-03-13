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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice_3.databinding.FragmentProducts1Binding;

public class ProductsFragment1 extends Fragment {
    private static String TAG = "tag";
    ListView listView;
    FragmentProducts1Binding fragmentProducts1Binding;
    public ProductsFragment1() {
        // Required empty public constructor
    }
    public static ProductsFragment1 newInstance(String param1, String param2) {
        ProductsFragment1 fragment = new ProductsFragment1();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    private void buttonsBinding(Bundle bundle) {
        fragmentProducts1Binding.buttonGotovo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginFragment loginFragment = new LoginFragment();

                FragmentTransaction fragm = getFragmentManager().beginTransaction();
                fragm.replace(R.id.fragment_container, loginFragment).commit();
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentProducts1Binding = fragmentProducts1Binding.inflate(inflater, container, false);
        buttonsBinding(new Bundle());
        return fragmentProducts1Binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = fragmentProducts1Binding.listView;
        String[]  names = new String[200];
        for(int i = 0; i < 200; i++){
            String byket = "Букет " + i;
            names[i] = byket;

        }
        Adapter_ListView adapter_listView = new Adapter_ListView(getContext(), names);
        listView.setAdapter(adapter_listView);
    }
}
