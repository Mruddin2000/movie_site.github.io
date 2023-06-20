package com.example.moviesite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class registerMovies extends AppCompatActivity {
    //declaring varibles
    DatabaseHelper myDB;

    private Button btnRegisterMovie;
    private EditText inputAreaTitle, inputAreaYear, inputAreaDirector, inputAreaListOfAct, inputAreaRatings, inputAreaReview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registermovie);

//assigning the variables with their id
        inputAreaTitle = findViewById(R.id.inputAreaTitleUpdate);
        inputAreaYear = findViewById(R.id.inputAreaYearUpdate);
        inputAreaDirector = findViewById(R.id.inputAreaDirectorUpdate);
        inputAreaListOfAct = findViewById(R.id.inputAreaListOfActUpdate);
        inputAreaRatings = findViewById(R.id.inputAreaRatings);
        inputAreaReview = findViewById(R.id.inputAreaReview);
        btnRegisterMovie = findViewById(R.id.btnRegisterMovie);
        myDB = new DatabaseHelper(this); // assigning myDB to new databaseHelper so that i can use the same database to view data

        btnRegisterMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = inputAreaTitle.getText().toString();
                int year = Integer.parseInt(inputAreaYear.getText().toString());
                String director = inputAreaDirector.getText().toString();
                String lists = inputAreaListOfAct.getText().toString();
                int ratings = Integer.parseInt(inputAreaRatings.getText().toString());
                String review = inputAreaReview.getText().toString();
                //assigning new varibles to get text as String
                if (year < 1895) { //statement to restrict user from entering unrealistic data
                    Toast.makeText(registerMovies.this, "Enter a greater year than 1895", Toast.LENGTH_SHORT).show();
                } else if
                (ratings < 0 || ratings > 10) {//statement to restrict user from entering unrealistic data
                    Toast.makeText(registerMovies.this, "Ratings must be within 1-10", Toast.LENGTH_SHORT).show();
                } else if (title.length() != 0 &&
                        director.length() != 0 &&
                        lists.length() != 0 &&
                        review.length() != 0) {
                    AddData(title, year, director, lists, ratings, review);
                    inputAreaTitle.setText("");
                    inputAreaYear.setText("");
                    inputAreaDirector.setText("");
                    inputAreaListOfAct.setText("");
                    inputAreaRatings.setText("");
                    inputAreaReview.setText("");
                } else {
                    Toast.makeText(registerMovies.this, "You must put something in the text field!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void AddData(String title, int year, String director, String lists, int ratings, String reviews) {

        boolean insertData = myDB.addData(title, year, director, lists, ratings, reviews);

        if (insertData == true) {
            Toast.makeText(this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
        }
    }
}
