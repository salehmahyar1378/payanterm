package com.finish.payanterm.aslijava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.finish.payanterm.R;

public class the_user extends AppCompatActivity {


    private long code_melli;
    private String firstname;
    private String lastname;
    private String official;
    private String password;
    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_user);
    }
}
