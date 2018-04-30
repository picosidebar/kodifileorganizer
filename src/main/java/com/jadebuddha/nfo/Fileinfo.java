package com.jadebuddha.nfo;

public class Fileinfo {
    private Streamdetails streamdetails;

    public Streamdetails getStreamdetails ()
    {
        return streamdetails;
    }

    public void setStreamdetails (Streamdetails streamdetails)
    {
        this.streamdetails = streamdetails;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [streamdetails = "+streamdetails+"]";
    }
}
