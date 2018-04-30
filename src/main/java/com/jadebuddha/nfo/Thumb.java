package com.jadebuddha.nfo;

public class Thumb {
    private String content;

    private String preview;

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    public String getPreview ()
    {
        return preview;
    }

    public void setPreview (String preview)
    {
        this.preview = preview;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [content = "+content+", preview = "+preview+"]";
    }
}
