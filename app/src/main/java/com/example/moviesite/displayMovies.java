package com.example.moviesite;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class displayMovies extends AppCompatActivity {

    DatabaseHelper myDB; //declring databaseHelper (class) as myDB
    ArrayList<com.example.moviesite.user.User> userList; // Declaring an arrayList which corresponds to my class called user
    ListView listView;
    CheckBox addToFav;
    // declaring listView and checkBox
    int checked = 0;


    com.example.moviesite.user.User user;//importing class user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaymovies);
        myDB = new DatabaseHelper(this); // assigning myDB to new databaseHelper so that i can use the same database to view data
        addToFav = (CheckBox) findViewById(R.id.addToFav);
        userList = new ArrayList<>();//assigning userList as new ArrayList so that i can use it to get the data
//getting all the data from the database using cursor
        Cursor data = myDB.getListContents(); //using Cursor function to get information from the database, this item im getting the list of records
        int numRows = data.getCount();
        if (numRows == 0) {
            //simple if statement to see if the database is empty or not
            Toast.makeText(displayMovies.this, "The Database is empty  :(.", Toast.LENGTH_LONG).show();
        } else {
            int i = 0;
            while (data.moveToNext()) {
                //if not, then it will use my user class to get Data and store it in to userList
                user = new user.User(data.getString(0), data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5), data.getString(6), data.getString(7));
                userList.add(i, user);
                System.out.println(data.getString(1) + " " + data.getString(2) + " " + data.getString(3));
                System.out.println(userList.get(i).getTitle());
                //here its just printing out what has been collected
                i++;
            }
            listAdapter adapter = new listAdapter(this, R.layout.listadapater, userList);
            //setting adapter for the listappter which corresponds to the userList
            listView = findViewById(R.id.listView);
            //finding the listview and assigning to a variable
            listView.setAdapter(adapter);

        }
        /*
            addToFav.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        checked = 1;
                        // myDB.updateTable();
                        Toast.makeText(getApplicationContext(), "Saved '" + checked + "' in DB", Toast.LENGTH_SHORT).show();
                    } else {
                        checked = 0;
                    }
                }
            });
*/
        }
    }
