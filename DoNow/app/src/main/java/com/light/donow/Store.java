package com.light.donow;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Store extends ActionBarActivity {

    DatabaseSet set = new DatabaseSet(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
    }

    public void onSave(View view){

        EditText plat_name = (EditText) findViewById(R.id.pName);
        EditText user_name = (EditText) findViewById(R.id.name);
        EditText pass_word = (EditText) findViewById(R.id.pass);


        String username = user_name.getText().toString();
        String platform = plat_name.getText().toString();
        String password = pass_word.getText().toString();


        TextView text = (TextView) findViewById(R.id.test);
        text.setText(username);

        User u =new User(platform,username,password);
        set.insert(u);
    }

}
