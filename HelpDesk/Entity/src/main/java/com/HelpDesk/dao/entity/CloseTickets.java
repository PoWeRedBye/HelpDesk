package com.HelpDesk.dao.entity;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 * Created by Maxim_Ozarovskiy on 20.02.2017.
 */
@Entity
@Table(name = "CloseTickets")
public class CloseTickets extends Ticket {

    private User user;

    public CloseTickets(String type, Date date, String category, String description, User userTicket, User user) {
        super(type, date, category, description, userTicket);
        this.user = user;
    }

    public CloseTickets() {
    }



    @ManyToOne
    @JoinColumn(name = "idUser")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
