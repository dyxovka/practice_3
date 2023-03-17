package com.example.practice_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Adapter_ListView extends ArrayAdapter<String> {

    private Context context;
    private String[] names;
    public Adapter_ListView(@NonNull Context context, String[] names) {
        super(context, R.layout.item, names);
        this.context = context;
        this.names = names;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item, parent, false);
        TextView name = view.findViewById(R.id.text_view_item);
        name.setText(this.names[position]);

        return view;
    }
}
