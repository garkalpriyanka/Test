package com.example.travelapp.view.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travelapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ClinicFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    String cityName;

    public static ClinicFragment newInstance() {
        ClinicFragment fragment = new ClinicFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clinic, null, false);

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng testLocation;
        String strtext = getArguments().getString("CID");

        if (strtext == "Delhi") {
            testLocation = new LatLng(28.683905, 77.234172);
        } else if (strtext == "Mumbai") {
            testLocation = new LatLng(19.063972, 72.881873);

        } else if (strtext == "Bangalore") {
            testLocation = new LatLng(12.968570, 77.614460);

        } else if (strtext == "Pune") {
            testLocation = new LatLng(18.514542, 73.858161);

        } else if (strtext == "Chennai") {
            testLocation = new LatLng(13.025859, 80.263256);

        } else if (strtext == "Kolkata") {
            testLocation = new LatLng(22.560039, 88.360627);

        } else if (strtext == "Jaipur") {
            testLocation = new LatLng(26.891233, 75.785751);

        } else if (strtext == "Hyderabad") {
            testLocation = new LatLng(17.404486, 78.504176);

        } else if (strtext == "Panijim") {
            testLocation = new LatLng(15.490776, 73.822581);

        } else {
            //Ahmedabad
            testLocation = new LatLng(23.022455, 72.566696);

        }
        mMap.addMarker(new MarkerOptions().position(testLocation).title("Marker in cities"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(testLocation));
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


}