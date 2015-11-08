package de.kongsugar.wahosy.model.to;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 * Simple POJO of the Event-objects
 */
public class Event {
    private int eventID;
    private String note;
    private String location;
    private String customer;
    private Timestamp from;
    private Timestamp till;
    private List<Item> items = new LinkedList<>();
    private List<Box> boxes = new LinkedList<>();

    public List<Box> getBoxes() {
        return boxes;
    }

    public Event setBoxes(List<Box> boxes) {
        this.boxes = boxes;
        return this;
    }

    public List<Item> getItems() {
        return items;
    }

    public Event setItems(List<Item> items) {
        this.items = items;
        return this;
    }

    public int getEventID() {
        return eventID;
    }

    public Event setEventID(int eventID) {
        this.eventID = eventID;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Event setNote(String note) {
        this.note = note;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Event setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public Event setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public Timestamp getFrom() {
        return from;
    }

    public Event setFrom(Timestamp from) {
        this.from = from;
        return this;
    }

    public Timestamp getTill() {
        return till;
    }

    public Event setTill(Timestamp till) {
        this.till = till;
        return this;
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
