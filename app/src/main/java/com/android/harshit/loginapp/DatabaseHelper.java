package com.android.harshit.loginapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



/**
 * Created by User on 23-09-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="credentials.db";
    public static final String TABLE_NAME="credentials_table";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="PASSWORD";

    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

       String S="create table "+ TABLE_NAME + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " TEXT ," + COL_3 + "  INTEGER" +")";
       db.execSQL(S);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXIST"+ TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name,String password){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,password);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if (result== -1)
             return false;
        else
            return true;
    }
}
