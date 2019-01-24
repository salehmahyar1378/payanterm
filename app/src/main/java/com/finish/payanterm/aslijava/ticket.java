package com.finish.payanterm.aslijava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.finish.payanterm.R;

public class ticket extends AppCompatActivity {



    private long ticket_number;
    private long code_melli;
    private long number_seats;
    private long safar_number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
    }
}
