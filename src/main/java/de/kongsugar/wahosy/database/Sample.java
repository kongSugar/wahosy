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

        //!! SENSIBLE DATEN SOLLTEN NIEMALS HARDCODED SEIN!!
        // Daten k�nnten sonst in GitHub und co landen und f�r ALLE einsehbar sein!
        Database.configure(args[0], args[1], args[2], args[3], args[4]);

        Connection db = Database.getConnection();
        db.close();

        Database.executeSQL("sql/Schema.sql");

    }
}
