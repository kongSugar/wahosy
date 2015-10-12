package de.kongsugar.wahosy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Created by nikog on 12.10.2015.
 */
public final class Config {
    public static final String PROPERTY_FILE ="config.properties";

    private static Properties get(){
        Properties prop = new Properties();
        try {
            prop.load(Files.newInputStream(Paths.get(PROPERTY_FILE)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }



}
