package com.jadebuddha.nfo;

public class Subtitle {
    private String language;

    public String getLanguage ()
    {
        return language;
    }

    public void setLanguage (String language)
    {
        this.language = language;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [language = "+language+"]";
    }
}
