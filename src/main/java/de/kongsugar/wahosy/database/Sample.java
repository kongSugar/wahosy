package de.kongsugar.wahosy.database;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by nikog on 04.09.2015.
 */
public class Sample {

	public static void main(String[] args) throws URISyntaxException, IOException, SQLException {

		// !! SENSIBLE DATEN SOLLTEN NIEMALS HARDCODED SEIN!!
		// Daten könnten sonst in GitHub und co landen und für ALLE einsehbar
		// sein!
		ConnectionFactory.configureConnection(args[0], args[1], args[2], args[3], args[4]);

		Connection db = ConnectionFactory.getConnection();
		db.close();

		DbUtil.executeSQL("sql/Schema.sql");

	}
}
