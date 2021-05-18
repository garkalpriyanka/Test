package com.example.travelapp.view.Fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.travelapp.R;
import com.google.android.material.navigation.NavigationView;

//view for menu options
public class NavDrawerFragment extends Fragment {
    private int mPreviousMenuItemId;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;

    private static final String TAG = "MainActivity";

    public NavDrawerFragment() {
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
        return inflater.inflate(R.layout.fragment_nav_drawer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        drawerLayout = view.findViewById(R.id.drawer);
        navigationView = view.findViewById(R.id.navigationview);

Toast.makeText(getContext(),"Please Click on Menu for more options",Toast.LENGTH_LONG).show();
        toolbar = view.findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar();


//        //toggle button
        drawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();

        // Find our drawer view
        drawerLayout = view.findViewById(R.id.drawer);

        final NavController navController = Navigation.findNavController(view);

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == mPreviousMenuItemId) {

                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                }

                int id = item.getItemId();
                Fragment fragment = null;
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                switch (id) {
                    case R.id.nav_settings:
                        fragment = new SettingsFragment();
                        break;

                    case R.id.nav_mytrips:
                        fragment = new MyTripFragment();
                        break;

                    case R.id.nav_city:
                        fragment = new DestinationFragment();
                        break;


                    case R.id.nav_about_us:
                        fragment = new AboutUsFragment();
                        break;

                    case R.id.nav_signout: {

                        final NavController navController = Navigation.findNavController(view);
                        navController.navigate(R.id.loginFragment);

                        break;
                    }
                }

                if (fragment != null) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, fragment).commit();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;

            }
        });

    }


}