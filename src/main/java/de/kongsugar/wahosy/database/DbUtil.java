package de.kongsugar.wahosy.database;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;


@Deprecated
public class DbUtil {

    public static void executeSQL(String sqlFile) throws IOException, SQLException {
        try (SqlSession session = de.kongsugar.wahosy.database.ConnectionFactory.getSession().openSession()) {
            Reader reader = Resources.getResourceAsReader(sqlFile);
            ScriptRunner runner = new ScriptRunner(session.getConnection());
            runner.setLogWriter(null);
            runner.setErrorLogWriter(null);
            runner.runScript(reader);
            session.commit();
        }
    }
}