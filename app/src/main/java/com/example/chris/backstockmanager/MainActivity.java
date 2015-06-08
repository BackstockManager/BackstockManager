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
import java.io.File;


public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        checkAdmin();
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
            return addToDb.selectFlagRecords() == 1;
        }
        return false;
    }

    public void checkAdmin()
    {
        dbwrapper addToDb = new dbwrapper(this);
        addToDb.checkForAdmin();
    }

    public void logon(View view)
    {
        dbwrapper DBcheckLogon = new dbwrapper(this);
        EditText userNameEdit = (EditText)findViewById(R.id.usernameText);
        String userName = userNameEdit.getText().toString();
        EditText passwordEdit = (EditText)findViewById(R.id.passwordText);
        String password = passwordEdit.getText().toString();

        //check if db exists, then check password
        Context context = getApplicationContext();
        File dbFile = context.getDatabasePath("backstockdb");
        if (dbFile.exists())
        {
            if (DBcheckLogon.checkPassword(userName, password))
            {
                Intent intent = new Intent(this, HomeScreenActivity.class);
                startActivity(intent);
            }
            //pw or name is wrong
            else
            {
                Toast.makeText(context,"Invalid Credentials",Toast.LENGTH_LONG).show();
            }
        }
        //db not created, need init user
        else
        {
            Toast.makeText(context,"No Users",Toast.LENGTH_LONG).show();
        }
    }
}
