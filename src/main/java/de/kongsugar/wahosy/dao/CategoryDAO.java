package de.kongsugar.wahosy.dao;

import de.kongsugar.wahosy.database.ConnectionFactory;
import de.kongsugar.wahosy.to.Category;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by nikog on 17.09.2015.
 */
public class CategoryDAO {
    public static List<Category> getAllCategories() {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectList("Category.selectAll");
        }
    }

    public static Category getCategory(int categoryID) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectOne("Category.selectById", categoryID);
        }
    }
}
