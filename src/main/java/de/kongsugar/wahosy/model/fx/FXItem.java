package de.kongsugar.wahosy.model.fx;

import de.kongsugar.wahosy.model.to.Item;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * FXItem is the FX-compatible model of the TO.
 * Instead of simple datatypes FXItem uses properties that are used by JavaFX for bindings and more.
 * An Item-Object is transfered to a FXItem by passing it in the constructor.
 */
public class FXItem {
    private IntegerProperty itemID;
    private StringProperty name;
    private StringProperty manufacturer;
    private IntegerProperty weight;
    private StringProperty serialNumber;
    private StringProperty note;
    private IntegerProperty categoryID;
    private StringProperty storeID;

    private FXItem() {
    }

    ;

    public FXItem(Item i) {
        this.itemID = new SimpleIntegerProperty(i.getItemID());
        this.name = new SimpleStringProperty(i.getName());
        this.manufacturer = new SimpleStringProperty(i.getManufacturer());
        this.weight = new SimpleIntegerProperty(i.getWeight());
        this.serialNumber = new SimpleStringProperty(i.getSerialNumber());
        this.note = new SimpleStringProperty(i.getNote());
        this.categoryID = new SimpleIntegerProperty(i.getCategoryID());
        this.storeID = new SimpleStringProperty(i.getStoreID());
    }

    public Item asItem() {
        Item item = new Item();
        item.setItemID(getItemID());
        item.setName(getName());
        item.setManufacturer(getManufacturer());
        item.setWeight(getWeight());
        item.setSerialNumber(getSerialNumber());
        item.setNote(getNote());
        item.setCategoryID(getCategoryID());
        item.setStoreID(getStoreID());
        return item;
    }

    public int getItemID() {
        return itemID.get();
    }

    public void setItemID(int itemID) {
        this.itemID.set(itemID);
    }

    public IntegerProperty itemIDProperty() {
        return itemID;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer.get();
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer.set(manufacturer);
    }

    public StringProperty manufacturerProperty() {
        return manufacturer;
    }

    public int getWeight() {
        return weight.get();
    }

    public void setWeight(int weight) {
        this.weight.set(weight);
    }

    public IntegerProperty weightProperty() {
        return weight;
    }

    public String getSerialNumber() {
        return serialNumber.get();
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber.set(serialNumber);
    }

    public StringProperty serialNumberProperty() {
        return serialNumber;
    }

    public String getNote() {
        return note.get();
    }

    public void setNote(String note) {
        this.note.set(note);
    }

    public StringProperty noteProperty() {
        return note;
    }

    public int getCategoryID() {
        return categoryID.get();
    }

    public void setCategoryID(int categoryID) {
        this.categoryID.set(categoryID);
    }

    public IntegerProperty categoryIDProperty() {
        return categoryID;
    }

    public String getStoreID() {
        return storeID.get();
    }

    public void setStoreID(String storeID) {
        this.storeID.set(storeID);
    }

    public StringProperty storeIDProperty() {
        return storeID;
    }

    @Override
    public String toString() {
        return "FXItem{" + "itemID=" + itemID + ", name=" + name + ", manufacturer=" + manufacturer + ", weight="
                + weight + ", serialNumber=" + serialNumber + ", note=" + note + ", categoryID=" + categoryID
                + ", storeID=" + storeID + '}';
    }
}
