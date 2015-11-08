package de.kongsugar.wahosy.model.to;

import java.util.Objects;

/**
 * Simple POJO of the Category-objects
 */
public class Category {
    private int categoryID;
    private String name = "";
    private String abbreviation = "";
    private int lastID;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getLastID() {
        return lastID;
    }

    public void setLastID(int lastID) {
        this.lastID = lastID;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryID=" + categoryID +
                ", name='" + name + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", lastID=" + lastID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return categoryID == category.categoryID &&
                lastID == category.lastID &&
                Objects.equals(name, category.name) &&
                Objects.equals(abbreviation, category.abbreviation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryID, name, abbreviation, lastID);
    }
}
