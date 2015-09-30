package de.kongsugar.wahosy.model.dao.batis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

public class ConnectionFactory {

    private static SqlSessionFactory sqlMapper;

    static {
        try {
            Properties props = new Properties();
            props.load(Files.newBufferedReader(Paths.get("data/jdbc.properties")));
            Reader reader = reader = Resources.getResourceAsReader("configuration.xml");
            sqlMapper = new SqlSessionFactoryBuilder().build(reader, props);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession() {
        return sqlMapper;
    }

    /**
     * Sets parameters in data/jdbc.properties required for connection to the database
     *
     * @param server
     * @param port
     * @param db
     * @param user
     * @param password
     */
    public static void setProperties(String server, String port, String db, String user, String password) {
        try {
            Path p = Paths.get("data/jdbc.properties");
            Files.createDirectories(p.getParent());
            if (!Files.exists(p)) Files.createFile(p);

            String url = String.format("jdbc:mysql://%s:%s/%s", server, port, db);

            Properties prop = new Properties();
            prop.setProperty("database.driver", "com.mysql.jdbc.Driver");
            prop.setProperty("database.url", url);
            prop.setProperty("database.username", user);
            prop.setProperty("database.password", password);

            BufferedWriter bw = Files.newBufferedWriter(p, StandardCharsets.ISO_8859_1, StandardOpenOption.CREATE);
            prop.store(bw, null);

            sqlMapper = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("configuration.xml"), prop);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reset() {
        try {
            Properties props = new Properties();
            props.load(Files.newBufferedReader(Paths.get("data/jdbc.properties")));
            Reader reader = reader = Resources.getResourceAsReader("configuration.xml");
            sqlMapper = new SqlSessionFactoryBuilder().build(reader, props);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
