package de.kongsugar.wahosy.database;

import java.sql.Connection;

/**
 * Created by nikog on 04.09.2015.
 */
public class Sample {

    public static void main(String[] args) {

        //!! SENSIBLE DATEN SOLLTEN NIEMALS HARDCODED SEIN!!
        // Daten könnten sonst in GitHub und co landen und für ALLE einsehbar sein!
        Database.configure(args[0], args[1], args[2], args[3], args[4]);
        Connection db = Database.getInstance();

    }
}
