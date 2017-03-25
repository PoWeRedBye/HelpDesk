package com.HelpDesk.Manager;

import java.sql.SQLException;

import java.util.Map;
import com.HelpDesk.dao.entity.User;
import com.HelpDesk.hibernateFactory.Factory;

/**
 * Created by Maxim_Ozarovskiy on 17.02.2017.
 */
public class LoginManager {

    public String[] loginController(Map<String, String[]> paramMap) throws Exception {
        String[] resultData = new String [2];
        String login = paramMap.get("login")[0];
        String password = paramMap.get("password")[0];
        User currentUser = null;
        try {
            currentUser = (User) Factory.getInstance().getUserDAO().getUserByLogin(login);
        }catch(SQLException e){
            System.err.println("Enable to connect");
            e.printStackTrace();
        }
        if(currentUser!=null){
            String tempPassword = currentUser.getPassword();
            if(password.equals(tempPassword)) {
                resultData[0] = currentUser.getFirstName();
                resultData[1] = String.valueOf(currentUser.getIdUser());
                return resultData;
            } throw new Exception();
        }else{
            throw new Exception();
        }

    }



}
