package com.light.donow;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class StartPage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
    }


    public void onstore(View view){
        startActivity(new Intent(this, Store.class));
    }
    public void onsearch(View view){
        startActivity(new Intent(this,Search.class));
    }
}
