package de.kongsugar.wahosy.model.dao.batis;

import de.kongsugar.wahosy.model.dao.BoxDAO;
import de.kongsugar.wahosy.model.to.Box;
import de.kongsugar.wahosy.model.to.Item;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class DbBox implements BoxDAO {
    /**
     * Returns all boxes of the table 'box'
     *
     * @return List of Boxes
     */
    public List<Box> getAllBoxes() {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectList("Box.selectAll");
        }
    }

    /**
     * Returns a specific box from the table 'box'
     *
     * @param boxID
     * @return Box
     */
    public Box getBox(int boxID) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectOne("Box.selectById", boxID);
        }
    }

    public Box getBoxByItem(Item item) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectOne("Box.selectByItem", item.getItemID());
        }
    }

    public Box getBoxByItem(int itemID) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectOne("Box.selectByItem", itemID);
        }
    }
}
