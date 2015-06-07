package com.example.chris.backstockmanager;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.example.chris.backstockmanager.dbwrapper;

import java.io.File;


public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        if (isFlagRecord())
        {
            menu.findItem(R.id.action_settings).setVisible(false);
        }
        else
        {
            menu.findItem(R.id.action_settings).setVisible(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    public void submitLogin(View view)
    {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        startActivity(intent);
    }

    public void initPass(MenuItem menuItem)
    {
        Intent intent = new Intent(this, InitPass.class);
        startActivity(intent);
    }

    public boolean isFlagRecord()
    {
        Context context = getApplicationContext();
        File dbFile = context.getDatabasePath("backstockdb");
        if (dbFile.exists())
        {
            dbwrapper addToDb = new dbwrapper(this);
            return addToDb.selectFlagRecords();
        }
        return false;
    }
}
