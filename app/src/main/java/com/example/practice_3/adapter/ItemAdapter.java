package com.example.practice_3.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice_3.R;
import com.example.practice_3.model.Item;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static String TAG = "tag";
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
    //начинает заполнять вью
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int index) {
        TextView name = holder.itemView.findViewById(R.id.text_view_item);
        name.setText(this.items.get(index).getName());
        holder.itemView.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Нажали во втором каталоге");
                Toast toast = Toast.makeText(v.getContext(), "нажали на " + (index+1), Toast.LENGTH_LONG );
                toast.show();
            }});
    }
    @Override
    public int getItemCount() {
        return this.items.size();
    }
}
