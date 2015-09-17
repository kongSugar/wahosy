package de.kongsugar.wahosy.database;

import de.kongsugar.wahosy.dao.ItemBO;
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

		// DbUtil.executeSQL("sql/Schema.sql");

		ItemBO i = new ItemBO();

		Item it = ItemBO.getItem(20);

		System.out.println(it.getItemID());
		System.out.println(it.getName());
		System.out.println(it.getManufacturer());

	}
}
