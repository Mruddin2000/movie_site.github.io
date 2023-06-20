package com.example.moviesite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class updateMovies extends AppCompatActivity {
    private static final String TAG = "Update Movies";

    DatabaseHelper myDB;
    private Button btnUpdate;
    private EditText inputAreaIdUpdate, inputAreaTitleUpdate, inputAreaYearUpdate, inputAreaDirectorUpdate,
            inputAreaListOfActUpdate, inputAreaRatingsUpdate, inputAreaReviewUpdate;
    //declaring varibles


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatemovies);

        inputAreaIdUpdate = findViewById(R.id.inputAreaIDUpdate);
        inputAreaTitleUpdate = findViewById(R.id.inputAreaTitleUpdate);
        inputAreaYearUpdate = findViewById(R.id.inputAreaYearUpdate);
        inputAreaDirectorUpdate = findViewById(R.id.inputAreaDirectorUpdate);
        inputAreaListOfActUpdate = findViewById(R.id.inputAreaListOfActUpdate);
        inputAreaRatingsUpdate = findViewById(R.id.inputAreaRatings);
        inputAreaReviewUpdate = findViewById(R.id.inputAreaReview);
        btnUpdate = findViewById(R.id.btnUpdate);

        myDB = new DatabaseHelper(this);// assigning myDB to new databaseHelper so that i can use the same database to view data


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = inputAreaIdUpdate.getText().toString().length();
                if (temp > 0) {
                    boolean update = myDB.updateData(inputAreaIdUpdate.getText().toString(),
                            inputAreaTitleUpdate.getText().toString(),
                            Integer.parseInt(inputAreaYearUpdate.getText().toString()),
                            inputAreaDirectorUpdate.getText().toString(),
                            inputAreaListOfActUpdate.getText().toString(),
                            Integer.parseInt(inputAreaRatingsUpdate.getText().toString()),
                            inputAreaReviewUpdate.getText().toString());
                    //assigning new varibles to get text as String
                    if (update == true){
                        int year = Integer.parseInt(inputAreaYearUpdate.getText().toString());
                        int ratings = Integer.parseInt(inputAreaRatingsUpdate.getText().toString());
                        if (year < 1895) { //statement to restrict user from entering unrealistic data
                            Toast.makeText(updateMovies.this, "Enter a greater year than 1895", Toast.LENGTH_SHORT).show();
                        } else if
                        (ratings < 0 || ratings > 10) {//statement to restrict user from entering unrealistic data
                            Toast.makeText(updateMovies.this, "Ratings must be within 1-10", Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(updateMovies.this, "Successfully Updated Data!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(updateMovies.this, "Something Went Wrong :(.", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(updateMovies.this, "You Must Enter An ID to Update :(.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}