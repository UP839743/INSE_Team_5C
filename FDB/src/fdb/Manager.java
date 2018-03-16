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

    /**
     * Constructor for manager
     * @param manager_ID
     * @param manager_ClubID
     * @param manager_FirstName
     * @param manager_LastName
     * @param manager_DoB
     * @param manager_JoinedClub
     * @param manager_Nationality 
     */
    public Manager(int manager_ID, int manager_ClubID, String manager_FirstName, 
            String manager_LastName, Date manager_DoB, String manager_JoinedClub, String manager_Nationality) 
    {
        managerID = manager_ID;
        clubID = manager_ClubID;
        firstName = manager_FirstName;
        lastName = manager_LastName;
        DoB = manager_DoB;
        joinedClub = manager_JoinedClub;
        nationality = manager_Nationality;
    }

    //Getters
    /**
     * get the ID of the manager
     * @return managerID
     */
    public int getManagerID() {
        return managerID;
    }
    
    /**
     * get the ID of the club the manager is working for
     * @return clubID
     */
    public int getclubID() {
        return clubID;
    }
    
    /**
     * get the first name of the manager 
     * @return firstName
     */
    public String getfirstName() {
        return firstName;
    }
    
    /**
     * get the ID of the manager
     * @return managerID
     */
    public String getLastName() {
    return lastName;
    }
    
    /**
     * get the date of birth of the manager
     * @return DoB
     */
    public Date getDoB() {
        return DoB;
    }
    
    /**
     * get the date the manager joined the club
     * @return 
     */
    public String getJoinedClub() {
        return joinedClub;
    }

    /**
     * get the nationality of the manager
     * @return nationality
     */
    public String getNationality() {
        return nationality;
    }
    
    //No setters, data should never be altered
}
