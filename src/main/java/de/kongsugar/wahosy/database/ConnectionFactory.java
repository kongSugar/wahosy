package de.kongsugar.wahosy.database;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConnectionFactory {

    private static SqlSessionFactory sqlMapper;
    private static Reader reader;
    private static Properties props;

    static {
        try {
            props = new Properties();
            props.load(Files.newBufferedReader(Paths.get("data/jdbc.properties")));
            reader = Resources.getResourceAsReader("sql/configuration.xml");
            sqlMapper = new SqlSessionFactoryBuilder().build(reader, props);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession() {
        return sqlMapper;
    }
}
