package com.example.latam.activities.airports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.latam.daos.AirportDAO;
import com.example.latam.enums.Roles;
import com.example.latam.models.Airport;
import com.example.pets.R;

public class AirportShowActivity extends AppCompatActivity {
    private Airport airport;
    private AirportDAO airportDAO;
    TextView textHeader, textShowInitials, textShowUf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.airport_show_activity);
        airportDAO = new AirportDAO(this);
        airport = airportDAO.find(getIntent().getExtras().getInt("id"));

        textHeader = findViewById(R.id.textHeader);
        textShowInitials = findViewById(R.id.textShowInitials);
        textShowUf = findViewById(R.id.textShowUf);

        textHeader.setText(airport.getInitials());
        textShowInitials.setText(String.valueOf(airport.getInitials()));
        textShowUf.setText(String.valueOf(airport.getUf()));
    }

    public void back(View view) {
        startActivity(new Intent(this, AirportsActivity.class));
    }
}
