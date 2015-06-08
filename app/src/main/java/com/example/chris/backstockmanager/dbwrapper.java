package com.example.chris.backstockmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

/**
 * Created by Chris on 5/30/2015.
 */
public class dbwrapper {

    public final static String USERS_TABLE = "users";    // name of table
    public final static String TOTES_TABLE = "totes";    // name of table
    public final static String FLAG_TABLE = "flag";     // name of table

    public final static String USERS_NAME = "name";        // name of user
    public final static String USERS_PASSWORD = "password";    // password of user
    public final static String USERS_SECURITY = "security";    // security of user
    public final static String USERS_THEME = "theme";       // theme of user
    public final static String TOTE_LABEL = "label";       // label of tote
    public final static String TOTE_COLOR = "color";       // color of tote
    public final static String TOTE_SIZE = "size";        // size of tote
    public final static String TOTE_DATE = "d-filled";    // date of tote
    public final static String TOTE_SEX = "sex";         // sex of tote
    public final static String TOTE_CATEGORY = "category";    // category of tote
    public final static String TOTE_SUBCATEGORY = "subcategory"; // sub of tote
    public final static String TOTE_SEASON = "season";      // season of tote
    public final static String TOTE_HUNG = "hung";        // hung of tote
    public final static String TOTE_SENSOR = "sensor";      // sensor of tote
    public final static String TOTE_OFFSITE = "offsite";     // offsite of tote
    public final static String TOTE_LOCATION = "location";    // location of tote
    public final static String TOTE_USER = "user";        // user of tote
    public final static String FLAG_FLAG = "flag";        // flag


    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    public dbwrapper(Context context) {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public long createUsersRecord(String name, String password, String security, String theme) {
        ContentValues values = new ContentValues();
        values.put(USERS_NAME, name);
        values.put(USERS_PASSWORD, password);
        values.put(USERS_SECURITY, security);
        values.put(USERS_THEME, theme);
        return database.insert(USERS_TABLE, null, values);
    }

    public long createFlagRecord(int flag) {
        ContentValues values = new ContentValues();
        values.put(FLAG_FLAG, flag);
        return database.insert(FLAG_TABLE, null, values);
    }

    public long createTotesRecord(String label, String color, String size, String date,
                                  String sex, String category, String subcategory,
                                  String season, String hung, String sensor, String offsite,
                                  String location, String user) {
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

    public int selectFlagRecords() {
        Cursor mCursor = database.rawQuery("select * from flag", null);
        if (mCursor.moveToFirst())
            return mCursor.getInt(0);
        else
            return 0;
    }

    public boolean checkForAdmin()
    {
        String selectStatement = "select * from users" +
                                 " where name='adminuser'";

        Cursor mCursor = database.rawQuery(selectStatement, null);
        if (mCursor != null)
        {
            return true;
        }
        else
        {
            mCursor.close(); createUsersRecord("adminuser", "backstockmanager", "5", null);
            return false;
        }
    }
}
