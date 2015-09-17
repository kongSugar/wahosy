package de.kongsugar.wahosy.databaseJDBCWay;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.*;
import java.util.Properties;

public class DbUtil {

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

    public static void close(PreparedStatement statement) {
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