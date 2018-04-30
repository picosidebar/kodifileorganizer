package com.jadebuddha.nfo;

public class Audio {
    private String channels;

    private String codec;

    private String language;

    public String getChannels ()
    {
        return channels;
    }

    public void setChannels (String channels)
    {
        this.channels = channels;
    }

    public String getCodec ()
    {
        return codec;
    }

    public void setCodec (String codec)
    {
        this.codec = codec;
    }

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
        return "ClassPojo [channels = "+channels+", codec = "+codec+", language = "+language+"]";
    }
}
