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
public class Player { 
    int playerID;
    int clubID;
    String firstName;
    String lastName;
    int squadNumber;
    String position;
    String height;
    String prefFoot;
    Date DoB;
    int clubApps;
    int seasonApps;
    String nationality;
    int clubGoals;
    int seasonGoals;
    int cleanSheets;
    
    public Player(int PlayerID, int playerClubID, String playerFirstName, 
            String playerLastName, int playerSquadNumber, String playerPosition, 
            String playerHeight, String playerPrefFoot, Date playerDoB, int playerClubApps, 
            int playerSeasonApps, String playerNationality, int playerClubGoals, 
            int playerSeasonGoals, int playerCleanSheets) 
    {
        playerID = PlayerID;
        clubID = playerClubID;
        firstName = playerFirstName;
        lastName = playerLastName;
        squadNumber = playerSquadNumber;
        position = playerPosition;
        height = playerHeight;
        prefFoot = playerPrefFoot;
        DoB = playerDoB;
        clubApps = playerClubApps;
        seasonApps = playerSeasonApps;
        nationality = playerNationality;
        clubGoals = playerClubGoals;
        seasonGoals = playerSeasonGoals;
        cleanSheets = playerCleanSheets;
    }

    //Getters
    public int getPlayerID() {
        return playerID;
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
    
    public int getSquadNumber() {
    return squadNumber;
    }

    public String getPosition() {
        return position;
    }
    
    public String getHeight() {
        return height;
    }
    
    public String getPrefFoot() {
        return prefFoot;
    }
    
    public Date getDoB() {
        return DoB;
    }
    
    public int getClubApps() {
        return clubApps;
    }

    public int getSeasonApps() {
        return seasonApps;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public int getClubGoals() {
        return clubGoals;
    }
    
    public int getseasonGoals() {
        return seasonGoals;
    }
    
    public int getcleanSheets() {
        return cleanSheets;
    }
}
