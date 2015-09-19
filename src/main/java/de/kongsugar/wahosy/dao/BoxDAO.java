package de.kongsugar.wahosy.dao;

import de.kongsugar.wahosy.database.ConnectionFactory;
import de.kongsugar.wahosy.to.Box;
import de.kongsugar.wahosy.to.Item;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by nikog on 17.09.2015.
 */
public class BoxDAO {
    public static List<Box> getAllBoxes() {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectList("Box.selectAll");
        }
    }

    public static Box getBox(int boxID) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectOne("Box.selectById", boxID);
        }
    }

    public static Box getBoxByItem(Item item) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectOne("Box.selectByItem", item.getItemID());
        }
    }

    public static Box getBoxByItem(int itemID) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectOne("Box.selectByItem", itemID);
        }
    }
}
