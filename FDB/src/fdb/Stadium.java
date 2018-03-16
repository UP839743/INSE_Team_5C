package fdb;

import java.sql.Date;

/**
 *
 * @author INSE Team 5C
 */
public class Stadium {
    String Name;
    int clubID;
    String address;
    String postcode;
    int capacity;
    Date dateBuilt;
    
    /**
     * Constructor for a stadium
     * @param stadName
     * @param stadClubID
     * @param stadAddress
     * @param stadPostcode
     * @param stadCapacity
     * @param stadDateBuilt 
     */
    public Stadium(String stadName, int stadClubID, String stadAddress, String stadPostcode, int stadCapacity, Date stadDateBuilt) 
    {
    Name = stadName;
    clubID = stadClubID;
    address = stadAddress;
    postcode = stadPostcode;
    capacity = stadCapacity;
    dateBuilt = stadDateBuilt;
    }
   
    /**
     * get the name of the stadium
     * @return name
     */
    public String getName() {
        return Name;
    }
    
    /**
     * get ClubID of the Stadium
     * @return ClubID
     */
    public int getClubID() {
        return clubID;
    }
    
    /**
     * get address of the stadium
     * @return address
     */
    public String getAddress() {
    return address;
    }
    
    /**
     * get the postcode of the stadium
     * @return postcode
     */
    public String getPostcode() {
    return postcode;
    }
    
    /**
     * get the capacity of the stadium
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }
    
    /**
     * get the date the stadium was built
     * @return 
     */
    public Date getDateBuilt() {
        return dateBuilt;
    }
    
    //No setters, data should never be altered
}
