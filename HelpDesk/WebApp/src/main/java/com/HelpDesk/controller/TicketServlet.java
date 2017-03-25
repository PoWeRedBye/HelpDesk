package com.HelpDesk.controller;


import com.HelpDesk.Manager.TicketManager;
import com.HelpDesk.dao.entity.Organization;
import com.HelpDesk.dao.entity.Ticket;
import com.HelpDesk.dao.entity.User;
import com.HelpDesk.dao.interfaces.UserDAO;
import com.HelpDesk.hibernateFactory.Factory;
import org.hibernate.mapping.Value;
import org.hibernate.sql.Select;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.persistence.Id;
import javax.persistence.Index;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Created by Maxim_Ozarovskiyon 20.02.2017.
 */

public class TicketServlet extends APIHandlerServlet.APIRequestHandler {

    public static final TicketServlet instance = new TicketServlet();

    public static TicketServlet getInstance() {
        return instance;
    }

    private TicketServlet() {
    }


    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        Map<String, String[]> map = request.getParameterMap();
        String type = map.get("type")[0];
        // Map<String, String> dataFromDb = new HashMap<>();
        JSONObject jsonObject = new JSONObject();
        switch (type) {
            case "add_ticket":
                jsonObject = addticket(map);
                break;
            case "":
                break;

        }

        return jsonObject;

    }

    private JSONObject addticket(Map<String, String[]> map) {
        JSONObject jsonObject = new JSONObject();

        String[] dbFunctionResponce = new String[2];
        try {
            TicketManager.getTicketManager().addTicket(map);
        } catch (Exception e) {
            jsonObject.put("State", "Error! Can't add ticket!!!");
            return jsonObject;
        }
        jsonObject.put("State", "The ticket was added!!!");
        return jsonObject;
    }
}