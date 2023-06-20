package com.example.moviesite;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import java.util.ArrayList;

public class search extends AppCompatActivity {

    DatabaseHelper myDB;
    Cursor cursor;

    //EditText edt_search;
    // ArrayAdapter adapter;
    ListView userlist;
    ArrayList<com.example.moviesite.user.User> listItem;
    com.example.moviesite.user.User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        myDB = new DatabaseHelper(this);
        myDB = new DatabaseHelper(this);
        listItem = new ArrayList<>();
        userlist = findViewById(R.id.listView);

        Cursor data = myDB.getListContents();
        int numRows = data.getCount();
        if (numRows == 0) {
            Toast.makeText(search.this, "The Database is empty  :(.", Toast.LENGTH_LONG).show();
        } else {
            int i = 0;
            while (data.moveToNext()) {
                user = new user.User(data.getString(0), data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5), data.getString(6), data.getString(7));
                listItem.add(i, user);
                System.out.println(data.getString(1) + " " + data.getString(2) + " " + data.getString(3));
                System.out.println(listItem.get(i).getTitle());
                i++;
            }
            listAdapter adapter = new listAdapter(this, R.layout.editlistadapater, listItem);
            userlist = findViewById(R.id.listView);
            userlist.setAdapter(adapter);


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuItem searchitem = menu.findItem(R.id.Item_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchitem);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<String> listItem = new ArrayList<>();

                for (String user : listItem) {
                    if (user.toLowerCase().contains(s.toLowerCase())) {
                        myDB.search(s).equals(listItem.add(user));
                    }
                }


                ArrayAdapter<String> adapter = new ArrayAdapter<>(search.this,R.layout.editlistadapater,listItem);

              //  ArrayAdapter<String> adapter = new ArrayAdapter<>(search.this,
                     //   android.R.layout.simple_list_item_1, listItem);
                userlist.setAdapter(adapter);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}