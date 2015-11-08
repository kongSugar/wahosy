package de.kongsugar.wahosy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Class that shall offer (static) save and load methods for the database-properties and more
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

	// TODO Strategy to save and load properties defined BY CLIENT!
	// Preferences vs Properties


}
