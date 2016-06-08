package com.light.donow;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.IOException;
import java.security.PublicKey;


public class DatabaseSet extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "data.db";
    public static final String TABLE_NAME = "entry";
    public static final String COLUMN_ID = "id" ;
    public static final String COLUMN_PLATFORM = "platform" ;
    public static final String COLUMN_NAME = "username";
    public static final String COLUMN_PASS = "password";
    private SQLiteDatabase db;

    public DatabaseSet(Context context)  {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    public void onCreate(SQLiteDatabase db) {
      db.execSQL("create table" + TABLE_NAME + "(id integer ,platform text , username text , password text)");
        this.db = db;
    }

    public void insert(User u){

        db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
        values.put(COLUMN_NAME , u.username);
        values.put(COLUMN_PLATFORM,u.platform);
        values.put(COLUMN_PASS, u.password);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public int searchpass(String passw){

        db = this.getReadableDatabase();
        String query = ("select password from " + TABLE_NAME);
        Cursor cursor =db.rawQuery(query,null);
        String x;
        if(cursor.moveToFirst()){
            do {
                x=cursor.getString(0);
                if(x.equals(passw))
                {
                 return 0;
                }
            }while (cursor.moveToNext());
        }
        return 1;
    }

    public String searchforpass(String txt) {
        db = this.getReadableDatabase();
        String query = "select username,platform,password from " + TABLE_NAME ;
        Cursor cursor = db.rawQuery(query, null);
        String x, y, z = "Not Found";
        if (cursor.moveToFirst()) {
            do {
                x = cursor.getString(0);
                y = cursor.getString(1);

                if (x.equals(txt)) {
                    z = cursor.getString(2);
                }
                if (y.equals(txt)) {
                    z = cursor.getString(2);
                }
            } while (cursor.moveToNext());

        }
        return z;
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    String query = "DROP TABLE IF EXISTS" +TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
