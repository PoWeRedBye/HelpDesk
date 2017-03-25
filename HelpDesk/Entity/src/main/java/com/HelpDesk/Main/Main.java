package com.HelpDesk.Main;

import com.HelpDesk.dao.entity.CustomerType;
import com.HelpDesk.dao.entity.Organization;
import com.HelpDesk.dao.entity.User;
import com.HelpDesk.hibernateFactory.Factory;
import com.HelpDesk.hibernateFactory.HibernateSessionFactory;

import java.sql.SQLException;
import java.util.Set;


/**
 * Created by Maxim_Ozarovskiy on 20.02.2017.
 */
public class Main {
 /*   public static void main(String[] args)throws SQLException {
        HibernateSessionFactory.init();
        User user = new User();
        Organization org = new Organization();

        org.setOrganName("Global");
        org.setOrgAdress("global");
        org.setOrgNumber("1000");
        org.setOrganName("gobal");
        org.setUser(user);

        user.setFirstName("Admin");
        user.setLastName("Admin");
        user.setLogin("GlobalAdmin1");
        user.setPassword("12345qwerty");
        user.setCustomerType(CustomerType.administrator);
        user.setUserOrgId((Set<Organization>) org);
        try{
            Factory.getInstance().getUserDAO().addUser(user);
            Factory.getInstance().gerOrganizationDAO().addOrganization(org);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
