package de.kongsugar.wahosy;

import de.kongsugar.wahosy.dao.BoxDAO;
import de.kongsugar.wahosy.dao.ItemDAO;
import de.kongsugar.wahosy.database.ConnectionFactory;
import de.kongsugar.wahosy.to.Item;

import java.util.Random;

/**
 * Created by nikog on 04.09.2015.
 */
public class Sample {

    public static void main(String[] args) throws Exception {


        // !! SENSIBLE DATEN SOLLTEN NIEMALS HARDCODED SEIN!!
        // Daten könnten sonst in GitHub und co landen und für ALLE einsehbar
        // sein!

        // Speichern der Verbindungsdaten für die Datenbank
        // Daten werden unter data/jdbc.properties fest gespeichert
        //setProperties(String server, String port, String db, String user, String password)
        ConnectionFactory.setProperties(args[0], args[1], args[2], args[3], args[4]);

        // Unfertig - so könnte eine SQL-Datei ausgeführt werden -> laden des schemas
        // DbUtil.executeSQL("Schema.sql");

        // Erstelle einen Gegenstand in Java
        Item item = new Item();
        item.setNote("Did by Java");
        item.setName("djgjidjifjgi");
        item.setCategoryID(4);
        item.setWeight(1000);
        item.setManufacturer("Edit XML");
        item.setSerialNumber("Edit XML");

        // Einfügen des Gegenstandes in die Datenbank
        System.out.println(ItemDAO.insertItem(item));

        // Select all items within boxes
        for (Item i : ItemDAO.getAllBoxed()) {
            System.out.println("boxes: " + i);
        }

        System.out.println(BoxDAO.getBoxByItem(98));

    }

    public static String generateString(Random rng, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
}
