package com.example.chris.backstockmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Chris on 5/28/2015.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "backstockdb";

    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE_USERS =
           "create table if not exists users"   +
           "( name text primary key not null,"  +
           "password text not null,"            +
           "security int default 1,"            +
           "theme text);";

    private static final String DATABASE_CREATE_TOTES =
           "create table if not exists totes" +
           "( label text not null,"           +
           "color text not null,"             +
           "size text not null,"              +
           "dfilled text,"                   +
           "sex text,"                        +
           "category text,"                   +
           "subcategory text,"                +
           "season text,"                     +
           "hung integer,"                    +
           "sensor integer,"                  +
           "offsite integer,"                 +
           "location text,"                   +
           "user text,"                       +
           "primary key (label,color,size));";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Method is called during creation of the database
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE_USERS);
        database.execSQL(DATABASE_CREATE_TOTES);
    }

    // Method is called during an upgrade of the database,
    @Override
    public void onUpgrade(SQLiteDatabase database,int oldVersion,int newVersion){
        Log.w(DatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        //database.execSQL("DROP TABLE IF EXISTS MyEmployees");
        onCreate(database);
    }
}
