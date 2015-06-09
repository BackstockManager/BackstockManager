package com.example.chris.backstockmanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Users extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        reset((EditText) findViewById(R.id.editUserName));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_users, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //todo remove this
        //int id = item.getItemId();

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

    public void addModifyUser(View view)
    {
        Intent intent = new Intent(this,AddUsers.class);
        startActivity(intent);
    }

    public void deleteUser(View view)
    {
        EditText nameEdit = (EditText)findViewById(R.id.editUserName);
        String name = nameEdit.getText().toString();
        Context context = getApplicationContext();

        dbwrapper database = new dbwrapper(this);
        if (database.deleteUser(name))
        {
            Toast.makeText(context,"Successfully Removed User " + name, Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context,"Unable to Remove User " + name, Toast.LENGTH_SHORT).show();
        }

        reset(nameEdit);
    }

    public void reset(EditText nameEdit)
    {
        nameEdit.setText("");
        nameEdit.setHint("Username");
    }
}
