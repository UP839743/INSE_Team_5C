/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

/**
 *
 * @author accou
 */
public class Stadium {
    String Name;
    int clubID;
    String address;
    String postcode;
    int capacity;
    String dateBuilt;
    
    public Stadium(String stadName, int stadClubID, String stadAddress, String stadPostcode, int stadCapacity, String stadDateBuilt) 
    {
    Name = stadName;
    clubID = stadClubID;
    address = stadAddress;
    postcode = stadPostcode;
    capacity = stadCapacity;
    dateBuilt = stadDateBuilt;
    }
   
    public String getName() {
        return Name;
    }
    
    public int getClubID() {
        return clubID;
    }
    
    public String getAddress() {
    return address;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public String getDateBuilt() {
        return dateBuilt;
    }
}
