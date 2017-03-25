package com.HelpDesk.dao.implementations;


import com.HelpDesk.dao.entity.Ticket;
import com.HelpDesk.dao.interfaces.TicketDAO;
import com.HelpDesk.hibernateFactory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxim_Ozarovskiy on 12.02.2017.
 */

public class TicketDAOImpl<T extends Ticket> implements TicketDAO<T> {

    @Override
    public void addTicket(Ticket ticket) throws SQLException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(ticket);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTicket(Ticket ticket) throws SQLException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(ticket);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTicket(Ticket ticket) throws SQLException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(ticket);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> confirmTicket(T ticket) throws SQLException {
        List<T> ticketList = new ArrayList<T>();
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Ticket WHERE confirmTicket =:paramConfirmTicket");
            query.setParameter("paramConfirmTicket", ticket);
            ticketList = (List<T>) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticketList;
    }

    @Override
    public List<T> closeTicket(T ticket) throws SQLException {
        List<T> ticketList = new ArrayList<T>();
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Ticket WHERE closeTicket =:paramCloseTicket");
            query.setParameter("paramCloseTicket", ticket);
            ticketList = (List<T>) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticketList;
    }

    @Override
    public List<T> getTicketById(T ticket, String type) throws SQLException {
        List<T> ticketList = new ArrayList<T>();
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Ticket WHERE idTicket =:paramId");
            query.setParameter("paramId", ticket);
            ticketList = (List<T>) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticketList;
    }

    @Override
    public List<T> getTicketByOrganization(String type, String organization, T ticket) throws SQLException {
        List<T> ticketList = new ArrayList<T>();
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Ticket WHERE contragent =:paramContragent");
            query.setParameter("paramContragent", ticket);
            ticketList = (List<T>) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticketList;
    }
}


