/*
package com.HelpDesk.dao.implementations;

import com.HelpDesk.dao.interfaces.CommonDAO;
import com.HelpDesk.hibernateFactory.HibernateSessionFactory;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by Maxim_Ozarovskiy on 05.03.2017.
 *//*

public class CommonDaoImpl<T> implements CommonDAO<T> {

    public void addObject(T object) throws SQLException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateObject(T object) throws SQLException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteObject(T object) throws SQLException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public T getObjectById(int id, Class<T> currentClass) throws SQLException {
        T object = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            session.beginTransaction();
            object = session.load(currentClass, id);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    public List<T> getAllObjects(Class<T> currentClass) throws SQLException {
        Session session = null;
        List<T> listOfObj = new ArrayList<>();
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            listOfObj = (ArrayList<T>) session.createCriteria(currentClass).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return listOfObj;

    }
}
*/
