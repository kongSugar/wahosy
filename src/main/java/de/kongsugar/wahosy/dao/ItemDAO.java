package de.kongsugar.wahosy.dao;

import de.kongsugar.wahosy.database.ConnectionFactory;
import de.kongsugar.wahosy.to.Item;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by nikog on 07.09.2015.
 */
public class ItemDAO {

    public static Item getItem(int itemID) throws Exception {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectOne("Item.selectById", itemID);
        }
    }

    public static List<Item> getAllItems() {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectList("Item.selectAll");
        }
    }

    public static Item addItem(Item item) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            session.insert("Item.insert", item);
            session.commit();
            item = session.selectOne("Item.selectById", item.getItemID()); //Workaround - also set storeID after Insert
            return item;
        }
    }

}
