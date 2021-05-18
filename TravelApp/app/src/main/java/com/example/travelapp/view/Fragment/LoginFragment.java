package com.example.travelapp.view.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travelapp.Dao.UserDao;
import com.example.travelapp.R;
import com.example.travelapp.data.User;
import com.example.travelapp.database.UserDatabase;

//View for login for user
public class LoginFragment extends Fragment {


    EditText editTextEmail, editTextPassword;
    Button buttonLogin;
    TextView textViewRegister;
    UserDao db;
    UserDatabase dataBase;

    public LoginFragment() {
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
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextEmail = view.findViewById(R.id.editTextEmail1);
        editTextPassword = view.findViewById(R.id.editTextPassword1);
        buttonLogin = view.findViewById(R.id.buttonLogin1);
        textViewRegister = view.findViewById(R.id.textViewRegister1);

        final NavController navController = Navigation.findNavController(view);
        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                navController.navigate(R.id.action_loginFragment_to_registrationFragment);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dataBase = Room.databaseBuilder(getContext(), UserDatabase.class, "mi-database.db")
                        .allowMainThreadQueries()
                        .build();

                db = dataBase.getUserDao();

                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                User user = db.getUser(email, password);
                if (user != null) {
                    final NavController navController = Navigation.findNavController(view);
                    NavOptions navOption = new NavOptions.Builder().setPopUpTo(R.id.navDrawerFragment, true).build();

                    navController.navigate(R.id.action_loginFragment_to_navDrawerFragment2, null, navOption);
                    Toast.makeText(getContext(), "Successfull login", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getContext(), "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}