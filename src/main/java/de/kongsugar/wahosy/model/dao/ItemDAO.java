package de.kongsugar.wahosy.model.dao;

import de.kongsugar.wahosy.model.to.Item;

import java.util.List;

/**
 * Interface of the DAO that provides methods to access items
 */
public interface ItemDAO {
    void delete(int itemID);
    void delete(Item item);
    void delete(List<Item> items);

    void insert(Item item);
    void insert(List<Item> items);

    void update(Item item);

    Item get(int itemID);

    List<Item> getAll();
    List<Item> getUnboxed();
    List<Item> getBoxed();
    List<Item> getByCategory(int categoryID);
    List<Item> find(String string);
    List<Item> findUnboxed(String string);
    List<Item> findBoxed(String string);

    boolean isBoxed(Item item);

}
