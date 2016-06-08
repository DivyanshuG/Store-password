package com.light.donow;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    public DatabaseSet set = new DatabaseSet(this);
    String d_pass="contree123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view ){
        EditText pass = (EditText) findViewById(R.id.i_pass);

        String i_password = pass.getText().toString();
        int n = set.searchpass(i_password);
        if((n==0) || pass.equals(d_pass)){
            startActivity(new Intent(this ,MainActivity.class));

        }
        else
            Toast.makeText(getApplicationContext(),"Write correct Password",Toast.LENGTH_SHORT);
    }
}