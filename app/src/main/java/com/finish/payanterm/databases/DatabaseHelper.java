package com.finish.payanterm.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.finish.payanterm.aslijava.bus;
import com.finish.payanterm.aslijava.driver;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {

    ContentValues values = new ContentValues();
     SQLiteDatabase mydb;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public int cheack_user_admin(String user, String pass) {


        Cursor allrows=mydb.rawQuery("SELECT user_admin", new String[]{DatabaseOpenHelper.TABLE_USERS_ADMIN},null);

        if (user.equals(allrows.getString(0)) && pass.equals(allrows.getString(1))) {
            allrows.close();
            mydb.close();

            return 1;
        } else return 0;


    }


    public int cheack_user_seller(String user, String pass) {
        Cursor allrows = mydb.query(DatabaseOpenHelper.TABLE_USERS_SELLER, new String[]{"user_seller"}, null, null,
                null, null, null, null);
        Cursor allrowspas = mydb.query(DatabaseOpenHelper.TABLE_USERS_SELLER, new String[]{"PASS_seller"}, null, null,
                null, null, null, null);
        if (user.equals(allrows.getCount()) && pass.equals(allrowspas.getCount())) {
            allrows.close();
            allrowspas.close();
            mydb.close();

            return 1;
        } else return 0;

    }

    public DatabaseHelper(Context context) {
        mydb = new DatabaseOpenHelper(context).getWritableDatabase();
    }

    public void insertToBus(bus buss) {

        values.put("PLAQUE", buss.getPLAQUE());
        values.put("NUMBER_OF_SEATS", buss.getNUMBER_OF_SEATS());
        values.put("MODEL", buss.getMODEL());
       // this.mydb = mydb;
        values.put("PRODUCTION_YEAR", buss.getPRODUCTION_YEAR());


        mydb.insert(DatabaseOpenHelper.TABLE_BUS, null, values);
        mydb.close();
    }

    public void edit_bus(bus buss) {

        values.put("PLAQUE", buss.getPLAQUE());
        values.put("NUMBER_OF_SEATS", buss.getNUMBER_OF_SEATS());
        values.put("MODEL", buss.getMODEL());
        values.put("PRODUCTION_YEAR", buss.getPRODUCTION_YEAR());

        mydb.update(DatabaseOpenHelper.TABLE_BUS, values, "PLAQUE= " + buss.getPLAQUE(), null);
        mydb.close();
    }


    public void deleteBus(bus buss) {
        mydb.delete(DatabaseOpenHelper.TABLE_BUS, "plaque = " + buss.getPLAQUE(), null);
        mydb.close();
    }

    public void new_driver(int DRIVER_CODE_MELLI, String DRIVER_NAME, String DRIVER_LAST_NAME,
                           String DRIVER_CERTIFLCATES, int DRIVER_NUMBER_PHONE, String DRIVER_ADDRESS) {
        ContentValues values = new ContentValues();
        values.put(DatabaseOpenHelper.DRIVER_CODE_MELLI, DRIVER_CODE_MELLI);
        values.put(DatabaseOpenHelper.DRIVER_NAME, DRIVER_NAME);
        values.put(DatabaseOpenHelper.DRIVER_LAST_NAME, DRIVER_LAST_NAME);
        values.put(DatabaseOpenHelper.DRIVER_CERTIFLCATES, DRIVER_CERTIFLCATES);
        values.put(DatabaseOpenHelper.DRIVER_NUMBER_PHONE, DRIVER_NUMBER_PHONE);
        values.put(DatabaseOpenHelper.DRIVER_ADDRESS, DRIVER_ADDRESS);

        mydb.insert(DatabaseOpenHelper.TABLE_DRIVER, null, values);
        mydb.close();
    }


    public List<bus> getListOfbus() {

        Cursor c = mydb.rawQuery("select * FROM " + DatabaseOpenHelper.TABLE_BUS, null);
        List<bus> buss = new ArrayList<>();

        while (c.moveToNext()) {

            bus em = new bus();
            em.setPLAQUE(c.getString(c.getColumnIndex(DatabaseOpenHelper.BUS_PLAQUE)));
            em.setNUMBER_OF_SEATS(c.getString(c.getColumnIndex(DatabaseOpenHelper.BUS_NUMBER_OF_SEATS)));
            em.setMODEL(c.getString(c.getColumnIndex(DatabaseOpenHelper.BUS_MODEL)));
            em.setPRODUCTION_YEAR(c.getString(c.getColumnIndex(DatabaseOpenHelper.BUS_PRODUCTION_YEAR)));

            buss.add(em);
        }

        c.close();
        mydb.close();
        return buss;
    }


    public List<bus> searchByName(String name) {

        Cursor c = mydb.rawQuery("select * from " + DatabaseOpenHelper.TABLE_BUS
                + " where name like '%" + name + "%'", null);
        List<bus> buss = new ArrayList<>();

        while (c.moveToNext()) {

            bus em = new bus();
            em.setPLAQUE(c.getString(c.getColumnIndex(DatabaseOpenHelper.BUS_PLAQUE)));
            em.setNUMBER_OF_SEATS(c.getString(c.getColumnIndex(DatabaseOpenHelper.BUS_NUMBER_OF_SEATS)));
            em.setMODEL(c.getString(c.getColumnIndex(DatabaseOpenHelper.BUS_MODEL)));
            em.setPRODUCTION_YEAR(c.getString(c.getColumnIndex(DatabaseOpenHelper.BUS_PRODUCTION_YEAR)));

            buss.add(em);
        }

        c.close();
        mydb.close();
        return buss;
    }

    public void insertToDriver(driver driverr) {


    }

    /*  public void Update_admin_etelat(String olduser,String newuser, String pass){
          ContentValues values = new ContentValues();
          values.put(DatabaseOpenHelper.USER_ADMIN, olduser);

          mydb.update(DatabaseOpenHelper.SQL_USERS_ADMIN_TABLE, values,
                  DatabaseOpenHelper.USER_ADMIN + " = ?",
                  DatabaseOpenHelper.PASS_ADMIN + " = ?",
                  new String[] { String.valueOf(olduser) };

          mydb.close();
      }

    public void Update_seller_etelat(String olduser,String newuser, String pass){
        ContentValues values = new ContentValues();
        values.put(DatabaseOpenHelper.USER_SELLER, olduser);

        mydb.update(DatabaseOpenHelper.SQL_USERS_SELLER_TABLE, values,
                DatabaseOpenHelper.USER_SELLER + " = ?",
                DatabaseOpenHelper.PASS_SELLER + " = ?",
                new String[] { String.valueOf(olduser) };

        mydb.close();
    }

*/

}


