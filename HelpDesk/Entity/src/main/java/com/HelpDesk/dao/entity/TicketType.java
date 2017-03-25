package com.HelpDesk.dao.entity;

/**
 * Created by Maxim_Ozarovskiy on 20.02.2017.
 */
public enum TicketType {
    OPEN("OpenTickets"),
    CLOSED("CloseTickets");

    private String description;

    private TicketType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
