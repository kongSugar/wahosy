package de.kongsugar.wahosy.model.dao.fuer_spaeter;

import de.kongsugar.wahosy.model.dao.batis.ConnectionFactory;
import de.kongsugar.wahosy.model.dao.batis.DbBox;
import de.kongsugar.wahosy.model.dao.batis.DbItem;
import de.kongsugar.wahosy.model.dao.fuer_spaeter.EventDAO;
import de.kongsugar.wahosy.model.to.Event;
import org.apache.ibatis.session.SqlSession;

import java.sql.Timestamp;
import java.util.List;


public class DbEvent implements EventDAO {
    public List<Event> getAllEvents() {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            List<Event> events = session.selectList("Event.selectAll");
            events = fillUp(events);
            return events;
        }

    }

    public Event getEvent(int eventID) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            Event event = session.selectOne("Event.selectById", eventID);
            event = fillUp(event);
            return event;
        }
    }

    public List<Event> getByDate(Timestamp from, Timestamp till) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            List<Event> events = session.selectList("Event.selectByDate", new Event().setFrom(from).setTill(till));
            events = fillUp(events);
            return events;
        }
    }

    public List<Event> getFrom(Timestamp from) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            List<Event> events = session.selectList("Event.selectByDate", new Event().setFrom(from));
            events = fillUp(events);
            return events;
        }
    }

    public List<Event> getTill(Timestamp till) {
        try (SqlSession session = ConnectionFactory.getSession().openSession()) {
            List<Event> events = session.selectList("Event.selectByDate", new Event().setTill(till));
            events = fillUp(events);
            return events;
        }
    }

    public Event fillUp(Event event) {
        if (event != null) {
            if (!event.getBoxes().isEmpty()) event.getBoxes().replaceAll(box -> new DbBox().getBox(box.getBoxID()));
            if (!event.getItems().isEmpty())
                event.getItems().replaceAll(item -> new DbItem().get(item.getItemID()));
        }
        return event;
    }

    public List<Event> fillUp(List<Event> events) {
        if (events != null) {
            for (Event e : events) {
                if (e != null) {
                    if (!e.getBoxes().isEmpty()) e.getBoxes().replaceAll(box -> new DbBox().getBox(box.getBoxID()));
                    if (!e.getItems().isEmpty())
                        e.getItems().replaceAll(item -> new DbItem().get(item.getItemID()));
                }
            }
        }
        return events;
    }
}
