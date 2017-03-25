
package com.HelpDesk.dao.implementations;

import com.HelpDesk.dao.entity.User;
import com.HelpDesk.dao.interfaces.UserDAO;
import com.HelpDesk.hibernateFactory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Maxim_Ozarovskiy on 26.08.2016.
 */

public class UserDAOImpl <U extends User> implements UserDAO<U> {

    @Override
    public void addUser(User user) {

        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateUser(User user) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<U> getUserByLogin (String login) {
        List<U> userList = new ArrayList<U>();
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM User WHERE login =:paramLogin");
            query.setParameter("paramLogin", login);
            userList = (List<U>) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    public List<U> getUserIdByLogin(U user, String login) {
        List<U> userList = new ArrayList<U>();
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("SELECT idUser FROM User WHERE login =:paramLogin");
            query.setParameter("paramLogin", login);
            userList = (List<U>) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    public List<U> getUserById(int idUser) {
        List<U> userList = new ArrayList<U>();
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM User WHERE idUser =:paramId");
            query.setParameter("paramId", idUser);
            userList = (List<U>) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }


   /* @Override
    public User getRoleId(int roleId) throws SQLException {
        User user = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM User WHERE roleId =:paramRoleId");
            query.setParameter("paramRoleId", roleId);
            user = (User) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }*/


    @Override
    public List<U> getUserOrgID(int userOrgId) throws SQLException {
        List<U> userList = new ArrayList<U>();
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM User WHERE userOrgId =:paramUserOrgId");
            query.setParameter("paramUserOrgId", userOrgId);
            userList = (List<U>) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void deleteUser(User user) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

