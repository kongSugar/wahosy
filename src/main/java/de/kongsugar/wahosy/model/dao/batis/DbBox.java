package de.kongsugar.wahosy.model.dao.batis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.kongsugar.wahosy.model.dao.ItemDAO;
import org.apache.ibatis.session.SqlSession;

import de.kongsugar.wahosy.model.dao.BoxDAO;
import de.kongsugar.wahosy.model.to.Box;
import de.kongsugar.wahosy.model.to.Item;

public class DbBox implements BoxDAO {

	@Override
	public void delete(int boxID) {
		try (SqlSession session = ConnectionFactory.getSession().openSession()) {
			session.delete("Box.delete", boxID);			session.commit();

		}
	}

	@Override
	public void delete(Box box) {
		delete(box.getBoxID());
	}

	@Override
	public void delete(List<Box> boxes) {
		boxes.stream().forEach(box -> delete(box));
	}

	@Override
	public void update(Box box) {
		try (SqlSession session = ConnectionFactory.getSession().openSession()) {
			session.update("Box.update", box);			session.commit();

		}
	}

	@Override
	public void insert(Box box) {
		try (SqlSession session = ConnectionFactory.getSession().openSession()) {
			session.insert("Box.insert", box);			session.commit();

		}
	}

	@Override
	public Box get(int boxID) {
		try (SqlSession session = ConnectionFactory.getSession().openSession()) {
			return session.selectOne("Box.get", boxID);
		}
	}

	@Override
	public List<Box> getAll() {
		try (SqlSession session = ConnectionFactory.getSession().openSession()) {
			return session.selectList("Box.getAll");
		}
	}

	@Override
	public List<Item> getItems(int boxID) {
		try (SqlSession session = ConnectionFactory.getSession().openSession()) {
			//TODO Box.getItems
			List<Integer> ids = session.selectList("Box.getItems",boxID);
			ItemDAO dao = new DbItem();
			List<Item> items = new ArrayList<>();
			ids.stream().map(dao::get).forEach(items::add);
			return items;
			//return session.selectList("Box.getItems", boxID);
		}
	}

	@Override
	public void addItem(int boxID, Item item) {
		try (SqlSession session = ConnectionFactory.getSession().openSession()) {
			Map<String,Integer> map = new HashMap<>();
			map.put("boxID",boxID);
			map.put("itemID",item.getItemID());
			session.insert("Box.addItem", map);			session.commit();

		}
	}

	@Override
	public void addItems(int boxID, List<Item> items) {
		items.stream().forEach(item -> addItem(boxID, item));
	}

	@Override
	public void deleteItem(int boxID, Item item) {
		try (SqlSession session = ConnectionFactory.getSession().openSession()) {
			Map<String,Integer> map = new HashMap<>();
			map.put("boxID",boxID);
			map.put("itemID",item.getItemID());
			session.delete("Box.deleteItem",map);			session.commit();

		}
	}

	@Override
	public void deleteItem(int boxID, int itemID) {
		try (SqlSession session = ConnectionFactory.getSession().openSession()) {
			Map<String,Integer> map = new HashMap<>();
			map.put("boxID",boxID);
			map.put("itemID", itemID);
			session.delete("Box.deleteItem",map);
			session.commit();

		}
	}

	@Override
	public void deleteItems(int boxID, List<Item> items) {
        items.stream().forEach(item -> deleteItem(boxID,item));
	}
}
