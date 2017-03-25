
package com.HelpDesk.dao.implementations;

import com.HelpDesk.dao.entity.Organization;
import com.HelpDesk.dao.entity.User;
import com.HelpDesk.dao.interfaces.OrganizationDAO;
import com.HelpDesk.hibernateFactory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Maxim_Ozarovskiy on 13.02.2017.
 */

public class OrganizationDAOImpl <O extends Organization> implements OrganizationDAO<O>{

    @Override
    public void addOrganization(Organization organization){
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(organization);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteOrganization(Organization organization){
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(organization);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void updateOrganization(Organization organization){
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(organization);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<O> getIdOrganization(int idOrg) throws SQLException {
        List<O> organizationList = new ArrayList<O>();
            try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Organization WHERE idOrganization =:paramId");
            query.setParameter("paramId", idOrg);
            organizationList = (List<O>) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return organizationList;
    }

    @Override
    public List<O> getOrganizationByName(Organization organization, String type) throws SQLException {
        List<O> organizationList = new ArrayList<O>();
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Organization WHERE organName =:paramOrganName");
            query.setParameter("paramOrganName", organization);
            organizationList = (List<O>) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return organizationList;
    }

    @Override
    public List<O> getOgrUsers(int idUser) throws SQLException {
        List<O> organizationList = new ArrayList<O>();
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Organization WHERE user =:paramUser");
            query.setParameter("paramUser", idUser);
            organizationList = (List<O>) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return organizationList;
    }
}

