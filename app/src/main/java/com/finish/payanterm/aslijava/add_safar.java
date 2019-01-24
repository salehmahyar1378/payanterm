package com.finish.payanterm.aslijava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.finish.payanterm.R;

public class add_safar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_safar);


        TextView  shomaresafar= (TextView) findViewById(R.id.shomaresafar);
        TextView plakbus = (TextView) findViewById(R.id.plakbus);
        TextView code_melli_rannade= (TextView) findViewById(R.id.code_melli_ranande);
        TextView mabdae = (TextView) findViewById(R.id.mabdae);
        TextView maqsad= (TextView) findViewById(R.id.maqsadd);
        TextView qeymat = (TextView) findViewById(R.id.qeymatt);
        TextView datee = (TextView) findViewById(R.id.tarikh);
        TextView saatharkat = (TextView) findViewById(R.id.saatharkat);
//        TextView qeymat = (TextView) findViewById(R.id.qeymatt);
        Button saveetelaat=(Button)findViewById(R.id.save_etelaat);
        Button cancell=(Button)findViewById(R.id.save_etelaat);


    }
}
