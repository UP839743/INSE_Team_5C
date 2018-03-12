/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

/**
 *
 * @author INSE Team 5C
 */
public class Club {
    int clubID;
    String clubName;
    String stadium;
    int clubPosititon;
    
    public Club(int club_ID, String club_Name, 
            String clubStadium, int club_Posititon)
    {
    clubID = club_ID;
    clubName = club_Name;
    stadium = clubStadium;
    clubPosititon = club_Posititon;
    }

    //Getters
    public int getClubID() {
        return clubID;
    }
    
    public String getClubName() {
        return clubName;
    }
    
    public String getClubStadium() {
        return stadium;
    }

    public int getClubPosititon() {
        return clubPosititon;
    }
}