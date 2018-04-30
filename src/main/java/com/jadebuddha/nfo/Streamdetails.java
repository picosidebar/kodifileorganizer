package com.jadebuddha.nfo;

public class Streamdetails {
    private Audio[] audio;

    private Subtitle[] subtitle;

    private Video video;

    public Audio[] getAudio ()
    {
        return audio;
    }

    public void setAudio (Audio[] audio)
    {
        this.audio = audio;
    }

    public Subtitle[] getSubtitle ()
    {
        return subtitle;
    }

    public void setSubtitle (Subtitle[] subtitle)
    {
        this.subtitle = subtitle;
    }

    public Video getVideo ()
    {
        return video;
    }

    public void setVideo (Video video)
    {
        this.video = video;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [audio = "+audio+", subtitle = "+subtitle+", video = "+video+"]";
    }
}
