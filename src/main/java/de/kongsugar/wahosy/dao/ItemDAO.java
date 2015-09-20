package de.kongsugar.wahosy.dao;

import de.kongsugar.wahosy.database.ConnectionFactory;
import de.kongsugar.wahosy.to.Category;
import de.kongsugar.wahosy.to.Item;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by nikog on 07.09.2015.
 */
public class ItemDAO {

    public static Item getItem(int itemID) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectOne("Item.selectById", itemID);
        }
    }

    public static List<Item> getAllItems() {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectList("Item.selectAll");
        }
    }

    public static List<Item> getAllBoxed() {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectList("selectAllBoxed");
        }
    }

    public static Item insertItem(Item item) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            session.insert("Item.insert", item);
            session.commit();
            item = session.selectOne("Item.selectById", item.getItemID()); //Workaround - also set storeID after Insert
            return item;
        }
    }

    public static void delete(int itemID) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            session.delete("Item.delete", itemID);
            session.commit();
        }
    }

    public static Item update(Item item) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            session.update("update", item);
            session.commit();
            return item;
        }
    }

    public static List<Item> findBy(String s) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectList("find", s);
        }
    }

    public static List<Item> findUnboxedBy(String s) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectList("findUnboxed", s);
        }
    }

    public static List<Item> findBoxedBy(String s) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectList("findBoxed", s);
        }
    }

    public static List<Item> getByCategory(int categoryID) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectList("selectByCategory", categoryID);
        }
    }

    public static List<Item> getByCategory(Category category) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectList("selectByCategory", category.getCategoryID());
        }
    }

}
