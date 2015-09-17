package de.kongsugar.wahosy;

import de.kongsugar.wahosy.dao.EventDAO;
import de.kongsugar.wahosy.dao.ItemDAO;
import de.kongsugar.wahosy.database.ConnectionFactory;
import de.kongsugar.wahosy.to.Event;
import de.kongsugar.wahosy.to.Item;

import java.util.List;

/**
 * Created by nikog on 04.09.2015.
 */
public class Sample {

    public static void main(String[] args) throws Exception {

        // !! SENSIBLE DATEN SOLLTEN NIEMALS HARDCODED SEIN!!
        // Daten k�nnten sonst in GitHub und co landen und f�r ALLE einsehbar
        // sein!

        // Speichern der Verbindungsdaten f�r die Datenbank
        // Daten werden unter data/jdbc.properties fest gespeichert
        //setProperties(String server, String port, String db, String user, String password)
        ConnectionFactory.setProperties(args[0], args[1], args[2], args[3], args[4]);

        // Unfertig - so k�nnte eine SQL-Datei ausgef�hrt werden -> laden des schemas
        // DbUtil.executeSQL("Schema.sql");

        // Erstelle einen Gegenstand in Java
        Item item = new Item();
        item.setNote("Did by Java");
        item.setName("djgjidjifjgi");
        item.setCategoryID(4);
        item.setWeight(1000);
        item.setManufacturer("Edit XML");
        item.setSerialNumber("Edit XML");

        // Einf�gen des Gegenstandes in die Datenbank
        System.out.println(ItemDAO.addItem(item));

        // Abfrage aller Items als Liste
        long t = System.currentTimeMillis();
        List<Item> list = ItemDAO.getAllItems();
        System.out.println("Query all took " + (System.currentTimeMillis() - t));
        System.out.println(list.get(5));

        // Abfrage des Events mit der eventID = 2
        System.out.println(EventDAO.getEvent(2));

        // Abfrage des Items mit der itemID = 20
        System.out.println(ItemDAO.getItem(20));

        // Abfrage aller Events als Liste
        for (Event e : EventDAO.getAllEvents()) {
            // Ausgabe des Events
            System.out.println(e);
            if (!e.getItems().isEmpty()) {
                for (Item i : e.getItems()) {
                    // Ausgabe aller zu Event e dazugeh�riger Item i
                    System.out.println("--" + i);
                }
            }
        }
    }
}
