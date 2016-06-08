package com.light.donow;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Search extends ActionBarActivity {
    DatabaseSet set = new DatabaseSet(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }


    public void onSearch(View view){

        EditText txtname = (EditText) findViewById(R.id.textname);
        String txt = txtname.getText().toString();
        String showpass= set.searchforpass(txt);
        TextView pswd= (TextView)  findViewById(R.id.passwordtext);
        pswd.setText(showpass);
    }
}
