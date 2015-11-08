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

/**
 * ConnectionFactory manages the sessions/connections to the database with the help of ibatis.
 */
class ConnectionFactory {

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

    /**
     * @return the SqlSessionFactory
     * @see SqlSessionFactory
     */
    static SqlSessionFactory getSession() {
        return sqlMapper;
    }


    /**
     * Sets parameters in data/jdbc.properties required for connection to the database
     * @deprecated Settings should be configured in Config class
     * @see de.kongsugar.wahosy.Config
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

    /**
     * @deprecated Connection should not be reset! Instead user should restart the program
     */
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
