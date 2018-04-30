package com.jadebuddha.nfo;

public class NFOFile {
        private Movie movie;

        public Movie getMovie ()
        {
            return movie;
        }

        public void setMovie (Movie movie)
        {
            this.movie = movie;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [movie = "+movie+"]";
        }
}
