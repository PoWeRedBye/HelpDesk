package com.HelpDesk.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Maxim_Ozarovskiy on 09.02.2017.
 */

@Entity
@Table(name = "Ticket")
public class Ticket {


    @Column(name = "Type")
    private String type;
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "idTicket")
    private Integer idTicket;
    @Column(name = "TicketCategory")
    private String ticketCategory;
    @Column(name = "Description")
    private String description;
    @Column(name = "CurrentDate")
    private Date currentDate;
    @Column(name = "ConfirmTicket")
    private boolean confirmTicket;
    @Column(name = "CloseTicket")
    private boolean closeTicket;


    @ManyToOne
    @JoinColumn(name = "idOrganizations")
    private Organization contragent;


    @ManyToOne
    @JoinColumn(name = "idUser")
    private User userTicket;

    public User getUserTicket() {
        return userTicket;
    }

    public void setUserTicket(User userTicket) {
        this.userTicket = userTicket;
    }


    public Ticket() {
    }

    public Ticket(String type, Date date, String category, String description, User userTicket) {
        super();
        this.type = type;
        this.currentDate = date;
        this.ticketCategory = category;
        this.description = description;
        this.userTicket = userTicket;


    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public String getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(String ticketCategory) {
        this.ticketCategory = ticketCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public boolean isConfirmTicket() {
        return confirmTicket;
    }

    public void setConfirmTicket(boolean confirmTicket) {
        this.confirmTicket = confirmTicket;
    }

    public boolean isCloseTicket() {
        return closeTicket;
    }

    public void setCloseTicket(boolean closeTicket) {
        this.closeTicket = closeTicket;
    }

    public Organization getContragent() {
        return contragent;
    }

    public void setContragent(Organization contragent) {
        this.contragent = contragent;
    }
}
