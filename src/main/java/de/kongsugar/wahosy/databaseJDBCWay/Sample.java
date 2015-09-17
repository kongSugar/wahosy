package de.kongsugar.wahosy.databaseJDBCWay;

import de.kongsugar.wahosy.dao.ItemBO;
import de.kongsugar.wahosy.to.Item;

import java.sql.Connection;

/**
 * Created by nikog on 04.09.2015.
 */
public class Sample {

	public static void main(String[] args) throws Exception {

		// !! SENSIBLE DATEN SOLLTEN NIEMALS HARDCODED SEIN!!
		// Daten könnten sonst in GitHub und co landen und für ALLE einsehbar
		// sein!
		//ConnectionFactory.configureConnection(args[0], args[1], args[2], args[3], args[4]);
		DbUtil.setProperties(args[0], args[1], args[2], args[3], args[4]);

		Connection db = ConnectionFactory.getConnection();
		db.close();

		// DbUtil.executeSQL("sql/Schema.sql");

		ItemBO i = new ItemBO();

		Item it = ItemBO.getItem(20);

		System.out.println(it.getItemID());
		System.out.println(it.getName());
		System.out.println(it.getManufacturer());

	}
}
