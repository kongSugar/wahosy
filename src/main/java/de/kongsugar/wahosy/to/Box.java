package de.kongsugar.wahosy.to;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by nikog on 17.09.2015.
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
}
