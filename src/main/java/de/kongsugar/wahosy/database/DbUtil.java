package de.kongsugar.wahosy.database;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

public class DbUtil {

    public static void executeSQL(String sqlFile) throws IOException, SQLException {
        Reader reader = Resources.getResourceAsReader(sqlFile);
        SqlSession session = de.kongsugar.wahosy.database.ConnectionFactory.getSession().openSession();
        Connection conn = session.getConnection();
        ScriptRunner runner = new ScriptRunner(conn);
        runner.setLogWriter(null);
        runner.setErrorLogWriter(null);
        runner.runScript(reader);
        conn.commit();
        reader.close();
        conn.close();
        session.close();
    }
}