package com.example.practice_3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.practice_3.model.Flower;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {


    public interface OnFilmClickListener {
        void onFilmClick(Flower flower, int position);
    }

    private final OnFilmClickListener onClickListener;
    private final LayoutInflater inflater;
    public List<Flower> flowers;

    public CustomAdapter(Context context, OnFilmClickListener onClickListener) {
        this.flowers = new ArrayList<>();
        this.onClickListener = onClickListener;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_film, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Flower flower = flowers.get(position);
        holder.posterView.setImageResource(flower.get_pic());
        holder.nameView.setText(flower.getName());
        holder.itemView.setOnClickListener(v -> onClickListener.onFilmClick(flower, position));
    }


    public void updateFilmList(final List<Flower> flowers) {
        this.flowers.clear();
        this.flowers = flowers;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return flowers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView posterView;
        final TextView nameView;

        ViewHolder(View view) {
            super(view);
            posterView = view.findViewById(R.id.poster);
            nameView = view.findViewById(R.id.name);
        }
    }
}
