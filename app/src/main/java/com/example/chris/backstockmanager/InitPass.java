package com.example.chris.backstockmanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.example.chris.backstockmanager.dbwrapper;


public class InitPass extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_pass);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_init_pass, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addUser(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        dbwrapper addToDb;
        EditText editUserName;
        EditText editPassword;
        EditText editSecurity;
        String userName;
        String Password;
        String Security;

        editUserName = (EditText)findViewById(R.id.userName);
        editPassword = (EditText)findViewById(R.id.password);
        editSecurity = (EditText)findViewById(R.id.init_pass_button_security);
        userName = editUserName.getText().toString();
        Password = editPassword.getText().toString();
        Security = editSecurity.getText().toString();
        addToDb = new dbwrapper(this);
        addToDb.createUsersRecord(userName, Password, Security, "Default");

        startActivity(intent);
    }
}
