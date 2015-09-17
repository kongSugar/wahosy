package de.kongsugar.wahosy.dao;

import de.kongsugar.wahosy.database.ConnectionFactory;
import de.kongsugar.wahosy.to.Item;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by nikog on 07.09.2015.
 */
public class ItemBO {

    public static Item getItem(int itemID) throws Exception {
        SqlSession session = ConnectionFactory.getSession().openSession();
        ItemDAO dao = session.getMapper(ItemDAO.class);
        Item item = dao.getItem(itemID);
        session.close();
        return item;
    }

}
