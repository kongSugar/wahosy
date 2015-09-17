package de.kongsugar.wahosy.databaseJDBCWay;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.prefs.Preferences;

// TODO google Factory-Pattern
public class ConnectionFactory {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionFactory.class.getName());
    private static MysqlDataSource dataSource = null;

    private static ConnectionFactory instance = new ConnectionFactory();

    private ConnectionFactory() {
    }

    public static Connection getConnection() {
        try {
            if (dataSource == null) {
                Properties prop = new Properties();
                prop.load(Files.newBufferedReader(Paths.get("data/jdbc.properties")));
                dataSource = new MysqlDataSource();
                dataSource.setURL(prop.getProperty("database.url", null));
                dataSource.setUser(prop.getProperty("database.username", null));
                dataSource.setPassword(prop.getProperty("database.password", null));

                // TODO Preferences vs Properties vs something else
//				Preferences prefs = Preferences.userNodeForPackage(ConnectionFactory.class);
//				dataSource = new MysqlDataSource();
//				dataSource.setServerName(prefs.get("server", null));
//				dataSource.setPort(prefs.getInt("port", -1));
//				dataSource.setDatabaseName(prefs.get("database", null));
//				dataSource.setUser(prefs.get("user", null));
//				dataSource.setPassword(prefs.get("password", null));
            }
            return dataSource.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void configureConnection(String server, String port, String db, String user, String password) {

        Preferences prefs = Preferences.userNodeForPackage(ConnectionFactory.class);
        prefs.put("server", server);
        prefs.put("port", port);
        prefs.put("database", db);
        prefs.put("user", user);
        prefs.put("password", password);
        // TODO PFUUU - Password wird als Klartext gespeichert :(
    }

}
