package de.kongsugar.wahosy.dao;

import de.kongsugar.wahosy.database.ConnectionFactory;
import de.kongsugar.wahosy.database.DbUtil;
import de.kongsugar.wahosy.to.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by nikog on 07.09.2015.
 */
public class ItemDAO {
	// TODO http://theopentutorials.com/tutorials/java/jdbc/jdbc-examples-introduction/#Design_Patterns_Used
	Connection connection;
	private PreparedStatement stmt;

	public Item getItem(int itemID) {
		String query = "SELECT * FROM item WHERE itemID = ?";
		Item item = null;
		ResultSet rs = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, itemID);
			rs = stmt.executeQuery();
			// TODO replace by JPA(Hibernate or Eclipselink?)
			if (rs.next()) { // You must call rs.next() to access the first row
								// of the result set:
				// System.out.println(rs.getMetaData());
				item = new Item();
				item.setItemID(rs.getInt("itemID"));
				item.setCategoryID(rs.getInt("categoryID"));
				item.setManufacturer(rs.getString("manufacturer"));
				item.setName(rs.getString("name"));
				item.setNote(rs.getString("note"));
				item.setSerialNumber(rs.getString("serialNumber"));
				item.setStoreID(rs.getString("storeID"));
				item.setWeight(rs.getInt("weight"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(connection);
			DbUtil.close(rs);
			DbUtil.close(stmt);
		}
		return item;
	}

	public Item getItemWithMybatis(int itemID){
		Item item = null;

		return item;
	}

}
