package de.kongsugar.wahosy.model.dao;

import de.kongsugar.wahosy.model.to.Box;
import de.kongsugar.wahosy.model.to.Item;

import java.util.List;

/**
 * Interface of the DAO that provides methods to access boxes
 */
public interface BoxDAO {
    void delete(int boxID);
    void delete(Box box);
    void delete(List<Box> boxes);
    void update(Box box);
    void insert(Box box);

    Box get(int boxID);
    List<Box> getAll();

    List<Item> getItems(int boxID);
    void addItem(int boxID, Item item);
    void addItems(int boxID, List<Item> items);
    void deleteItem(int boxID, Item item);
    void deleteItem(int boxID, int itemID);
    void deleteItems(int boxID, List<Item> items);
}
