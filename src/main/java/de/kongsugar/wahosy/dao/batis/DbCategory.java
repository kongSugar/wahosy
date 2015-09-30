package de.kongsugar.wahosy.dao.batis;

import de.kongsugar.wahosy.dao.CategoryDAO;
import de.kongsugar.wahosy.database.ConnectionFactory;
import de.kongsugar.wahosy.to.Category;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class DbCategory implements CategoryDAO{
    public  List<Category> getAllCategories() {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectList("Category.selectAll");
        }
    }

    public  Category getCategory(int categoryID) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectOne("Category.selectById", categoryID);
        }
    }
}
