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
    int homeGoals;
    int awayGoals;

    /**
     * Constructor for Fixture
     *
     * @param match_ID
     * @param match_Date
     * @param match_HomeTeam
     * @param match_AwayTeam
     * @param match_HomeTeamScore
     * @param match_AwayTeamScore
     */
    public Fixture(int match_ID, Date match_Date, String match_HomeTeam,
            String match_AwayTeam, int match_HomeTeamScore, int match_AwayTeamScore) {
        matchID = match_ID;
        matchDate = match_Date;
        homeTeam = match_HomeTeam;
        awayTeam = match_AwayTeam;
        homeGoals = match_HomeTeamScore;
        awayGoals = match_AwayTeamScore;
    }

    //Getters
    /**
     * get the ID of the match
     *
     * @return matchID
     */
    public int getMatchID() {
        return matchID;
    }

    /**
     * get the date of the match
     *
     * @return matchDate
     */
    public Date getMatchDate() {
        return matchDate;
    }

    /**
     * get the home team name in the match
     *
     * @return the home team name
     */
    public String getHomeTeam() {
        return homeTeam;
    }

    /**
     * get the away team name in the match
     *
     * @return the away team name
     */
    public String getAwayTeam() {
        return awayTeam;
    }

    /**
     * get the home team score in the match
     *
     * @return the home team score
     */
    public int getHomeTeamScore() {
        return homeGoals;
    }

    /**
     * get the away team score in the match
     *
     * @return the away team score
     */
    public int getAwayTeamScore() {
        return awayGoals;
    }
    
    //No setters, data should never be altered
}
