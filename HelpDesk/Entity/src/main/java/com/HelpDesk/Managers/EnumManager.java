package com.HelpDesk.Managers;

import com.HelpDesk.dao.entity.TicketType;
import com.HelpDesk.dao.entity.CustomerType;

/**
 * Created by Maxim_Ozarovskiy on 20.02.2017.
 */
public class EnumManager {
    public String getTicketType(TicketType type) {
        String ticketType = null;
        switch (type) {
            case OPEN:
                ticketType = "com.HelpDesk.dao.entity.OpenTickets";
                break;
            case CLOSED:
                ticketType = "com.HelpDesk.dao.entity.CloseTickets";
                break;
            default:
                ticketType = "com.HelpDesk.dao.entity.OpenTickets";
                break;
        }
        return ticketType;
    }
    public String getCustomerType(CustomerType type) {
    String customerType = null;
        switch (type){
            case client:
                customerType = "";
                break;
            case itManagerClient:
                customerType = "";
                break;
            case administrator:
                customerType ="";
                break;
            case serviceManager:
                customerType = "";
                break;
            case serviceEngineer:
                customerType = "";
                break;
            case clientViewer:
                customerType ="";
                break;
        }
        return customerType;
    }
}
