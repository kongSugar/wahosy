package de.kongsugar.wahosy.dao;

import de.kongsugar.wahosy.database.ConnectionFactory;
import de.kongsugar.wahosy.to.Event;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by nikog on 17.09.2015.
 */
public class EventDAO {

    public static List<Event> getAllEvents() throws Exception {
        SqlSession session = ConnectionFactory.getSession().openSession();
        //EventDAO dao = session.getMapper(EventDAO.class);
        //dao.getAllEvents();
        List<Event> events = session.selectList("Event.selectAll");
        session.close();
        return events;
    }

    public static Event getEvent(int eventID) {
        SqlSession session = ConnectionFactory.getSession().openSession();
        Event event = session.selectOne("Event.selectById", eventID);
        session.close();
        return event;

    }
}
