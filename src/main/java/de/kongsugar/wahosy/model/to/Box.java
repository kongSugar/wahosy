package de.kongsugar.wahosy.model.to;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Simple POJO of the Box-objects
 */
public class Box {
    private int boxID;
    private String name = "";
    private String note = "";
    private List<Item> items = new LinkedList<>();

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getBoxID() {
        return boxID;
    }

    public void setBoxID(int boxID) {
        this.boxID = boxID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Box{" +
                "boxID=" + boxID +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return boxID == box.boxID &&
                Objects.equals(name, box.name) &&
                Objects.equals(note, box.note) &&
                Objects.equals(items, box.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boxID, name, note, items);
    }
}
