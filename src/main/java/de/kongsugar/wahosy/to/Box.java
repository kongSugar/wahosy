package de.kongsugar.wahosy.to;

import java.util.List;

/**
 * Created by nikog on 17.09.2015.
 */
public class Box {
    private int boxID;
    private String name;
    private String note;
    private List<Item> box_has_item; // TODO ??! Mybatis?

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
                ", box_has_item=" + box_has_item +
                '}';
    }
}
