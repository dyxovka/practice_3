package com.example.practice_3.ui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.practice_3.FlowerApp;
import com.example.practice_3.R;
import com.example.practice_3.databinding.FragmentAddFlowerBinding;
import com.example.practice_3.datasources.room.FlowerDao;
import com.example.practice_3.datasources.room.FlowerRoomDatabase;
import com.example.practice_3.model.FlowerEntity;
import com.example.practice_3.repository.FlowerRepository;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddFlower#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class AddFlower extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private FragmentAddFlowerBinding fragmentAddFlowerBinding;




    public static AddFlower newInstance(String param1, String param2) {
        AddFlower fragment = new AddFlower();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public AddFlower() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentAddFlowerBinding.addFlower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FlowerRepository flowerRepository = new FlowerRepository(getContext());
                TextView textView = view.findViewById(R.id.textView3);
                String name = textView.getText().toString();
                flowerRepository.flowerDao.insert(new FlowerEntity(name));

            }
        });

        return inflater.inflate(R.layout.fragment_add_flower, container, false);
    }
}