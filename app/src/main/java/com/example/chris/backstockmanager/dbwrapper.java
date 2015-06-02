package com.example.chris.backstockmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Chris on 5/30/2015.
 */
public class dbwrapper
{

    public final static String USERS_TABLE     = "users";    // name of table
    public final static String TOTES_TABLE     = "totes";    // name of table

    public final static String USERS_NAME       = "name";        // name of user
    public final static String USERS_PASSWORD   = "password";    // password of user
    public final static String USERS_SECURITY   = "security";    // security of user
    public final static String USERS_THEME      = "theme";       // theme of user
    public final static String TOTE_LABEL       = "label";       // label of tote
    public final static String TOTE_COLOR       = "color";       // color of tote
    public final static String TOTE_SIZE        = "size";        // size of tote
    public final static String TOTE_DATE        = "d-filled";    // date of tote
    public final static String TOTE_SEX         = "sex";         // date of tote
    public final static String TOTE_CATEGORY    = "category";    // date of tote
    public final static String TOTE_SUBCATEGORY = "subcategory"; // date of tote
    public final static String TOTE_SEASON      = "season";      // date of tote
    public final static String TOTE_HUNG        = "hung";        // date of tote
    public final static String TOTE_SENSOR      = "sensor";      // date of tote
    public final static String TOTE_OFFSITE     = "offsite";     // date of tote
    public final static String TOTE_LOCATION    = "location";    // date of tote
    public final static String TOTE_USER        = "user";    // date of tote


    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    public dbwrapper(Context context)
    {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public long createUsersRecord(String name, String password, String security, String theme)
    {
        ContentValues values = new ContentValues();
        values.put(USERS_NAME, name);
        values.put(USERS_PASSWORD, password);
        values.put(USERS_SECURITY, security);
        values.put(USERS_THEME, theme);
        return database.insert(USERS_TABLE, null, values);
    }

    public long createTotesRecord(String label, String color, String size, String date,
                                  String sex, String category, String subcategory,
                                  String season, String hung, String sensor, String offsite,
                                  String location, String user)
    {
        ContentValues values = new ContentValues();
        values.put(TOTE_LABEL, label);
        values.put(TOTE_COLOR, color);
        values.put(TOTE_SIZE, size);
        values.put(TOTE_DATE, date);
        values.put(TOTE_SEX, sex);
        values.put(TOTE_CATEGORY, category);
        values.put(TOTE_SUBCATEGORY, subcategory);
        values.put(TOTE_SEASON, season);
        values.put(TOTE_HUNG, hung);
        values.put(TOTE_SENSOR, sensor);
        values.put(TOTE_OFFSITE, offsite);
        values.put(TOTE_LOCATION, location);
        values.put(TOTE_USER, user);
        return database.insert(TOTES_TABLE, null, values);
    }

    /*public Cursor selectRecords() {
        String[] cols = new String[] {EMP_ID, EMP_NAME};
        Cursor mCursor = database.query(true, EMP_TABLE,cols,null
                , null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor; // iterate to get each value.
    }*/
}
