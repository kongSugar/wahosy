package de.kongsugar.wahosy.dao;

import de.kongsugar.wahosy.to.Item;
import org.apache.ibatis.annotations.Select;

/**
 * Created by nikog on 17.09.2015.
 */
public interface ItemDAO {
    String  GET_ITEM_BY_ID = "select * from item where itemID = #{itemID}";

    @Select(GET_ITEM_BY_ID)
    public Item getItem(int itemID) throws Exception;
}
