package de.kongsugar.wahosy.model.dao;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

/**
 * Created by nikog on 23.09.2015.
 */
public class Setup {
    /**
     * Sets parameters in data/jdbc.properties required for connection to the database
     */
    public static void HSQLDB() {
        try {
            Path p = Paths.get("data/jdbc.properties");
            Files.createDirectories(p.getParent());
            if (!Files.exists(p)) Files.createFile(p);

            Properties prop = new Properties();
            prop.setProperty("database.driver", "org.hsqldb.jdbc.JDBCDriver");
            prop.setProperty("database.url", "jdbc:hsqldb:file:src/test/resources/db/test;shutdown=true;");
            //prop.setProperty("database.url", "jdbc:hsqldb:mem:testDB;shutdown=true;");
            prop.setProperty("database.username", "SA");
            prop.setProperty("database.password", "");

            BufferedWriter bw = Files.newBufferedWriter(p, StandardCharsets.ISO_8859_1, StandardOpenOption.CREATE);
            prop.store(bw, null);

            //ConnectionFactory.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
