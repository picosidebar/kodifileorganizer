package com.jadebuddha.nfo;

public class Ratings {
    private Rating rating;

    public Rating getRating ()
    {
        return rating;
    }

    public void setRating (Rating rating)
    {
        this.rating = rating;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [rating = "+rating+"]";
    }
}
