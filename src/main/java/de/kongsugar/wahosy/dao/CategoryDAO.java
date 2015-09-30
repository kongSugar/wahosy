package de.kongsugar.wahosy.dao;

import de.kongsugar.wahosy.database.ConnectionFactory;
import de.kongsugar.wahosy.to.Category;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public interface CategoryDAO {
     List<Category> getAllCategories();

     Category getCategory(int categoryID) ;
}
