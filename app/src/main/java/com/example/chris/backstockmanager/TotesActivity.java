package com.example.chris.backstockmanager;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


public class TotesActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totes);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_totes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // Handle presses on the action bar items
        switch (item.getItemId())
        {
            case R.id.action_Totes:
                openTotes();
                return true;
            case R.id.action_settings:
                openSettings();
                return true;
            case R.id.action_users:
                openUsers();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Action Bar Navigation
    public void openTotes()
    {
        Intent intent = new Intent(this, TotesActivity.class);
        startActivity(intent);
    }

    public void openSettings()
    {
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }

    public void openUsers()
    {
        Intent intent = new Intent(this, Users.class);
        startActivity(intent);
    }
}
