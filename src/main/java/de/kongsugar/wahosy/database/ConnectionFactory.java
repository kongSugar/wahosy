package de.kongsugar.wahosy.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.prefs.Preferences;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

// TODO google Factory-Pattern
public class ConnectionFactory {
	private static final Logger LOGGER = LogManager.getLogger(DatabaseOld.class.getName());
	private static MysqlDataSource dataSource = null;

	private static ConnectionFactory instance = new ConnectionFactory();

	private ConnectionFactory() {
	}

	public static Connection getConnection() {
		try {
			if (dataSource == null) {
				// TODO Preferences vs Properties vs something else
				Preferences prefs = Preferences.userNodeForPackage(ConnectionFactory.class);
				dataSource = new MysqlDataSource();
				dataSource.setServerName(prefs.get("server", null));
				dataSource.setPort(prefs.getInt("port", -1));
				dataSource.setDatabaseName(prefs.get("database", null));
				dataSource.setUser(prefs.get("user", null));
				dataSource.setPassword(prefs.get("password", null));
			}
			return dataSource.getConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void configureConnection(String server, String port, String db, String user, String password) {

		Preferences prefs = Preferences.userNodeForPackage(DatabaseOld.class);
		prefs.put("server", server);
		prefs.put("port", port);
		prefs.put("database", db);
		prefs.put("user", user);
		prefs.put("password", password);
		// TODO PFUUU - Password wird als Klartext gespeichert :(
	}

}
