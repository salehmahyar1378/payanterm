package com.finish.payanterm.aslijava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.finish.payanterm.R;
import com.finish.payanterm.databases.DatabaseHelper;
import com.finish.payanterm.databases.DatabaseOpenHelper;

import java.util.List;

public class bus extends AppCompatActivity {

    private String PLAQUE;
    private String NUMBER_OF_SEATS;
    private String MODEL;
    private String PRODUCTION_YEAR;


    private Button btnSubmit;
    private Button btnCancel;
    private ListView listView;
    private MyListAdapter adapter;
    private EditText edtSearch;
    private EditText plaque;
    private EditText tedadsandali;
    private EditText model;
    private EditText saltolidd;
    private int seletcedEmployeeId;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        Button btnAdd = (Button) findViewById(R.id.btn_add);
        Button btnShowSearch = (Button) findViewById(R.id.btn_search);
        Button btnCloseSearch = (Button) findViewById(R.id.btn_close_search);
        Button btnDoSearch = (Button) findViewById(R.id.btn_do_search);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
        btnSubmit = (Button) findViewById(R.id.btn_submit);

        edtSearch = (EditText) findViewById(R.id.edt_search);
        plaque = (EditText) findViewById(R.id.placue);
        tedadsandali = (EditText) findViewById(R.id.tedadsandli);
        model = (EditText) findViewById(R.id.moddel);
        //saltolidd = (EditText) findViewById(R.id.saltolid);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bus.this,add_bus.class);
                startActivity(intent);
            }
        });

        btnShowSearch.setOnClickListener(onShowSearchClicked);
        btnCloseSearch.setOnClickListener(onCloseSearchClicked);
        btnDoSearch.setOnClickListener(onDoSearchClicked);
        btnCancel.setOnClickListener(onCancelbuttonClicked);

        listView = (ListView) findViewById(R.id.listView);
        refreshList();
    }

    public void refreshList() {
        List<bus> buss = new DatabaseHelper(this).getListOfbus();
        adapter = new MyListAdapter(this, buss);
        listView.setAdapter(adapter);
    }

    public void editEmployee(bus buss) {
        findViewById(R.id.lin_add_search).setVisibility(View.GONE);
        findViewById(R.id.add_edit_bus).setVisibility(View.VISIBLE);
        btnSubmit.setOnClickListener(onEditbusSubmit);
        plaque.setText(buss.getPLAQUE());
        tedadsandali.setText(buss.getNUMBER_OF_SEATS());
        model.setText(buss.getMODEL());
        saltolidd.setText(buss.getPRODUCTION_YEAR());
    }

 /*   private View.OnClickListener onAddClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            findViewById(R.id.lin_add_search).setVisibility(View.GONE);
            findViewById(R.id.add_edit_bus).setVisibility(View.VISIBLE);
            btnSubmit.setOnClickListener(onNewEmployeeSubmit);
        }
    };
*/
    private View.OnClickListener onShowSearchClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            findViewById(R.id.lin_add_search).setVisibility(View.GONE);
            findViewById(R.id.search_bar).setVisibility(View.VISIBLE);
        }
    };

    private View.OnClickListener onCloseSearchClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            findViewById(R.id.lin_add_search).setVisibility(View.VISIBLE);
            findViewById(R.id.search_bar).setVisibility(View.GONE);
            edtSearch.setText("");
            refreshList();
        }
    };

    private View.OnClickListener onDoSearchClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String input = edtSearch.getText().toString();
            if (input.length() == 0) {
                Toast.makeText(bus.this, "لطفا قسمتی از نام کارمند را بنویسید", Toast.LENGTH_SHORT).show();
                return;
            }

            List<bus> employees = new DatabaseHelper(bus.this).searchByName(input);
            adapter = new MyListAdapter(bus.this, employees);
            listView.setAdapter(adapter);
            Toast.makeText(bus.this, employees.size() + " کارمند پیدا شد", Toast.LENGTH_SHORT).show();
        }
    };

    public View.OnClickListener onCancelbuttonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            plaque.setText("");
            tedadsandali.setText("");
            model.setText("");
       //     saltolidd.setText("");
            findViewById(R.id.lin_add_search).setVisibility(View.VISIBLE);
            findViewById(R.id.add_edit_bus).setVisibility(View.GONE);
        }
    };

  /*  public View.OnClickListener onNewEmployeeSubmit = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (plaque.getText().length() == 0 || tedadsandali.getText().length() == 0 || model.getText().length() == 0) {
                Toast.makeText(bus.this, "لطفا اطلاعات را وارد کنید", Toast.LENGTH_SHORT).show();
                return;
            }
            bus buss = new bus();
            buss.setPLAQUE(plaque.getText().toString());
            buss.setNUMBER_OF_SEATS(tedadsandali.getText().toString());
            buss.setMODEL(model.getText().toString());

            //admin buss.setPRODUCTION_YEAR(saltolidd.getText().toString());
            DatabaseOpenHelper databaseOpenHelper=new DatabaseOpenHelper(bus.this);
            databaseOpenHelper.insertToBus(buss);
         //   refreshList();
            btnCancel.performClick();
        }
    };
*/
    public View.OnClickListener onEditbusSubmit = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (plaque.getText().length() == 0 || tedadsandali.getText().length() == 0 || model.getText().length() == 0) {
                Toast.makeText(bus.this, "لطفا اطلاعات را وارد کنید", Toast.LENGTH_SHORT).show();
                return;
            }
            bus buuss = new bus();
            buuss.setPRODUCTION_YEAR(saltolidd.getText().toString());
            buuss.setPLAQUE(plaque.getText().toString());
            buuss.setNUMBER_OF_SEATS(tedadsandali.getText().toString());
            buuss.setMODEL(model.getText().toString());
            new DatabaseHelper(bus.this).edit_bus(buuss);
            refreshList();
            btnCancel.performClick();
        }
    };



    public String getPLAQUE() {
        return PLAQUE;
    }

    public void setPLAQUE(String PLAQUE) {
        this.PLAQUE = PLAQUE;
    }

    public String getNUMBER_OF_SEATS() {
        return NUMBER_OF_SEATS;
    }

    public void setNUMBER_OF_SEATS(String NUMBER_OF_SEATS) {
        this.NUMBER_OF_SEATS = NUMBER_OF_SEATS;
    }


    public String getMODEL() {
        return MODEL;
    }

    public void setMODEL(String MODEL) {
        this.MODEL = MODEL;
    }

    public String getPRODUCTION_YEAR() {
        return PRODUCTION_YEAR;
    }

    public void setPRODUCTION_YEAR(String PRODUCTION_YEAR) {
        this.PRODUCTION_YEAR = PRODUCTION_YEAR;
    }
}
