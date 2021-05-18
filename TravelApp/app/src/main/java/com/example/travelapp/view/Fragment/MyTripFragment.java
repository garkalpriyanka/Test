package com.example.travelapp.view.Fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.travelapp.R;
import com.example.travelapp.adapter.FileHelper;
import com.google.android.material.navigation.NavigationView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
//view for functionality for adding trip
public class MyTripFragment extends Fragment {

    final Calendar myCalendar = Calendar.getInstance();
    EditText editText;
    EditText itemET;
    Date city_name;
    Button btn_addtrip;
    Spinner select_city_name;

    private ListView itemsList;
    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    public MyTripFragment() {
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
        return inflater.inflate(R.layout.fragment_my_trip, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = view.findViewById(R.id.sdate);
        btn_addtrip = view.findViewById(R.id.add_trip);
        select_city_name = view.findViewById(R.id.select_city_name);
        itemET = view.findViewById(R.id.sdate);
        itemsList = view.findViewById(R.id.list_item);
        items = FileHelper.readData(getContext());

        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, items);
        itemsList.setAdapter(adapter);


        final NavController navController = Navigation.findNavController(view);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
        editText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btn_addtrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city_name = myCalendar.getTime();
                String spinner_item = select_city_name.getSelectedItem().toString();
                Toast.makeText(getContext(), "item is" + spinner_item, Toast.LENGTH_LONG).show();


                switch (view.getId()) {
                    case R.id.add_trip:
                        String itemEntered = myCalendar.getTime().toString();
                        String city = select_city_name.getSelectedItem().toString();
                        adapter.add(city);
                        adapter.add(itemEntered);

                        itemET.setText("");
                        itemET.setText("");
                        FileHelper.writeData(items, getContext());
                        Toast.makeText(getContext(), "Item Added", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });

        itemsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                items.remove(position);
                adapter.notifyDataSetChanged();
                FileHelper.writeData(items, getContext());
                Toast.makeText(getContext(), "Delete", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        editText.setText(sdf.format(myCalendar.getTime()));


    }


}