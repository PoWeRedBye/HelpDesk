package com.HelpDesk.hibernateFactory;


import com.HelpDesk.dao.entity.Organization;
import com.HelpDesk.dao.entity.Ticket;
import com.HelpDesk.dao.entity.User;
import com.HelpDesk.dao.implementations.OrganizationDAOImpl;
import com.HelpDesk.dao.implementations.TicketDAOImpl;
import com.HelpDesk.dao.implementations.UserDAOImpl;
import com.HelpDesk.dao.interfaces.OrganizationDAO;
import com.HelpDesk.dao.interfaces.TicketDAO;
import com.HelpDesk.dao.interfaces.UserDAO;
/*import com.HelpDesk.dao.implementations.CommonDaoImpl;
import com.HelpDesk.dao.implementations.OrganizationDAOImpl;
import com.HelpDesk.dao.implementations.TicketDAOImpl;
import com.HelpDesk.dao.implementations.UserDAOImpl;
import com.HelpDesk.dao.interfaces.OrganizationDAO;
import com.HelpDesk.dao.interfaces.TicketDAO;
import com.HelpDesk.dao.interfaces.UserDAO;*/

/**
 * Created by Maxim_Ozarovskiy on 27.08.2016.
 */
public class Factory {
/*

    private static Factory instance = null;
    private static CommonDaoImpl<User> userDAO = null;
    private static CommonDaoImpl<Ticket> ticketDAO = null;
    private static CommonDaoImpl<Organization> organizationDAO = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public static CommonDaoImpl<User> getUserDAO() {
        if (userDAO == null) {
            userDAO = new CommonDaoImpl<>();
        }
        return userDAO;
    }

    public static CommonDaoImpl<Ticket> getTicketDAO() {
        if (ticketDAO == null) {
            ticketDAO = new CommonDaoImpl<>();
        }
        return ticketDAO;
    }

    public static CommonDaoImpl<Organization> getOrganizationDAO() {
        if (organizationDAO == null) {
            organizationDAO = new CommonDaoImpl<>();
        }
        return organizationDAO;
    }
*/



    private static UserDAO userDAO = null;
    private static TicketDAO ticketDAO = null;
    private static OrganizationDAO organizationDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public UserDAO<User> getUserDAO() {
        if (userDAO == null) {
            userDAO = new UserDAOImpl();
        }
        return userDAO;
    }


    public TicketDAO<Ticket> getTicketDAO() {
        if (ticketDAO == null) {
            ticketDAO = new TicketDAOImpl();
        }
        return ticketDAO;
    }

    public OrganizationDAO<Organization> gerOrganizationDAO(){
        if(organizationDAO == null){
            organizationDAO = new OrganizationDAOImpl();
        }
        return organizationDAO;
    }
}