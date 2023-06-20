package com.example.moviesite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnRegisterMovie = findViewById(R.id.btnRegisterMovie);
        btnRegisterMovie.setOnClickListener(this); // calling onClick() method
        Button btnDisplayMovies = findViewById(R.id.btnDisplayMovies);
        btnDisplayMovies.setOnClickListener(this);
        Button btnFavourites = findViewById(R.id.btnFavourites);
        btnFavourites.setOnClickListener(this);
        Button btnEditMovies = findViewById(R.id.btnEditMovies);
        btnEditMovies.setOnClickListener(this);
        Button btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(this);
        Button btnRatings = findViewById(R.id.btnRatings);
        btnRatings.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegisterMovie:
                Intent i = new Intent(MainActivity.this, registerMovies.class);
                startActivity(i);
                break;
            case R.id.btnDisplayMovies:
                Intent j = new Intent(MainActivity.this, displayMovies.class);
                startActivity(j);
                break;
            case R.id.btnFavourites:
                Intent k = new Intent(MainActivity.this, favourites.class);
                startActivity(k);
                break;
            case R.id.btnEditMovies:
                Intent l = new Intent(MainActivity.this, editMovies.class);
                startActivity(l);
                break;
            case R.id.btnSearch:
                Intent m = new Intent(MainActivity.this, search.class);
                startActivity(m);
                break;
            case R.id.btnRatings:
                Intent n = new Intent(MainActivity.this, ratings.class);
                startActivity(n);
                break;
            default:
                break;
        }
    }

}