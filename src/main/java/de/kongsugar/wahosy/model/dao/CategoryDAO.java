package de.kongsugar.wahosy.model.dao;

import de.kongsugar.wahosy.model.to.Category;

import java.util.List;

/**
 * Interface of the DAO that provides methods to access categories
 */
public interface CategoryDAO {
    List<Category> getAll();
    Category get(int categoryID);

    void delete(int categoryID);
    void delete(Category category);
    void delete(List<Category> categories);

    void insert(Category category);
    void insert(List<Category> categories);

    void update(Category category);

}
