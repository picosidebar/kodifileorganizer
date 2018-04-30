package com.jadebuddha.nfo;

public class Video {
    private String stereomode;

    private String aspect;

    private String height;

    private String durationinseconds;

    private String width;

    private String codec;

    public String getStereomode ()
    {
        return stereomode;
    }

    public void setStereomode (String stereomode)
    {
        this.stereomode = stereomode;
    }

    public String getAspect ()
    {
        return aspect;
    }

    public void setAspect (String aspect)
    {
        this.aspect = aspect;
    }

    public String getHeight ()
    {
        return height;
    }

    public void setHeight (String height)
    {
        this.height = height;
    }

    public String getDurationinseconds ()
    {
        return durationinseconds;
    }

    public void setDurationinseconds (String durationinseconds)
    {
        this.durationinseconds = durationinseconds;
    }

    public String getWidth ()
    {
        return width;
    }

    public void setWidth (String width)
    {
        this.width = width;
    }

    public String getCodec ()
    {
        return codec;
    }

    public void setCodec (String codec)
    {
        this.codec = codec;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [stereomode = "+stereomode+", aspect = "+aspect+", height = "+height+", durationinseconds = "+durationinseconds+", width = "+width+", codec = "+codec+"]";
    }
}
