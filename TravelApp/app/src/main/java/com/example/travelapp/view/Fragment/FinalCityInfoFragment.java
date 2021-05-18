package com.example.travelapp.view.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travelapp.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

//View for Specialization for different cities
public class FinalCityInfoFragment extends Fragment {
    TextView txtCityName;
    Button btnHangout;

    public FinalCityInfoFragment() {
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
        View view = inflater.inflate(R.layout.fragment_final_city_info, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtCityName = view.findViewById(R.id.detailTitle);
        btnHangout = view.findViewById(R.id.hgbtn);
        final NavController navController = Navigation.findNavController(view);
        btnHangout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(getContext());
                if (available == ConnectionResult.SUCCESS) {
//                    Toast.makeText(getContext(), "google api available", Toast.LENGTH_LONG).show();

                    String cid = txtCityName.getText().toString();
                    Fragment fr = new ClinicFragment();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    Bundle args = new Bundle();
                    args.putString("CID", cid);
                    fr.setArguments(args);
                    ft.replace(R.id.fragment_container, fr);
                    ft.commit();

                }
            }
        });

        String myValue = this.getArguments().getString("message");
        txtCityName.setText(myValue);
    }

}