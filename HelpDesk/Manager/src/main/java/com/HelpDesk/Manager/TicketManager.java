package com.HelpDesk.Manager;

import com.HelpDesk.dao.entity.CloseTickets;
import com.HelpDesk.dao.entity.Organization;
import com.HelpDesk.dao.entity.Ticket;
import com.HelpDesk.dao.entity.User;
import com.HelpDesk.hibernateFactory.Factory;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;

import static com.HelpDesk.dao.entity.TicketType.CLOSED;

/**
 * Created by Maxim_Ozarovskiy on 17.02.2017.
 */
public class TicketManager {

    //надо все таки делать деления от тикета, на исходящие и приходящие(либо на активные и закрытые хз короче)!!!

    private static TicketManager instanse = null;

    public static TicketManager getTicketManager() {
        if (instanse == null) {
            instanse = new TicketManager();
        }
        return instanse;
    }


    public void addTicket(Map<String, String[]> mapParam) throws Exception {

        int idUser = Integer.parseInt(mapParam.get("index")[0]);
        int idOrg = Integer.parseInt(mapParam.get("index")[0]);
        User currentUser = null;
        Organization currentOrg = null;
        try {
            currentOrg = (Organization) Factory.getInstance().gerOrganizationDAO().getIdOrganization(idOrg);
            currentUser = (User) Factory.getInstance().getUserDAO().getUserById(idUser);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can't Find user!");
            throw new Exception();

        }



        String type = mapParam.get("Type")[0];
        String dateStr = mapParam.get("date")[0];
        String category = mapParam.get("category")[0];
        String description = mapParam.get("description")[0];
        Boolean confirm = Boolean.valueOf(mapParam.get("confirm")[0]);
        Boolean close = Boolean.valueOf(mapParam.get("close")[0]);

        Ticket ticket = new Ticket();

        Date date = Date.valueOf(dateStr);
        ticket.setType(type);
        ticket.setCurrentDate(date);
        ticket.setTicketCategory(category);
        ticket.setDescription(description);
        ticket.setConfirmTicket(confirm);
        ticket.setCloseTicket(close);

        ticket.setContragent(currentOrg);
        ticket.setUserTicket(currentUser);




        if (type.equals(CLOSED.getDescription())) {
            CloseTickets closeTickets = (CloseTickets) ticket;
            addCloseTicket(closeTickets, currentUser);
            System.out.println("create Ticket");
        } else {
            CloseTickets incomeTicket = new CloseTickets();
            addIncomeTicket(incomeTicket, currentUser);
            System.out.println("create Ticket2");
        }
        System.out.println("work");
    }

    private void addCloseTicket(CloseTickets closeTickets, User currentUser) throws Exception {
        closeTickets.setUser(currentUser);
        try {
            System.out.println("get factory");
            Factory.getInstance().getTicketDAO().addTicket(closeTickets);

        } catch (SQLException e) {
            System.out.println("Enable to add Ticket");
            e.printStackTrace();
            throw new Exception();

        }
    }

    private void addIncomeTicket(Ticket incomeTicket, User currentUser) throws Exception {

        incomeTicket.setUserTicket(currentUser);
        try {
            System.out.println("get factory");
            Factory.getInstance().getTicketDAO().addTicket(incomeTicket);

        } catch (SQLException e) {
            System.out.println("Enable to add Ticket");
            e.printStackTrace();
            throw new Exception();

        }
    }
}







