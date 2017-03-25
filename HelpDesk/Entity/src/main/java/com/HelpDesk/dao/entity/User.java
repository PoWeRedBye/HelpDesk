package com.HelpDesk.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * Created by Maxim_Ozarovskiy on 03.02.2017.
 */

@Entity
@Table(name = "User")
public class User {

    public User(String login, String password, String firstName, String lastName, Set<Organization> userOrgId, Set<Ticket> ticketByUser, CustomerType customerType) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userOrgId = userOrgId;
        this.ticketByUser = ticketByUser;
        this.customerType = customerType;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "idUser")
    private int idUser;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Column(name = "customerType")
    private CustomerType customerType;


    @OneToMany
    @JoinColumn(name = "idOrganizations")
    private Set<Organization> userOrgId;


    @OneToMany
    @JoinColumn(name = "idTicket")
    private Set<Ticket> ticketByUser;


    public User() {
    }

    public Set<Ticket> getTicketByUser() {
        return ticketByUser;
    }

    public void setTicketByUser(Set<Ticket> ticketByUser) {
        this.ticketByUser = ticketByUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Organization> getUserOrgId(Organization userOrgId) {
        return this.userOrgId;
    }

    public void setUserOrgId(Set<Organization> userOrgId) {
        this.userOrgId = userOrgId;
    }

}
