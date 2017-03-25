package com.HelpDesk.dao.interfaces;

import com.HelpDesk.dao.entity.User;

import java.sql.SQLException;
import java.util.List;


/*
 Created by Maxim_Ozarovskiy on 25.08.2016.
*/

public interface UserDAO <U extends User> {
    public void addUser(User user) throws SQLException;
    public void updateUser(User user) throws SQLException;
    public void deleteUser(User user) throws SQLException;
    public List<U> getUserByLogin(String login) throws SQLException;
    public List<U> getUserOrgID(int userOrgId) throws SQLException;
    public List<U> getUserIdByLogin(U User, String login) throws SQLException;
    public List<U> getUserById(int idUser)throws SQLException;



}
