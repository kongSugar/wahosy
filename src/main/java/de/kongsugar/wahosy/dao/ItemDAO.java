package de.kongsugar.wahosy.dao;

import de.kongsugar.wahosy.database.ConnectionFactory;
import de.kongsugar.wahosy.to.Item;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by nikog on 07.09.2015.
 */
public class ItemDAO {

    public static Item getItem(int itemID) throws Exception {
        SqlSession session = ConnectionFactory.getSession().openSession();
        Item item = session.selectOne("getItemByID", itemID);
        session.close();
        return item;
    }

}
