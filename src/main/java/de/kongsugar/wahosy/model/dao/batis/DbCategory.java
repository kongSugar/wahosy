package de.kongsugar.wahosy.model.dao.batis;

import de.kongsugar.wahosy.model.dao.CategoryDAO;
import de.kongsugar.wahosy.model.to.Category;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class DbCategory implements CategoryDAO {
    @Override
    public List<Category> getAll() {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectList("Category.getAll");
        }
    }

    @Override
    public Category get(int categoryID) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            return session.selectOne("Category.get", categoryID);
        }    }

    @Override
    public void delete(int categoryID) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            session.delete("Category.delete",categoryID);
        }
    }

    @Override
    public void delete(Category category) {
        delete(category.getCategoryID());
    }

    @Override
    public void delete(List<Category> categories) {
        categories.stream().forEach(category -> delete(category.getCategoryID()));
    }

    @Override
    public void insert(Category category) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            session.insert("Category.insert", category);
        }
    }

    @Override
    public void insert(List<Category> categories) {
        categories.stream().forEach(category -> insert(category));

    }

    @Override
    public void update(Category category) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            session.update("Category.update",category);
        }
    }
}
