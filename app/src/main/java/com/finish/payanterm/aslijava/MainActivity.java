package com.finish.payanterm.aslijava;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.finish.payanterm.R;
import com.finish.payanterm.databases.DatabaseHelper;
import com.finish.payanterm.databases.DatabaseOpenHelper;
import com.finish.payanterm.databases.User_Admin;
import com.finish.payanterm.databases.User_Seller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    DatabaseOpenHelper mydata;
    DatabaseHelper datahelp;
    public String user;
    public String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);














        TextView textView = (TextView) findViewById(R.id.tV1);
        TextView textView1 = (TextView) findViewById(R.id.tV2);
        final EditText editText_admin = (EditText) findViewById(R.id.edtu);
        final EditText editText_pass = (EditText) findViewById(R.id.edtp);
        final RadioButton radioButton_admin = (RadioButton) findViewById(R.id.radiobtn_admin);
        final RadioButton radioButton_seller = (RadioButton) findViewById(R.id.radiobtn_seller);
        final Button button = (Button) findViewById(R.id.login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/irannastaliq.ttf");

        textView.setTypeface(typeface);
        textView1.setTypeface(typeface);
        button.setTypeface(typeface);

        editText_admin.setTypeface(typeface);
        editText_pass.setTypeface(typeface);
        radioButton_admin.setTypeface(typeface);
        radioButton_seller.setTypeface(typeface);
        radioButton_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "مدیر قصد ورود دارد", Toast.LENGTH_SHORT).show();

            }
        });

        radioButton_seller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "فروشنده قصد ورود دارد", Toast.LENGTH_SHORT).show();

            }
        });
        if (radioButton_admin.isChecked() == true) {
            Toast.makeText(getApplicationContext(), "مدیر قصد ورود دارد", Toast.LENGTH_SHORT).show();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {

                user = editText_admin.getText().toString();
                pass = editText_pass.getText().toString();


                if (radioButton_admin.isChecked() == true) {

//                    Toast.makeText(getApplicationContext(),datahelp.cheack_user_admin(user, pass),Toast.LENGTH_SHORT).show();
                    if (user.equals("admin")&&pass.equals("admin")) {
                        Intent intent = new Intent(MainActivity.this, layout_admin.class);
                        startActivity(intent);
                      //  Toast.makeText(getApplicationContext(), "خوش آمدید مدیر عزیز", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(getApplicationContext(), "نام کاربری یا رمز اشتباه است", Toast.LENGTH_SHORT).show();
                }

                if (radioButton_seller.isChecked() == true) {


                    if (user.equals("seller")&&pass.equals("seller")) {
                        Intent intent = new Intent(MainActivity.this, layout_seller.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "خوش آمدید ", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(getApplicationContext(), "نام کاربری یا رمز اشتباه است", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}


