package com.jadebuddha.nfo;

public class Set {
    private String overview;

    private String name;

    public String getOverview ()
    {
        return overview;
    }

    public void setOverview (String overview)
    {
        this.overview = overview;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [overview = "+overview+", name = "+name+"]";
    }
}
