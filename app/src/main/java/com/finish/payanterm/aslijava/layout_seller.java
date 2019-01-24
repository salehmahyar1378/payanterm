package com.finish.payanterm.aslijava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import com.finish.payanterm.R;

public class layout_seller extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_seller);

        ScrollView scrollView=(ScrollView)findViewById(R.id.sccc);

        Button addsafar=(Button)findViewById(R.id.addnewsafar);
        Button addmosafer=(Button)findViewById(R.id.btnadd_edit_mosafer);
        Button newblit=(Button)findViewById(R.id.new_blit);
        Button cancell_blit=(Button)findViewById(R.id.cancell_blit);
        Button search_safar=(Button)findViewById(R.id.search_safar);
        Button search_mosafer=(Button)findViewById(R.id.search_mosafer);
        Button search_driver=(Button)findViewById(R.id.search_driver);
        Button edditseller=(Button)findViewById(R.id.edit_seller);

        addsafar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(layout_seller.this,add_safar.class);
                startActivity(intent);
            }
        });


        addmosafer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(layout_seller.this,add_mosafer.class);
                startActivity(intent);

            }
        });

        newblit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(layout_seller.this,newblit.class);
                startActivity(intent);
            }
        });

        cancell_blit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(layout_seller.this,cancellllblit.class);
                startActivity(intent);
            }
        });

        search_safar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(layout_seller.this,searchhsafar.class);
                startActivity(intent);
            }
        });
        search_mosafer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(layout_seller.this,searchhhmosafer.class);
                startActivity(intent);


            }
        });

        search_driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(layout_seller.this,search_driver.class);
                startActivity(intent);
            }
        });


        edditseller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(layout_seller.this,edit_seller.class);
                startActivity(intent);
            }
        });

    }
}
