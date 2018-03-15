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
public class Trophy {
    String competition;
    int year;
    int ClubId;
    
    public Trophy(String troCompetition, int troYear, int troClubId) 
    {
        competition = troCompetition;
        year = troYear;
        ClubId = troClubId;
    }
    
    public String getCompetition() {
        return competition;
    }
    
    public int getYear() {
        return year;
    }
    

    public int getClubId() {
        return ClubId;
    }
    
}
