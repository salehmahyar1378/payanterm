package com.finish.payanterm.aslijava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.finish.payanterm.R;
import com.finish.payanterm.databases.DatabaseOpenHelper;

public class add_edit_driver extends AppCompatActivity {


    private String code_melli;
    private String firstname;
    private String lastname;
    private String noe_govayname;
    private String addres;
    private String shomare_tamas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_driver);
        final EditText Code_melli=(EditText)findViewById(R.id.edtcodemelli);
        final EditText Firstname=(EditText)findViewById(R.id.edtname);
        final EditText Lastname=(EditText)findViewById(R.id.edtlastname);
        final EditText Noe_govayname=(EditText)findViewById(R.id.edtgovahiname);
        final EditText Addres=(EditText)findViewById(R.id.editaddress);
        final EditText Shomare_tamas=(EditText)findViewById(R.id.editphone);
        Button btnsave=(Button)findViewById(R.id.savebtn);
        Button btncancell=(Button)findViewById(R.id.cancellbtn);


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code_melli=Code_melli.getText().toString();
                firstname=Firstname.getText().toString();
                lastname=Lastname.getText().toString();
                noe_govayname=Noe_govayname.getText().toString();
                addres=Addres.getText().toString();
                shomare_tamas=Shomare_tamas.getText().toString();


                driver driverr=new driver();
                driverr.setCode_melli(code_melli);
                driverr.setFirstname(firstname);
                driverr.setLastname(lastname);
                driverr.setNoe_govayname(noe_govayname);
                driverr.setAddres(addres);
                driverr.setShomare_tamas(shomare_tamas);

                DatabaseOpenHelper databaseOpenHelper=new DatabaseOpenHelper(add_edit_driver.this);
                databaseOpenHelper.inserttodriver(driverr);





            }
        });

    }

    public String getCode_melli() {
        return code_melli;
    }

    public void setCode_melli(String code_melli) {
        this.code_melli = code_melli;
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

    public String getShomare_tamas() {
        return shomare_tamas;
    }

    public void setShomare_tamas(String shomare_tamas) {
        this.shomare_tamas = shomare_tamas;
    }
}
