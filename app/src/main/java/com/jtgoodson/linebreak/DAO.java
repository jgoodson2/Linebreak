package com.jtgoodson.linebreak;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;

public class DAO extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "spots.db";
    public static final String TABLE_ENTRY = "spot";
    public static final String COLUMN_0_ID = "id";
    public static final String COLUMN_1_DATE_CREATED = "dateCreated";
    public static final String COLUMN_2_LOCATION_DESC = "location_desc";
    public static final String COLUMN_3_EXTRA_DETAILS = "extra_details";
    public static final String COLUMN_4_LATITUDE = "latitude";
    public static final String COLUMN_5_LONGITUDE = "longitude";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    public DAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLE_ENTRY + "(" +
                COLUMN_0_ID + " INTEGER PRIMARY KEY AUTOINCREMENT" +
                ", " + COLUMN_1_DATE_CREATED + " TEXT" +
                ", " + COLUMN_2_LOCATION_DESC + " TEXT" +
                ", " + COLUMN_3_EXTRA_DETAILS + " TEXT" +
                ", " + COLUMN_4_LATITUDE + " TEXT" +
                ", " + COLUMN_5_LONGITUDE + " TEXT" +
                ");";
        sqLiteDatabase.execSQL(sql);
        System.out.println("table created");
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_ENTRY);
        System.out.println("table dropped");
        onCreate(sqLiteDatabase);
    }

    //insert new record
    public boolean addNewRecord(Spot spot) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_1_DATE_CREATED, sdf.format(spot.get_dateCreated()));
        values.put(COLUMN_2_LOCATION_DESC, spot.get_location_desc());
        values.put(COLUMN_3_EXTRA_DETAILS, spot.get_extra_details());
        values.put(COLUMN_4_LATITUDE, spot.get_latitude());
        values.put(COLUMN_5_LONGITUDE, spot.get_longitude());
        SQLiteDatabase db = getWritableDatabase();
        long result = db.insert(TABLE_ENTRY, null, values);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

}