package com.example.practice_3;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice_3.databinding.FragmentProducts2Binding;

import java.util.ArrayList;
import java.util.List;

public class ProductsFragment2 extends Fragment {
    private static String TAG = "tag";
    RecyclerView recyclerView;
    FragmentProducts2Binding fragmentProducts2Binding;
    private final List<Item> items = new ArrayList<>();
    private final RecyclerView.Adapter adapter_recycle = new ItemAdapter(this.items);


    public ProductsFragment2() {
        // Required empty public constructor
    }

    public static ProductsFragment2 newInstance(String param1, String param2) {
        ProductsFragment2 fragment = new ProductsFragment2();
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
        fragmentProducts2Binding.buttonGotovo1.setOnClickListener(new View.OnClickListener() {
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
        fragmentProducts2Binding = fragmentProducts2Binding.inflate(inflater, container, false);
        buttonsBinding(new Bundle());


        return fragmentProducts2Binding.getRoot();
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
        recyclerView = fragmentProducts2Binding.recycler;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter_recycle);
        for(int i = 0; i < 200; i++){

            this.items.add(new Item("Букет " + (i+1)));
            adapter_recycle.notifyItemInserted(this.items.size() - 1);
        }



    }


    private static final class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private final List<Item> items;

        public ItemAdapter(List<Item> items) {
            this.items = items;
        }

        @NonNull
        @Override
        //загрузка нового слоя (айтема)
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int index) {
            return new RecyclerView.ViewHolder(
                    LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.item_recycle, parent, false)
            ) {}; //анонимынй класс
        }

        @Override
        //начинает заполнять наше вью
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int index) {
            TextView name = holder.itemView.findViewById(R.id.text_view_item);
            name.setText(String.format("%s",  this.items.get(index).getName()));
            holder.itemView.setOnClickListener (new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast toast = Toast.makeText(v.getContext(), "нажали на " + (index+1), Toast.LENGTH_LONG );
                    toast.show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return this.items.size();
        }
    }
}

