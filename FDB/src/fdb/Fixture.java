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
public class Fixture {
    int matchID;
    Date matchDate;
    String homeTeam;
    String awayTeam;
    int homeScore;
    int awayScore;
    
    public Fixture(int match_ID, Date match_Date, String matchHomeTeam, 
            String matchAwayTeam, int matchHomeTeamScore, int matchAwayTeamScore)
    {
    matchID = match_ID;
    matchDate = match_Date;
    homeTeam = matchHomeTeam;
    awayTeam = matchAwayTeam;
    homeScore = matchHomeTeamScore;
    awayScore = matchAwayTeamScore;
    }

    //Getters
    public int getMatchID() {
        return matchID;
    }
    
    public Date getMatchDate() {
        return matchDate;
    }
    
    public String getHomeTeam() {
        return homeTeam;
    }
    
    public String getAwayTeam() {
        return awayTeam;
    }
    
    public int getHomeTeamScore() {
        return homeScore;
    }
    
    public int getAwayTeamScore() {
        return awayScore;
    }
}
