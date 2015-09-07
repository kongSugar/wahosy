package de.kongsugar.wahosy.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.prefs.Preferences;

/**
 * Created by nikog on 07.09.2015.
 */
public class Database {
    public static void configure(String server, String port, String db, String user, String password) {

        Preferences prefs = Preferences.userNodeForPackage(DatabaseOld.class);
        prefs.put("server", server);
        prefs.put("port", port);
        prefs.put("database", db);
        prefs.put("user", user);
        prefs.put("password", password);
        //TODO PFUUU - Password wird als Klartext gespeichert :(
    }


    public static Connection getConnection() {
        Connection con = null;
        Preferences prefs = Preferences.userNodeForPackage(Database.class);

        try {
            MysqlDataSource ds = new MysqlDataSource();
            ds.setServerName(prefs.get("server", null));
            ds.setPort(prefs.getInt("port", -1));
            ds.setDatabaseName(prefs.get("database", null));
            ds.setUser(prefs.get("user", null));
            ds.setPassword(prefs.get("password", null));

            // TODO ... setup by Preferences
            con = ds.getConnection();

            // Getting a connection object
            con = ds.getConnection();

            // Getting database info
            DatabaseMetaData meta = con.getMetaData();
            System.out.println("Server name: "
                    + meta.getDatabaseProductName());
            System.out.println("Server version: "
                    + meta.getDatabaseProductVersion());

            // Closing the connection
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    private static void log(Object aObject) {
        System.out.println(aObject);
    }

    public static void main(String[] args) {
        Database t = new Database();
        t.getConnection();
    }
}
