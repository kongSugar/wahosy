package de.kongsugar.wahosy.model.to;

import java.util.Objects;

/**
 * Created by nikog on 07.09.2015.
 */
public class Item {
    private int itemID;
    private String name = "";
    private String manufacturer = "";
    private int weight;
    private String serialNumber = "";
    private String note = "";
    private int categoryID;
    private String storeID = "";

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Item item = (Item) o;
		return Objects.equals(itemID, item.itemID) && Objects.equals(weight, item.weight)
				&& Objects.equals(categoryID, item.categoryID) && Objects.equals(name, item.name)
				&& Objects.equals(manufacturer, item.manufacturer) && Objects.equals(serialNumber, item.serialNumber)
				&& Objects.equals(note, item.note) && Objects.equals(storeID, item.storeID);
	}

    @Override
    public int hashCode() {
        return Objects.hash(itemID, name, manufacturer, weight, serialNumber, note, categoryID, storeID);
    }

    public int getItemID() {
        return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getStoreID() {
        return storeID;
	}

	public void setStoreID(String storeID) {
		this.storeID = storeID;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemID=" + itemID +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", weight=" + weight +
                ", serialNumber='" + serialNumber + '\'' +
                ", note='" + note + '\'' +
                ", categoryID=" + categoryID +
                ", storeID='" + storeID + '\'' +
                '}';
    }
}
