package de.kongsugar.wahosy.dao;

import de.kongsugar.wahosy.database.ConnectionFactory;
import de.kongsugar.wahosy.to.Category;
import de.kongsugar.wahosy.to.Item;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface ItemDAO {
    Item getItem(int itemID);

    List<Item> getAllItems();

    List<Item> getAllBoxed();

    Item insertItem(Item item);

    void delete(int itemID);

    Item update(Item item);

    List<Item> findBy(String s);

    List<Item> findUnboxedBy(String s);

    List<Item> findBoxedBy(String s);

    List<Item> getByCategory(int categoryID);

    List<Item> getByCategory(Category category);

}
