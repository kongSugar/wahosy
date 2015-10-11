package de.kongsugar.wahosy.model.dao;

import de.kongsugar.wahosy.model.dao.batis.DbItem;
import de.kongsugar.wahosy.model.dao.batis.ConnectionFactory;
import de.kongsugar.wahosy.model.to.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by nikog on 23.09.2015.
 */
public class ItemDAOTest extends Item {
	ItemDAO dao = new DbItem();
	Item i12 = new Item();
	Item i20 = new Item();

	@Before
	public void setUp() throws Exception {
		Setup.HSQLDB();

		Class itemClass = Item.class;
		Field itemID = itemClass.getDeclaredField("itemID");
		Field storeID = itemClass.getDeclaredField("storeID");
		itemID.setAccessible(true);
		storeID.setAccessible(true);

		itemID.set(i12, 12);
		storeID.set(i12, "ri0");
		i12.setName("LODESTAR");
		i12.setManufacturer("Columbus Mc Kinnon");
		i12.setWeight(34100);
		i12.setSerialNumber("1234567890");
		i12.setNote("100kg max last");
		i12.setCategoryID(4);

		itemID.set(i20, 20);
		storeID.set(i20, "li2");
		i20.setName("Source Four MultiPAR 12");
		i20.setManufacturer("ETC");
		i20.setWeight(22222);
		i20.setSerialNumber("ETC01");
		i20.setCategoryID(1);
	}

	@After
	public void tearDown() throws Exception {
		ConnectionFactory.getSession().openSession().getConnection().createStatement().execute("SHUTDOWN");
	}

	@Test
	public void testGetItem() throws Exception {
		assertEquals("Obj", i12, dao.get(12));
	}

	@Test
	public void testGetAllItems() throws Exception {
		List<Item> act = dao.getAll();
		assertEquals("Length", 23, act.size());
		assertEquals("Contains", true, act.contains(i12));
		assertEquals("Contains", true, act.contains(i20));
	}

	@Test
	public void testGetAllBoxed() throws Exception {
		List<Item> act = dao.getBoxed();
		assertEquals("Length", 9, act.size());
		assertEquals("Contains", true, act.contains(i12));
		assertEquals("Contains", false, act.contains(i20));
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
		System.out.println(dao.find("par"));
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