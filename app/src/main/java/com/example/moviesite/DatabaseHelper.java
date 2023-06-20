package com.example.moviesite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MovieSite.db";
    public static final String TABLE_NAME = "MovieSite";
    public static final String COL1 = "ID";
    public static final String COL2 = "TITLE";
    public static final String COL3 = "YEAR";
    public static final String COL4 = "DIRECTOR";
    public static final String COL5 = "LISTOFACTORSACTRESSES";
    public static final String COL6 = "RATINGS";
    public static final String COL7 = "REVIEW";
//  public static final String COL8 = "FAVOURITE";


//Assigning Strings as Static method so that it gets accessible in this code easily



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //creating the database
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "TITLE TEXT, YEAR TEXT, DIRECTOR TEXT, LISTOFACTORSACTRESSES TEXT, RATINGS TEXT, REVIEW TEXT)";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    //dropping the old database or new one
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
       onCreate(db);
    }

    public boolean addData(String title, int year, String director, String lists, int ratings, String reviews) {
        //adding data to the database
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, title);
        contentValues.put(COL3, year);
        contentValues.put(COL4, director);
        contentValues.put(COL5, lists);
        contentValues.put(COL6, ratings);
        contentValues.put(COL7, reviews);
     //   contentValues.put(COL8, "0");

        //i used ContentValues to assign my Static Stirngs to new ContentValues, so that i could add my contentValues to the database

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean addFavData(String title, String fav) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL2, title);
        contentValues.put("COL8", fav);
        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        return result != -1;

    }


    public Cursor getFavContents() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + "COL8" + " ='1'";
        return db.rawQuery(sql, null, null);
    }

    //query for 1 week repeats
    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM MovieSite ORDER BY TITLE ASC",null);
        return data;
    }

    public boolean updateData(String id, String title, int year, String director, String lists, int ratings, String reviews) {
        //updating data to the database

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, id);
        contentValues.put(COL2, title);
        contentValues.put(COL3, year);
        contentValues.put(COL4, director);
        contentValues.put(COL5, lists);
        contentValues.put(COL6, ratings);
        contentValues.put(COL7, reviews);

        //Similar to my add method, i used ContentValues to assign my Static Stirngs to new ContentValues, so that i could update my contentValues to the database

        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id + ""});

        //Im using ID to make sure the changes which are made appplies to the designated row.
        return true;
    }

    // delete function works and i used it to delete few records while i was testing
/*
    public void deleteName(int id, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + name + "'";

        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + name + " from database.");
        db.execSQL(query);
    }*/

    public Cursor search(String s) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + "WHERE " + COL2 + "LIKE '%" + s + "%";
        Cursor c = db.rawQuery(query, null);
        return c;
    }

}
