package de.kongsugar.wahosy.model.dao.fuer_spaeter;

import de.kongsugar.wahosy.model.to.Event;

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
