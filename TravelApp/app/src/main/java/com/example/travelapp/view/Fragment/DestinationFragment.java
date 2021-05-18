package com.example.travelapp.view.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travelapp.R;
import com.example.travelapp.adapter.Adapter;
import com.example.travelapp.adapter.CityAdapter;

import java.util.ArrayList;
import java.util.List;

public class DestinationFragment extends Fragment {
    List<String> titles;
    ArrayList<String> ImgUrl = new ArrayList<>();
    RecyclerView recyclerView;
    GridLayoutManager Manager;
    Adapter adapter;
    LinearLayoutManager linearLayoutManager;

    public DestinationFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_destination, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.card_recycler_view);
        titles = new ArrayList<>();
//ArrayList for title and Images of cities
        titles.add("Delhi");
        titles.add("Mumbai");
        titles.add("Bangalore");
        titles.add("Pune");
        titles.add("Chennai");
        titles.add("Kolkata");
        titles.add("Jaipur");
        titles.add("Hyderabad");
        titles.add("Panjim");
        titles.add("Ahmedabad");


        ImgUrl.add("https://upload.wikimedia.org/wikipedia/commons/9/94/%E0%B4%96%E0%B5%81%E0%B4%A4%E0%B5%8D%E0%B4%AC%E0%B5%8D_%E0%B4%AE%E0%B4%BF%E0%B4%A8%E0%B4%BE%E0%B5%BC1.jpg");
        ImgUrl.add("https://static1.squarespace.com/static/55917ae2e4b0984fc8c264c4/t/5ad7a037758d464041bfba27/1524102624280/Victoria_Mumbai.jpg");
        ImgUrl.add("https://www.tripsavvy.com/thmb/XsDfjokA4nbyEBQ7fBDv-aRammc=/950x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/GettyImages-536116268-5b5d74e846e0fb0050adcf3b.jpg");
        ImgUrl.add("https://www.zricks.com/ImagesPostProject/47929//6557d975-20a9-4c6c-a776-8072a1936a76.jpg");
        ImgUrl.add("http://lh3.ggpht.com/_YLb7tJ8RoAk/SfazBLdgf3I/AAAAAAAANEg/p52_Zz_URxg/s640/Picture%20009.jpg");
        ImgUrl.add("https://i.pinimg.com/originals/05/ec/42/05ec42c545b494d12cc612923483b4f0.jpg");
        ImgUrl.add("https://www.trodly.com/pictures/attraction/1943.jpg");
        ImgUrl.add("https://i1.trekearth.com/photos/59194/charminar_020_sm.jpg");
        ImgUrl.add("http://www.nomad4ever.com/wp-content/uploads/2009/04/palm-trees-at-baga-creek-north-goa1.jpg");
        ImgUrl.add("https://static.amazon.jobs/locations/23/thumbnails/Bangalore_thumb.jpg?1456283961");

//To set Adapter view
        this.recyclerView = view.findViewById(R.id.card_recycler_view);
        linearLayoutManager = new LinearLayoutManager(getContext());
        Manager = new GridLayoutManager(getContext(), 2, Manager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Adapter(ImgUrl, titles, getContext());
        recyclerView.setAdapter(adapter);


    }
}