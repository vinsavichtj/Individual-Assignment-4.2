package com.example.tj.individualassignment42;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FIRST = "first";
    private static final String COLUMN_SECOND = "second";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table contacts(id integer primary key not null  , " +
            "first text not null , second text not null);";

    public DatabaseHelper(Context context)
    {
        super(context , DATABASE_NAME , null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertContact(Contact c)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query , null);
        int count = cursor.getCount();

        values.put(COLUMN_ID , count);
        values.put(COLUMN_FIRST , c.getFirst());
        values.put(COLUMN_SECOND , c.getSecond());

        db.insert(TABLE_NAME , null , values);
        db.close();
    }

    public String searchWord(String first)
    {
        db = this.getReadableDatabase();
        String query = "select first, second from " +TABLE_NAME;
        Cursor cursor = db.rawQuery(query , null);
        String a, b;
        b = "Word not found";
        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);

                if(a.equals(first))
                {
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }

        return b;


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " +TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
