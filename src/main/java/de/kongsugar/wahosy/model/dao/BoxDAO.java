package de.kongsugar.wahosy.model.dao;

import de.kongsugar.wahosy.model.to.Box;
import de.kongsugar.wahosy.model.to.Item;

import java.util.List;

/**
 * Provides access to box-objects in the database
 * @author Niko Gillen
 */
public interface BoxDAO {

List<Box> getAllBoxes();

    Box getBox(int boxID);
  Box getBoxByItem(Item item);

 Box getBoxByItem(int itemID);
}
