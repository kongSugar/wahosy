package de.kongsugar.wahosy.dao;

import de.kongsugar.wahosy.database.ConnectionFactory;
import de.kongsugar.wahosy.to.Box;
import de.kongsugar.wahosy.to.Item;
import org.apache.ibatis.session.SqlSession;

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
