package de.kongsugar.wahosy.dao;

import de.kongsugar.wahosy.to.Event;

import java.sql.Timestamp;
import java.util.List;


public interface EventDAO {

    List<Event> getAllEvents();

    Event getEvent(int eventID);

    List<Event> getByDate(Timestamp from, Timestamp till);

    List<Event> getFrom(Timestamp from);

    List<Event> getTill(Timestamp till);

    Event fillUp(Event event);

    List<Event> fillUp(List<Event> events);
}
