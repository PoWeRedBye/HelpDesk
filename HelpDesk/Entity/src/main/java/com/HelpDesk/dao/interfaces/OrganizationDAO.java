package com.HelpDesk.dao.interfaces;

import com.HelpDesk.dao.entity.Organization;
import com.HelpDesk.dao.entity.User;

import java.sql.SQLException;
import java.util.List;

/*
 Created by Maxim_Ozarovskiy on 13.02.2017.

*/

public interface OrganizationDAO <O extends Organization> {
    public void addOrganization(Organization Organization) throws SQLException;
    public void updateOrganization(Organization Organization) throws SQLException;
    public void deleteOrganization(Organization Organization) throws SQLException;

    public List<O> getOgrUsers(int idUser) throws SQLException;
    public List<O> getIdOrganization(int idOrg) throws SQLException;
    public List<O> getOrganizationByName(Organization organization, String type) throws SQLException;




}
