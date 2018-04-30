package com.jadebuddha.nfo;

public class Art {
    private String poster;

    private String fanart;

    public String getPoster ()
    {
        return poster;
    }

    public void setPoster (String poster)
    {
        this.poster = poster;
    }

    public String getFanart ()
    {
        return fanart;
    }

    public void setFanart (String fanart)
    {
        this.fanart = fanart;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [poster = "+poster+", fanart = "+fanart+"]";
    }
}
