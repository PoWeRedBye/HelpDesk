package com.HelpDesk.dao.interfaces;

import com.HelpDesk.dao.entity.Ticket;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Maxim_Ozarovskiy on 12.02.2017.
 * */

public interface TicketDAO <T extends Ticket> {
    public void addTicket(Ticket ticket) throws SQLException;
    public void deleteTicket(Ticket ticket) throws SQLException;
    public void updateTicket(Ticket ticket) throws SQLException;
    public List<T> confirmTicket(T ticket) throws SQLException;
    public List<T> closeTicket (T ticket) throws SQLException;
    public List<T> getTicketById(T ticket, String type) throws SQLException;
    public List<T> getTicketByOrganization(String type, String Organization, T ticket) throws SQLException;

}
