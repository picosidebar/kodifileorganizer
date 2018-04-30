package com.jadebuddha.nfo;

public class Fanart {
    private Thumb[] thumb;

    public Thumb[] getThumb ()
    {
        return thumb;
    }

    public void setThumb (Thumb[] thumb)
    {
        this.thumb = thumb;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [thumb = "+thumb+"]";
    }
}
