package com.finish.payanterm.aslijava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import com.finish.payanterm.R;
import com.finish.payanterm.databases.DatabaseOpenHelper;

public class add_bus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bus);
        Button cancellbtn=(Button)findViewById(R.id.cancellbtn);
        Button savebtn=(Button)findViewById(R.id.savebtn);
        final EditText EDPL=(EditText)findViewById(R.id.editpl);
        final EditText EDnmsan=(EditText)findViewById(R.id.editnumbersa);
        final EditText EDmo=(EditText)findViewById(R.id.editemodel);
        final EditText EDyear=(EditText)findViewById(R.id.edityear);


cancellbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        Intent intent=new Intent(add_bus.this,bus.class);
        startActivity(intent);
    }
});

    savebtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (EDPL.getText().length() == 0 || EDnmsan.getText().length() == 0 || EDmo.getText().length() == 0 || EDyear.getText().length()==0 ) {
                Toast.makeText(add_bus.this, "لطفا اطلاعات را وارد کنید", Toast.LENGTH_SHORT).show();
                return;
            }



            bus buss = new bus();
            buss.setPLAQUE(EDPL.getText().toString());
            buss.setNUMBER_OF_SEATS(EDnmsan.getText().toString());
            buss.setMODEL(EDmo.getText().toString());

         //   buss.setPRODUCTION_YEAR(EDyear.getText().toString());
            DatabaseOpenHelper databaseOpenHelper=new DatabaseOpenHelper(add_bus.this);
            databaseOpenHelper.insertToBus(buss);
            //   refreshList();



            Intent intent=new Intent(add_bus.this,bus.class);
            startActivity(intent);

        }
    });





    }
}
