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
        List<Event> events = session.selectList("getAllEvents");  //dao.getAllEvents();
        session.close();
        return events;
    }

    public static Event getEvent(int eventID) {
        SqlSession session = ConnectionFactory.getSession().openSession();
        Event event = session.selectOne("getEventByID", eventID);
        session.close();
        return event;

    }
}
