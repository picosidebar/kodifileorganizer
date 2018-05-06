package com.jadebuddha;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Config {
    public static Properties prop = new Properties();
    public static InputStream input = null;

    public static Properties getProps(){
	try

    {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        try(InputStream resourceStream = loader.getResourceAsStream("local.properties")) {
            prop.load(resourceStream);
        }




        // get the property value and print it out
        System.out.println(prop.getProperty("logFile"));

        return prop;

    } catch(
    IOException ex)

    {
        ex.printStackTrace();
    } finally

    {
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    return null;
}
}
