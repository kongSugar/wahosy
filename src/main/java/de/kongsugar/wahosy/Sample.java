package de.kongsugar.wahosy;

import de.kongsugar.wahosy.dao.BoxDAO;
import de.kongsugar.wahosy.dao.EventDAO;
import de.kongsugar.wahosy.dao.ItemDAO;
import de.kongsugar.wahosy.database.ConnectionFactory;
import de.kongsugar.wahosy.to.Box;
import de.kongsugar.wahosy.to.Event;
import de.kongsugar.wahosy.to.Item;

import java.sql.Timestamp;
import java.time.Instant;
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

        long t;
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

        t = System.currentTimeMillis();
        System.out.println(EventDAO.getEvent(1));
        System.out.println("query event took " + (System.currentTimeMillis() - t));

        if (EventDAO.getEvent(2).getItems() != null)
            for (Item i : EventDAO.getEvent(2).getItems()) {
                System.out.println("--items=" + i);
            }

        if (EventDAO.getEvent(2).getBoxes() != null)
            for (Box b : EventDAO.getEvent(2).getBoxes()) {
                System.out.println("--boxes=" + b);
            }

        for (Event e : EventDAO.getAllEvents()) {
            System.out.println(e);
        }

        for (Event e : EventDAO.getByDate(Timestamp.valueOf("2015-12-20 12:00:00"), Timestamp.valueOf("2016-12-20 12:00:00"))) {
            System.out.println("byDate=" + e);
        }

        System.out.println(EventDAO.getFrom(Timestamp.from(Instant.now())));
        System.out.println(EventDAO.getTill(Timestamp.from(Instant.now())));

        System.out.println(ItemDAO.findUnboxedBy("Licht"));
    }

    public static String generateString(Random rng, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
}
