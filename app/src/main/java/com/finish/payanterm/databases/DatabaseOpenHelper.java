package com.finish.payanterm.databases;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.finish.payanterm.aslijava.bus;
import com.finish.payanterm.aslijava.driver;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseOpenHelper";

    public static final String dataname = "mydb.db";
    private static final int dataversion = 1;

    public static final String TABLE_BUS = "tbl_bus";
    public static final String TABLE_DRIVER = "tbl_driver";
    public static final String TABLE_USERS_ADMIN = "tbl_user_admin";
    public static final String TABLE_USERS_SELLER = "tbl_user_seller";

//private  static final String TABLE_

    //driver
    public static final String DRIVER_CODE_MELLI = "driver_code_melli";
    public static final String DRIVER_NAME = "driver_name";
    public static final String DRIVER_LAST_NAME = "driver_last_name";
    public static final String DRIVER_CERTIFLCATES = "driver_certiflcates";
    public static final String DRIVER_NUMBER_PHONE = "driver_number_phone";
    public static final String DRIVER_ADDRESS = "driver_address";

    public static final String SQL_DRIVER_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_DRIVER + "(" +
            DRIVER_CODE_MELLI + " TEXT PRIMARY KEY, " +
            DRIVER_NAME + " TEXT, " +
            DRIVER_LAST_NAME + " TEXT, " +
            DRIVER_CERTIFLCATES + " TEXT, " +
            DRIVER_NUMBER_PHONE + " TEXT, " +
            DRIVER_ADDRESS + " TEXT) ;";


    //user admin
    public static final String ID_ADMIN = "id_admin";
    public static final String USER_ADMIN = "user_admin";
    public static final String PASS_ADMIN = "pass_admin";

    public static final String SQL_USERS_ADMIN_TABLE = "CREATE TABLE " + TABLE_USERS_ADMIN + "(" +
            USER_ADMIN + " TEXT PRIMARY KEY, " +
            PASS_ADMIN + " TEXT) ;";


    public static final String ROW_ADMIN = "INSERT INTO " + TABLE_USERS_ADMIN + " ("
            + USER_ADMIN + ", " + PASS_ADMIN + ") Values ('admin', 'admin')";


    //user seller
    public static final String ID_SELLER = "id_seller";
    public static final String USER_SELLER = "user_seller";
    public static final String PASS_SELLER = "pass_seller";

    public static final String SQL_USERS_SELLER_TABLE = "CREATE TABLE " + TABLE_USERS_SELLER + "(" +
            USER_SELLER + " TEXT PRIMARY KEY , " +
            PASS_SELLER + " TEXT) ;";


    public static final String ROW_SELLER = "INSERT INTO " + TABLE_USERS_SELLER + " ("
            + USER_SELLER + ", " + PASS_SELLER + ") Values ('seller', 'seller')";

//    db.execSQL("CREATE TABLE " + QUEST_TABLE_NAME + "(id INTEGER primary key autoincrement NOT NULL, name TEXT, description TEXT, expValue INTEGER, category INTEGER NOT NULL REFERENCES categories (id), date TEXT");

    //  public static final String ROW_SELLER ="CREATE TABLE "+ TABLE_USERS_SELLER + "(USER_SELLER TEXT primary key NOT NULL,PASS_SELLER TEXT,)"

    public static final String BUS_PLAQUE = "bus_plaque";
    public static final String BUS_NUMBER_OF_SEATS = "bus_number_of_seats";
    public static final String BUS_MODEL = "bus_model";
    public static final String BUS_PRODUCTION_YEAR = "bus_production_year";


    public static final String SQL_BUS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_BUS + "(" +
            BUS_PLAQUE + " TEXT PRIMARY KEY , " +
            BUS_NUMBER_OF_SEATS + " INTEGER, " +
            BUS_MODEL + " TEXT, " +
            BUS_PRODUCTION_YEAR + " TEXT) ";
    Context context;

    public DatabaseOpenHelper(Context context) {
        super(context, dataname, null, dataversion);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase mydb) {
        try {
           /// mydb = this.getReadableDatabase();
        } catch (SQLException e) {
            Log.e(TAG, "oncreate: " + e.toString());
        }
        try {
            mydb.execSQL(SQL_USERS_ADMIN_TABLE);
            mydb.execSQL(SQL_USERS_SELLER_TABLE);
            mydb.execSQL(SQL_DRIVER_TABLE);
            mydb.execSQL(ROW_ADMIN);
            mydb.execSQL(ROW_SELLER);

        } catch (SQLException e) {
            Log.e(TAG, "oncreate: " + e.toString());
        }


        try {
            mydb.execSQL(SQL_BUS_TABLE);
        } catch (SQLException e) {
            Log.e(TAG, "oncreate: " + e.toString());

        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase mydb, int oldVersion, int newVersion) {

    }


    public boolean addbus() {

        ContentValues values = new ContentValues();
        return false;
    }

    SQLiteDatabase mydb;


    public void insertToBus(bus buss) {

        ContentValues values = new ContentValues();
        SQLiteDatabase mydb ;
        mydb = this.getWritableDatabase();
        values.put(BUS_PLAQUE, buss.getPLAQUE());
        values.put(BUS_NUMBER_OF_SEATS, buss.getNUMBER_OF_SEATS());
        values.put(BUS_MODEL, buss.getMODEL());
        // values.put("BUS_PRODUCTION_YEAR", buss.getPRODUCTION_YEAR());
        this.mydb = mydb;


   mydb.insert(TABLE_BUS, null, values);
        mydb.close();
    }

    public void inserttodriver(driver driverr) {
        ContentValues values = new ContentValues();
        SQLiteDatabase mydb = openOrCreateDatabase(dataname, null);
        mydb = this.getWritableDatabase();

        values.put("DRIVER_CODE_MELLI", driverr.getCode_melli());
        values.put("DRIVER_NAME", driverr.getFirstname());
        values.put("DRIVER_LAST_NAME", driverr.getLastname());
        values.put("DRIVER_CERTIFLCATES", driverr.getNoe_govayname());
        values.put("DRIVER_NUMBER_PHONE", driverr.getShomare_tamas());
        values.put("DRIVER_ADDRESS", driverr.getAddres());

        mydb.insert(TABLE_DRIVER, null, values);
        mydb.close();


    }
}

