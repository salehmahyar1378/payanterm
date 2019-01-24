package com.finish.payanterm.aslijava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.finish.payanterm.R;

public class layout_admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_admin);

        Button busbtn=(Button)findViewById(R.id.btnbus);
        Button add_clearbtn=(Button)findViewById(R.id.btnadd_clear);
        Button btnedit=(Button)findViewById(R.id.btnedittt);
        Button btnaddnew=(Button)findViewById(R.id.btnaddnew);

btnedit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    }
});

        busbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentn=new Intent(layout_admin.this,bus.class);
                startActivity(intentn);
            }
        });

        add_clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentn=new Intent(layout_admin.this,add_ranande.class);
                startActivity(intentn);

            }
        });

        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             Intent intentn=new Intent(layout_admin.this,edddddit.class);
                startActivity(intentn);

            }
        });

        btnaddnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentn=new Intent(layout_admin.this,sellernew.class);
                startActivity(intentn);

            }
        });
    }
}
