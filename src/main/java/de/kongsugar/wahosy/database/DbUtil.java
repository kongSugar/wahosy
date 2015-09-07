package de.kongsugar.wahosy.database;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;

public class DbUtil {

	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				/* log or print or ignore */
			}
		}
	}

	public static void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				/* log or print or ignore */
			}
		}
	}

	public static void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				/* log or print or ignore */
			}
		}
	}

	public static void executeSQL(String sqlFile) throws IOException, SQLException {
		Reader reader = Resources.getResourceAsReader(sqlFile);
		Connection conn = ConnectionFactory.getConnection();
		ScriptRunner runner = new ScriptRunner(conn);
		runner.setLogWriter(null);
		runner.setErrorLogWriter(null);
		runner.runScript(reader);
		conn.commit();
		reader.close();
	}
}