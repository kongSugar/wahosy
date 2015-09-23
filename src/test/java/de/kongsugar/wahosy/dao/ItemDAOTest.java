package de.kongsugar.wahosy.dao;

import de.kongsugar.wahosy.database.ConnectionFactory;
import de.kongsugar.wahosy.to.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nikog on 23.09.2015.
 */
public class ItemDAOTest {

	@Before
	public void setUp() throws Exception {
		Setup.HSQLDB();

	}

	@After
	public void tearDown() throws Exception {
		ConnectionFactory.getSession().openSession().getConnection().createStatement().execute("SHUTDOWN");
	}

	@Test
	public void testGetItem() throws Exception {
		Item exp = new Item();
		exp.setItemID(42);
		exp.setStoreID("ri0");
		exp.setName("LODESTAR");
		exp.setManufacturer("Columbus Mc Kinnon");
		exp.setWeight(34100);
		exp.setSerialNumber("1234567890");
		exp.setNote("100kg max last");
		exp.setCategoryID(5);
		ItemDAO.insertItem(exp);

		//files_readonly=true
		System.out.println(ItemDAO.getItem(5));
		assertEquals("Obj", ItemDAO.getItem(42), exp);
	}

	@Test
	public void testGetAllItems() throws Exception {
	}

	@Test
	public void testGetAllBoxed() throws Exception {

	}

	@Test
	public void testInsertItem() throws Exception {

	}

	@Test
	public void testDelete() throws Exception {

	}

	@Test
	public void testUpdate() throws Exception {

	}

	@Test
	public void testFindBy() throws Exception {

	}

	@Test
	public void testFindUnboxedBy() throws Exception {

	}

	@Test
	public void testFindBoxedBy() throws Exception {

	}

	@Test
	public void testGetByCategory() throws Exception {

	}

	@Test
	public void testGetByCategory1() throws Exception {

	}
}