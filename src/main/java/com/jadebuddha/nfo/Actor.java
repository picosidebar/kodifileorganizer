package com.jadebuddha.nfo;

public class Actor {
    private String order;

    private String name;

    private String role;

    private String thumb;

    public String getOrder ()
    {
        return order;
    }

    public void setOrder (String order)
    {
        this.order = order;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getRole ()
    {
        return role;
    }

    public void setRole (String role)
    {
        this.role = role;
    }

    public String getThumb ()
    {
        return thumb;
    }

    public void setThumb (String thumb)
    {
        this.thumb = thumb;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [order = "+order+", name = "+name+", role = "+role+", thumb = "+thumb+"]";
    }
}
