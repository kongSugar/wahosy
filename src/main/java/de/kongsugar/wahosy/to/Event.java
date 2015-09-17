package de.kongsugar.wahosy.to;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by nikog on 17.09.2015.
 */
public class Event {
    private int eventID;
    private String note;
    private String location;
    private String customer;
    private Timestamp from;
    private Timestamp till;
    private List<Item> items;
    private List<Box> boxes;

    public List<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<Box> boxes) {
        this.boxes = boxes;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Timestamp getFrom() {
        return from;
    }

    public void setFrom(Timestamp from) {
        this.from = from;
    }

    public Timestamp getTill() {
        return till;
    }

    public void setTill(Timestamp till) {
        this.till = till;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventID=" + eventID +
                ", note='" + note + '\'' +
                ", location='" + location + '\'' +
                ", customer='" + customer + '\'' +
                ", from=" + from +
                ", till=" + till +
                ", items=" + items +
                ", boxes=" + boxes +
                '}';
    }
}
