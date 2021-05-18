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

//view for registration functionality for user
public class RegistrationFragment extends Fragment {
    EditText editTextUsername, editTextEmail, editTextPassword, editTextCnfPassword;
    Button buttonRegister;
    TextView textViewLogin;
    private UserDao userDao;

    public RegistrationFragment() {
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
        return inflater.inflate(R.layout.fragment_registration, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextUsername = view.findViewById(R.id.editTextUsername);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        editTextCnfPassword = view.findViewById(R.id.editTextCnfPassword);
        buttonRegister = view.findViewById(R.id.buttonRegister);
        textViewLogin = view.findViewById(R.id.textViewLogin);
        final NavController navController = Navigation.findNavController(view);

        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavOptions navOption = new NavOptions.Builder().setPopUpTo(R.id.loginFragment, true).build();
                navController.navigate(R.id.action_registrationFragment_to_loginFragment, null, navOption);
            }
        });

        userDao = Room.databaseBuilder(getContext(), UserDatabase.class, "mi-database.db").allowMainThreadQueries()
                .build().getUserDao();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editTextUsername.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String passwordConf = editTextCnfPassword.getText().toString().trim();
                if (userName.isEmpty()) {
                    editTextUsername.setError(getString(R.string.emptyUsername));
                } else if (email.isEmpty()) {
                    editTextEmail.setError(getString(R.string.emptyUsername));
                } else if (password.isEmpty()) {
                    editTextPassword.setError(getString(R.string.emptyPassword));
                } else if (password.equals(passwordConf)) {
                    User user = new User(userName, password, email);
                    userDao.insert(user);
                    navController.navigate(R.id.action_registrationFragment_to_loginFragment);

                } else {
                    Toast.makeText(getContext(), "Password is not matching", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}