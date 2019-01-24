package com.finish.payanterm.aslijava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.finish.payanterm.R;
import com.finish.payanterm.databases.DatabaseHelper;

import java.util.List;

public class driver extends AppCompatActivity {


    private String code_melli;
    private String firstname;
    private String lastname;
    private String noe_govayname;
    private String addres;
    private String shomare_tamas;
private ListView listView=(ListView)findViewById(R.id.listviewdriver);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);


        Button adddriver = (Button) findViewById(R.id.add_driver);

        adddriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(driver.this, add_edit_driver.class);
                startActivity(intent);

            }
        });
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNoe_govayname() {
        return noe_govayname;
    }

    public void setNoe_govayname(String noe_govayname) {
        this.noe_govayname = noe_govayname;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getCode_melli() {
        return code_melli;
    }

    public void setCode_melli(String code_melli) {
        this.code_melli = code_melli;
    }

    public String getShomare_tamas() {
        return shomare_tamas;
    }

    public void setShomare_tamas(String shomare_tamas) {
        this.shomare_tamas = shomare_tamas;
    }
}
