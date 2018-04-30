package com.jadebuddha.nfo;

import javax.xml.bind.annotation.XmlElement;

public class Rating {
    private String max;

    private String ratingDefault;

    private String name;

    private String value;

    private String votes;

    public String getMax ()
    {
        return max;
    }

    public void setMax (String max)
    {
        this.max = max;
    }

    @XmlElement(name = "default", required = false)
    public String getDefault ()
    {
        return ratingDefault;
    }

    public void setDefault (String ratingDefault)
    {
        this.ratingDefault = ratingDefault;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    public String getVotes ()
    {
        return votes;
    }

    public void setVotes (String votes)
    {
        this.votes = votes;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [max = "+max+", default = "+ratingDefault+", name = "+name+", value = "+value+", votes = "+votes+"]";
    }
}
