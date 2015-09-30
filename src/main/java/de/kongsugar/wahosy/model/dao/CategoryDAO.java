package de.kongsugar.wahosy.model.dao;

import de.kongsugar.wahosy.model.to.Category;

import java.util.List;


public interface CategoryDAO {
     List<Category> getAllCategories();

     Category getCategory(int categoryID) ;
}
