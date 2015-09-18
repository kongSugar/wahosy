package de.kongsugar.wahosy;

import de.kongsugar.wahosy.dao.BoxDAO;
import de.kongsugar.wahosy.dao.CategoryDAO;
import de.kongsugar.wahosy.dao.EventDAO;
import de.kongsugar.wahosy.dao.ItemDAO;
import de.kongsugar.wahosy.database.ConnectionFactory;
import de.kongsugar.wahosy.to.Box;
import de.kongsugar.wahosy.to.Category;
import de.kongsugar.wahosy.to.Event;
import de.kongsugar.wahosy.to.Item;

import java.util.List;

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
        System.out.println(ItemDAO.addItem(item));

        // Select all items within boxes
        for (Item i : ItemDAO.getAllBoxed()) {
            System.out.println("boxes: " + i);
        }

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
                    // Ausgabe aller zu Event e dazugehöriger Item i
                    System.out.println("--" + i);
                }
            }
        }

        for (Box b : BoxDAO.getAllBoxes()) {
            System.out.println(b);
            if (!b.getItems().isEmpty()) {
                for (Item i : b.getItems()) {
                    System.out.println("--" + i);
                }
            }
        }

        System.out.println("Box 1 =" + BoxDAO.getBox(1));

        System.out.println("Category 3 = " + CategoryDAO.getCategory(3));
        for (Category c : CategoryDAO.getAllCategories()) {
            System.out.println("--categories: " + c);
        }

        System.out.println("Item by Category =" + ItemDAO.getByCategory(1));
    }
}
