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
        // Daten könnten sonst in GitHub und co landen und für ALLE einsehbar
        // sein!

        ConnectionFactory.setProperties(args[0], args[1], args[2], args[3], args[4]);

        // DbUtil.executeSQL("Schema.sql");
        Item item = new Item();
        item.setNote("Did by Java");
        item.setName("djgjidjifjgi");
        item.setCategoryID(4);
        item.setWeight(1000);
        item.setManufacturer("Edit XML");
        item.setSerialNumber("Edit XML");

        System.out.println(ItemDAO.addItem(item));

        long t = System.currentTimeMillis();
        List<Item> list = ItemDAO.getAllItems();
        System.out.println("Query all took " + (System.currentTimeMillis() - t));
        System.out.println(list.get(5));

        System.out.println(EventDAO.getEvent(2));
        System.out.println(ItemDAO.getItem(20));

        for (Event e : EventDAO.getAllEvents()) {
            System.out.println(e);
            if (!e.getItems().isEmpty()) {
                for (Item i : e.getItems()) {
                    System.out.println("--" + i);
                }
            }
        }
    }
}
