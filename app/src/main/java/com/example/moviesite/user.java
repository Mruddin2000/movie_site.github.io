package com.example.moviesite;

public class user {

    public static class User {
        private String Title;
        private String Year;
        private String Director;
        private String List_of_Actors_Actresses;
        private String Ratings;
        private String Review;
        private String ID;
        private String Fav;

        public User(String id, String title, String year, String director, String lists, String ratings, String reviews, String fav) {
            Title = title;
            Year = year;
            Director = director;
            List_of_Actors_Actresses = lists;
            Ratings = ratings;
            Review = reviews;
            ID = id;
            Fav = fav;
        }

        public String getID() {
            return ID;
        }

        public void setID(String id) {
            ID = id;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getYear() {
            return Year;
        }

        public void setYear(String year) {
            Year = year;
        }

        public String getDirector() {
            return Director;
        }

        public void setDirector(String director) {
            Director = director;
        }

        public String getList_of_Actors_Actresses() {
            return List_of_Actors_Actresses;
        }

        public void setList_of_Actors_Actresses(String list_of_Actors_Actresses) {
            List_of_Actors_Actresses = list_of_Actors_Actresses;
        }

        public String getRatings() {
            return Ratings;
        }

        public void setRatings(String ratings) {
            Ratings = ratings;
        }

        public String getReview() {
            return Review;
        }

        public void setReview(String review) {
            Review = review;
        }

        public String getFav() {
            return Fav;
        }

        public void setFav(String fav) {
            Fav = fav;
        }


    }
}
