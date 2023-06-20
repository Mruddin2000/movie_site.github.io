package com.example.moviesite;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class listAdapter extends ArrayAdapter<user.User> {

    private final LayoutInflater mInflater;
    private final ArrayList<user.User> users;
    private final int mViewResourceId;

    //Declaring variables

    public listAdapter(Context context, int textViewResourceId, ArrayList<user.User> users) {
        super(context, textViewResourceId, users);
        this.users = users;
        //  mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater = LayoutInflater.from(context);
        mViewResourceId = textViewResourceId;

        // in built fucntion to set Context, resources and vales
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);
        //using in built convertView to set my mInflater to inflate its resources
        user.User user = users.get(position);



        if (user != null) {
            //setting all the textviews to convertView to be able to display it in a column format
            TextView ID = convertView.findViewById(R.id.textID);
            TextView title = convertView.findViewById(R.id.textTitle);
            TextView year = convertView.findViewById(R.id.textYear);
            TextView director = convertView.findViewById(R.id.textDirector);
            TextView lists = convertView.findViewById(R.id.textlists);
            TextView ratings = convertView.findViewById(R.id.textRatings);
            TextView review = convertView.findViewById(R.id.textReview);

            if (ID != null) {
                ID.setText(user.getID());
            }
            if (title != null) {
                title.setText(user.getTitle());
            }
            if (year != null) {
                year.setText(user.getYear());
            }
            if (director != null) {
                director.setText(user.getDirector());
            }
            if (lists != null) {

                lists.setText(user.getList_of_Actors_Actresses());
            }
            if (ratings != null) {
                ratings.setText(user.getRatings());
            }
            if (review != null) {
                review.setText(user.getReview());
            }
//setitng information from user class
        }

        return convertView;
    }
}