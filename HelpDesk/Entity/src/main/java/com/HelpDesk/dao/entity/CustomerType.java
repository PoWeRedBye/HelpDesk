package com.HelpDesk.dao.entity;



/**
 * Created by Maxim_Ozarovskiy on 09.02.2017.
 */
public enum CustomerType {
    client, itManagerClient, administrator, serviceManager, serviceEngineer, clientViewer;
    CustomerType(){

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
