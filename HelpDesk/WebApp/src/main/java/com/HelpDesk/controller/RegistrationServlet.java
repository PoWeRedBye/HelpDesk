package com.HelpDesk.controller;

import com.HelpDesk.dao.entity.CustomerType;
import com.HelpDesk.dao.entity.User;
import com.HelpDesk.hibernateFactory.Factory;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Maxim_Ozarovskiy on 20.02.2017.
 */
public class RegistrationServlet extends APIHandlerServlet.APIRequestHandler {

    public static final RegistrationServlet instance = new RegistrationServlet();


    public static RegistrationServlet getInstance() {
        return instance;
    }

    private RegistrationServlet() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName =request.getParameter("lastName");
        //String CustomerType = request.getParameter("customertype");

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setCustomerType(CustomerType.client);


        Factory.getInstance().getUserDAO().addUser(user);
        System.out.println("login: " + login  + "; password: " + password + "; First Name: "+ firstName + "; Last Name: "+ lastName/* + "; Customer Type: "+ CustomerType*/);
        return null;
    }
}

