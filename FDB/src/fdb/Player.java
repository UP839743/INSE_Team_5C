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
    int seasonAssists;
    int cleanSheets;

    /**
     * Constructor for a player
     *
     * @param PlayerID
     * @param playerClubID
     * @param playerFirstName
     * @param playerLastName
     * @param playerSquadNumber
     * @param playerPosition
     * @param playerHeight
     * @param playerPrefFoot
     * @param playerDoB
     * @param playerClubApps
     * @param playerSeasonApps
     * @param playerNationality
     * @param playerClubGoals
     * @param playerSeasonGoals
     * @param playerSeasonAssists
     * @param playerCleanSheets
     */
    public Player(int PlayerID, int playerClubID, String playerFirstName,
            String playerLastName, int playerSquadNumber, String playerPosition,
            String playerHeight, String playerPrefFoot, Date playerDoB, int playerClubApps,
            int playerSeasonApps, String playerNationality, int playerClubGoals,
            int playerSeasonGoals, int playerSeasonAssists, int playerCleanSheets) {
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
        seasonAssists = playerSeasonAssists;
        cleanSheets = playerCleanSheets;
    }

    //Getters
    /**
     * get the player ID of the player
     *
     * @return playerID
     */
    public int getPlayerID() {
        return playerID;
    }

    /**
     * get the club ID of the player
     *
     * @return clubID
     */
    public int getclubID() {
        return clubID;
    }

    /**
     * get the first name of the player
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * get the last name of the player
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * get the squad number of the player
     *
     * @return squadNumber
     */
    public int getSquadNumber() {
        return squadNumber;
    }

    /**
     * get the position of the player
     *
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     * get the height of the player
     *
     * @return height
     */
    public String getHeight() {
        return height;
    }

    /**
     * get the preferred foot of the player
     *
     * @return prefFoot
     */
    public String getPrefFoot() {
        return prefFoot;
    }

    /**
     * get the date of birth of the player
     *
     * @return DoB
     */
    public Date getDoB() {
        return DoB;
    }

    /**
     * get the club appearances by a player
     *
     * @return clubApps
     */
    public int getClubApps() {
        return clubApps;
    }

    /**
     * get the season appearances by a player
     * @return seasonApps
     */
    public int getSeasonApps() {
        return seasonApps;
    }

    /**
     * get the nationality of the player
     * @return nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * get the club goals by a player
     * @return clubGoals     
     */
    public int getClubGoals() {
        return clubGoals;
    }

    /**
     * get the season goals of a player
     * @return seasonGoals
     */
    public int getSeasonGoals() {
        return seasonGoals;
    }

    /**
     * get the season assists of a player
     * @return seasonAssists
     */
    public int getSeasonAssists() {
        return seasonAssists;
    }

    /**
     * get the cleanSheets of a player
     * @return cleanSheets
     */
    public int getCleanSheets() {
        return cleanSheets;
    }
}
