package com.HelpDesk.controller;

import com.HelpDesk.dao.entity.Organization;
import com.HelpDesk.hibernateFactory.Factory;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Maxim_Ozarovskiy on 21.03.2017.
 */
public class OrganizationAddServlet extends APIHandlerServlet.APIRequestHandler {

    public static final OrganizationAddServlet instance = new OrganizationAddServlet();


    public static OrganizationAddServlet getInstance() {
        return instance;
    }

    private OrganizationAddServlet() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        String organName = request.getParameter("organName");
        String orgAdress = request.getParameter("orgAdress");
        String orgNumber = request.getParameter("orgNumber");
        String departName =request.getParameter("departName");

        Organization organization = new Organization();
        organization.setOrganName(organName);
        organization.setOrgAdress(orgAdress);
        organization.setOrgNumber(orgNumber);
        organization.setDepartName(departName);


        Factory.getInstance().gerOrganizationDAO().addOrganization(organization);
        System.out.println("name: " + organName  + "; adress: " + orgAdress + "; number: "+ orgNumber + "; depart: "+ departName);
        return null;
    }
}
