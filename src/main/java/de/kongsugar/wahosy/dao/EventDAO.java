package de.kongsugar.wahosy.dao;

import de.kongsugar.wahosy.database.ConnectionFactory;
import de.kongsugar.wahosy.to.Event;
import org.apache.ibatis.session.SqlSession;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by nikog on 17.09.2015.
 */
public class EventDAO {

    public static List<Event> getAllEvents() throws Exception {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            List<Event> events = session.selectList("Event.selectAll");
            events = fillUp(events);
            return events;
        }

    }

    public static Event getEvent(int eventID) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            Event event = session.selectOne("Event.selectById", eventID);
            event = fillUp(event);
            return event;
        }
    }

    public static List<Event> getByDate(Timestamp from, Timestamp till) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            List<Event> events = session.selectList("Event.selectByDate", new Event().setFrom(from).setTill(till));
            events = fillUp(events);
            return events;
        }
    }

    public static List<Event> getFrom(Timestamp from) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            List<Event> events = session.selectList("Event.selectByDate", new Event().setFrom(from));
            events = fillUp(events);
            return events;
        }
    }

    public static List<Event> getTill(Timestamp till) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            List<Event> events = session.selectList("Event.selectByDate", new Event().setTill(till));
            events = fillUp(events);
            return events;
        }
    }

    private static Event fillUp(Event event) {
        if (event != null) {
            if (!event.getBoxes().isEmpty()) event.getBoxes().replaceAll(box -> BoxDAO.getBox(box.getBoxID()));
            if (!event.getItems().isEmpty()) event.getItems().replaceAll(item -> ItemDAO.getItem(item.getItemID()));
        }
        return event;
    }

    private static List<Event> fillUp(List<Event> events) {
        if (events != null) {
            for (Event e : events) {
                if (e != null) {
                    if (!e.getBoxes().isEmpty()) e.getBoxes().replaceAll(box -> BoxDAO.getBox(box.getBoxID()));
                    if (!e.getItems().isEmpty()) e.getItems().replaceAll(item -> ItemDAO.getItem(item.getItemID()));
                }
            }
        }
        return events;
    }
}
