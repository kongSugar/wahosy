package de.kongsugar.wahosy.database;

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
    private static Reader reader;
    private static Properties props;

    static {
        try {
            props = new Properties();
            props.load(Files.newBufferedReader(Paths.get("data/jdbc.properties")));
            reader = Resources.getResourceAsReader("configuration.xml");
            sqlMapper = new SqlSessionFactoryBuilder().build(reader, props);
            //sqlMapper.getConfiguration().addMapper(EventDAO.class);
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

            // TODO - Mybatis Integration
            BufferedWriter bw = Files.newBufferedWriter(p, StandardCharsets.ISO_8859_1, StandardOpenOption.CREATE);
            prop.store(bw, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
