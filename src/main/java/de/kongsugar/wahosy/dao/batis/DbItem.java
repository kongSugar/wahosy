package de.kongsugar.wahosy.dao.batis;

import de.kongsugar.wahosy.dao.ItemDAO;
import de.kongsugar.wahosy.database.ConnectionFactory;
import de.kongsugar.wahosy.to.Category;
import de.kongsugar.wahosy.to.Item;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * DAO-Implementation of Item.
 * Provides methodes for retrieving data from the database.
 *
 * @author Niko Gillen
 * @version 1.0
 */
public class DbItem implements ItemDAO {

    public Item getItem(int itemID) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectOne("Item.selectById", itemID);
        }
    }

    public List<Item> getAllItems() {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectList("Item.selectAll");
        }
    }

    public List<Item> getAllBoxed() {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectList("selectAllBoxed");
        }
    }

    public Item insertItem(Item item) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            session.insert("Item.insert", item);
            session.commit();
            item = session.selectOne("Item.selectById", item.getItemID()); //Workaround - also set storeID after Insert
            return item;
        }
    }

    public void delete(int itemID) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            session.delete("Item.delete", itemID);
            session.commit();
        }
    }

    public Item update(Item item) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            session.update("update", item);
            session.commit();
            return item;
        }
    }

    public List<Item> findBy(String s) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectList("find", s);
        }
    }

    public List<Item> findUnboxedBy(String s) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectList("findUnboxed", s);
        }
    }

    public List<Item> findBoxedBy(String s) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectList("findBoxed", s);
        }
    }

    public List<Item> getByCategory(int categoryID) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectList("selectByCategory", categoryID);
        }
    }

    public List<Item> getByCategory(Category category) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectList("selectByCategory", category.getCategoryID());
        }
    }

}
