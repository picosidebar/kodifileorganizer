package com.jadebuddha.nfo;

import javax.xml.bind.annotation.XmlElement;

public class Uniqueid {
    private String content;

    private String uniqueidDefault;

    private String type;

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    @XmlElement(name = "default", required = true)
    public String getDefault ()
    {
        return uniqueidDefault;
    }

    public void setDefault (String uniqueidDefault)
    {
        this.uniqueidDefault = uniqueidDefault;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [content = "+content+", default = "+uniqueidDefault+", type = "+type+"]";
    }
}
