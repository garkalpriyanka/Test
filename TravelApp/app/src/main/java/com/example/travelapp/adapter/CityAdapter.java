package com.example.travelapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelapp.R;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    List<String> titles;
    List<String> images;
    LayoutInflater inflater;


    public CityAdapter(Context ctx, List<String> titles, List<String> images) {
        this.titles = titles;
        this.images = images;
        this.inflater = LayoutInflater.from(ctx);

    }

    @NonNull
    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_grid_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityAdapter.ViewHolder holder, int position) {
        holder.txtTitle.setText(titles.get(position));
        holder.imgCity.setImageResource(Integer.parseInt(images.get(position)));

    }


    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle;
        ImageView imgCity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtCity);
            imgCity = itemView.findViewById(R.id.imageView);

        }

    }
}
