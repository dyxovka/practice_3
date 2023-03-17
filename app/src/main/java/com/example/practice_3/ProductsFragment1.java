package com.example.practice_3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
                Bundle bundle = new Bundle();
                bundle.putString("done", "Был переход в первый каталог");
                Navigation.findNavController(view).navigate(R.id.action_productsFragment1_to_loginFragment, bundle);
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentProducts1Binding = fragmentProducts1Binding.inflate(inflater, container, false);
        buttonsBinding(new Bundle());
        fragmentProducts1Binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast toast = Toast.makeText(getContext(), "нажали на " + (position+1), Toast.LENGTH_LONG );
                toast.show();
                Log.i(TAG, "Нажали в первом каталоге");
          }
      });

        return fragmentProducts1Binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String recieveInfo = bundle.getString("name");
            TextView editText = view.findViewById(R.id.textView5_for_name);
            editText.setText(recieveInfo);
        }
        listView = fragmentProducts1Binding.listView;
        String[]  names = new String[200];
        for(int i = 0; i < 200; i++){
            String byket = "Букет " + (i+1);
            names[i] = byket;
        }
        Adapter_ListView adapter_listView = new Adapter_ListView(getContext(), names);
        listView.setAdapter(adapter_listView);
    }
}
