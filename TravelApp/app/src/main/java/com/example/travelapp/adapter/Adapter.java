package com.example.travelapp.adapter;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.travelapp.R;
import com.example.travelapp.interfaces.RecyclerViewInterface;
import com.example.travelapp.view.Fragment.DestinationFragment;
import com.example.travelapp.view.Fragment.FinalCityInfoFragment;

import java.io.FileInputStream;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    ArrayList<String> urls;
    Context context;
    List<String> titles;
    private static RecyclerViewInterface itemListener;
    RelativeLayout relative;

    //constructor
    public Adapter(ArrayList<String> ImgUrl, List<String> titles, Context context_) {
        this.urls = ImgUrl;
        this.context = context_;
        this.titles = titles;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
        v.setLayoutParams(new RecyclerView.LayoutParams(1080, 800));
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.txtCity.setText(titles.get(position));
        Glide.with(this.context)
                .load(urls.get(position))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.getImage());
        final String item = titles.get(holder.getAdapterPosition());

        System.out.println("clicked2" + item);
        holder.relative1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("clicked1" + item);
                Bundle bundle = new Bundle();
                String myMessage = item;
                bundle.putString("message", myMessage);
                FinalCityInfoFragment fragInfo = new FinalCityInfoFragment();
                fragInfo.setArguments(bundle);

                FinalCityInfoFragment newFragment = new FinalCityInfoFragment();
                ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragInfo)
                        .addToBackStack(null)
                        .commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView txtCity;
        private RelativeLayout relative1;

        public ViewHolder(View v) {
            super(v);
            image = (ImageView) v.findViewById(R.id.img);
            txtCity = (TextView) v.findViewById(R.id.txtCity);
            relative1 = (RelativeLayout) v.findViewById(R.id.relative);
        }

        public ImageView getImage() {
            return this.image;
        }
    }

}