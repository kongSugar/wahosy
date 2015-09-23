package de.kongsugar.wahosy.to;

/**
 * Created by nikog on 17.09.2015.
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
}
