/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

import java.sql.Date;

/**
 *
 * @author INSE Team 5C
 */
public class Manager {
    int managerID;
    int clubID;
    String firstName;
    String lastName;
    Date DoB;
    String joinedClub;
    String nationality;
    
    public Manager(int manager_ID, int managerClubID, String managerFirstName, 
            String managerLastName, Date managerDoB, String managerJoinedClub, String managerNationality) 
    {
        managerID = manager_ID;
        clubID = managerClubID;
        firstName = managerFirstName;
        lastName = managerLastName;
        DoB = managerDoB;
        joinedClub = managerJoinedClub;
        nationality = managerNationality;
    }

    //Getters
    public int getManagerID() {
        return managerID;
    }
    
    public int getclubID() {
        return clubID;
    }
    
    public String getfirstName() {
        return firstName;
    }

    public String getLastName() {
    return lastName;
    }
    
    public Date getDoB() {
        return DoB;
    }
    
    public String getJoinedClub() {
        return joinedClub;
    }

    public String getNationality() {
        return nationality;
    }
}
