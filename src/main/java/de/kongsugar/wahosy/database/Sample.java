package de.kongsugar.wahosy.database;

import de.kongsugar.wahosy.dao.EventDAO;
import de.kongsugar.wahosy.dao.ItemDAO;
import de.kongsugar.wahosy.to.Event;
import de.kongsugar.wahosy.to.Item;

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

		ItemDAO i = new ItemDAO();
		Item it = ItemDAO.getItem(20);

		System.out.println(it.getItemID());
		System.out.println(it.getName());
		System.out.println(it.getManufacturer());

		for (Event e : EventDAO.getAllEvents()) {
			System.out.println(e.getNote());
			System.out.println(e.getEventID());
			System.out.println(e.getLocation());
			System.out.println(e.getFrom());
			System.out.println(e.getTill());
			if (e.getItems() != null)
				for (Item ii : e.getItems()) {
					System.out.println("--" + ii.getItemID());
					System.out.println("--" + ii.getName());
					System.out.println("--" + ii.getNote());
				}
		}

	}
}
