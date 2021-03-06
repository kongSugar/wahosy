package de.kongsugar.wahosy.model.dao.batis;

import de.kongsugar.wahosy.model.dao.ItemDAO;
import de.kongsugar.wahosy.model.to.Item;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * DbItem is an implementation of the ItemDAO in iBatis.
 * It offers several operations on the database that connections are managed by the ConnectionFactory.
 * The locations of the SQL-Statements that are addressed by the string-parameter like Item.update are
 * located in the configuration.xml under /resources .
 */
public class DbItem implements ItemDAO {

	@Override
	public void delete(int itemID) {
		try (SqlSession session = ConnectionFactory.getSession().openSession()) {
			session.delete("Item.delete", itemID);			session.commit();

		}
	}

	@Override
	public void delete(Item item) {
		delete(item.getItemID());
	}

	@Override
	public void delete(List<Item> items) {
		items.stream().forEach(item -> delete(item.getItemID()));
	}

	@Override
	public void insert(Item item) {
		try (SqlSession session = ConnectionFactory.getSession().openSession()) {
			session.insert("Item.insert", item);
			session.commit();
		}
	}

	@Override
	public void insert(List<Item> items) {
		items.stream().forEach(item -> insert(item));
	}

	@Override
	public void update(Item item) {
		try (SqlSession session = ConnectionFactory.getSession().openSession()) {
			session.update("Item.update", item);			session.commit();

		}
	}

	@Override
	public Item get(int itemID) {
		try (SqlSession session = ConnectionFactory.getSession().openSession()) {
			return session.selectOne("Item.get", itemID);
		}
	}

	@Override
	public List<Item> getAll() {
		try (SqlSession session = ConnectionFactory.getSession().openSession()) {
			return session.selectList("Item.getAll");
		}
	}

	@Override
	public List<Item> getUnboxed() {
		try (SqlSession session = ConnectionFactory.getSession().openSession()) {
			return session.selectList("Item.getUnboxed");
		}
	}

	@Override
	public List<Item> getBoxed() {
		try (SqlSession session = ConnectionFactory.getSession().openSession()) {
			return session.selectList("Item.getBoxed");
		}
	}

	@Override
	public List<Item> getByCategory(int categoryID) {
		try (SqlSession session = ConnectionFactory.getSession().openSession()) {
			return session.selectList("Item.getByCategory", categoryID);
		}
	}

	@Override
	public List<Item> find(String string) {
		try (SqlSession session = ConnectionFactory.getSession().openSession()) {
			return session.selectList("Item.find", string);
		}
	}

	@Override
	public List<Item> findUnboxed(String string) {
		try (SqlSession session = ConnectionFactory.getSession().openSession()) {
			return session.selectList("Item.findUnboxed", string);
		}
	}

	@Override
	public List<Item> findBoxed(String string) {
		try (SqlSession session = ConnectionFactory.getSession().openSession()) {
			return session.selectList("Item.findBoxed", string);
		}
	}

	@Override
	public boolean isBoxed(Item item) {
		return false;
	}
}
