package com.HelpDesk.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Maxim_Ozarovskiy on 12.02.2017.
 */
@Entity
@Table(name = "Organizations")
public class Organization {


    public Organization(int idOrganization, String organName, String orgAdress, String orgNumber, String departName/*, User user*/) {
        this.idOrganization = idOrganization;
        this.organName = organName;
        this.orgAdress = orgAdress;
        this.orgNumber = orgNumber;
        this.departName = departName;
        //this.user = user;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "idOrganizations")
    private int idOrganization;
    @Column(name = "organName")
    private String organName;
    @Column(name = "OrgAdress")
    private String orgAdress;
    @Column(name = "OrgNumber")
    private String orgNumber;
    @Column(name = "DepartamentName")
    private String departName;


    @OneToMany
    @JoinColumn(name = "idTicket")
    private Set<Ticket> OrgTicket;


    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;


    public Organization() {
    }


    public int getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(int idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getOrgAdress() {
        return orgAdress;
    }

    public void setOrgAdress(String orgAdress) {
        this.orgAdress = orgAdress;
    }

    public String getOrgNumber() {
        return orgNumber;
    }

    public void setOrgNumber(String orgNumber) {
        this.orgNumber = orgNumber;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Ticket> getOrgTicket() {
        return OrgTicket;
    }

    public void setOrgTicket(Set<Ticket> orgTicket) {
        OrgTicket = orgTicket;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (idOrganization != that.idOrganization) return false;
        if (organName != null ? !organName.equals(that.organName) : that.organName != null) return false;
        if (orgAdress != null ? !orgAdress.equals(that.orgAdress) : that.orgAdress != null) return false;
        if (orgNumber != null ? !orgNumber.equals(that.orgNumber) : that.orgNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOrganization;
        result = 31 * result + (organName != null ? organName.hashCode() : 0);
        result = 31 * result + (orgAdress != null ? orgAdress.hashCode() : 0);
        result = 31 * result + (orgNumber != null ? orgNumber.hashCode() : 0);
        return result;
    }


}
