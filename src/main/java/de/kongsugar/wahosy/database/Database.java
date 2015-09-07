package de.kongsugar.wahosy.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.prefs.Preferences;

/**
 * Created by nikog on 07.09.2015.
 */
public class Database {
    private static final Logger LOGGER = LogManager.getLogger(DatabaseOld.class.getName());
    private static MysqlDataSource dataSource = null;

    public static Connection getConnection() {
        Connection con = null;
        try {
            if (dataSource == null) {
                Preferences prefs = Preferences.userNodeForPackage(Database.class);
                dataSource = new MysqlDataSource();
                dataSource.setServerName(prefs.get("server", null));
                dataSource.setPort(prefs.getInt("port", -1));
                dataSource.setDatabaseName(prefs.get("database", null));
                dataSource.setUser(prefs.get("user", null));
                dataSource.setPassword(prefs.get("password", null));
            }

            con = dataSource.getConnection();

            // Getting database info
            DatabaseMetaData meta = con.getMetaData();
            System.out.println("Server name: " + meta.getDatabaseProductName());
            System.out.println("Server version: " + meta.getDatabaseProductVersion());

            //con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void configure(String server, String port, String db, String user, String password) {

        Preferences prefs = Preferences.userNodeForPackage(DatabaseOld.class);
        prefs.put("server", server);
        prefs.put("port", port);
        prefs.put("database", db);
        prefs.put("user", user);
        prefs.put("password", password);
        //TODO PFUUU - Password wird als Klartext gespeichert :(
    }

    public static void executeSQL(String sqlFile) throws IOException, SQLException {
        Reader reader = Resources.getResourceAsReader(sqlFile);
        Connection conn = Database.getConnection();
        ScriptRunner runner = new ScriptRunner(conn);
        runner.setLogWriter(null);
        runner.setErrorLogWriter(null);
        runner.runScript(reader);
        conn.commit();
        reader.close();
    }
}
