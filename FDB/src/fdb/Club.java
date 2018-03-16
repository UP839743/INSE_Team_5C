package fdb;

/**
 *
 * @author INSE Team 5C
 */
public class Club {

    int clubID;
    String clubName;
    String clubStadium;
    int clubPosition;

    /**
     * Constructor for club
     *
     * @param club_ID
     * @param club_Name
     * @param club_Stadium
     * @param club_Position
     */
    public Club(int club_ID, String club_Name,
            String club_Stadium, int club_Position) {
        clubID = club_ID;
        clubName = club_Name;
        clubStadium = club_Stadium;
        clubPosition = club_Position;
    }

    //Getters
    /**
     * get the Id of the Club
     *
     * @return ClubID
     */
    public int getClubID() {
        return clubID;
    }

    /**
     * get the name of the Club
     *
     * @return clubName
     */
    public String getClubName() {
        return clubName;
    }

    /**
     * get the Stadium name of the Club
     *
     * @return clubStadium
     */
    public String getClubStadium() {
        return clubStadium;
    }

    /**
     * get the Position of the Club
     *
     * @return clubPosition
     */
    public int getClubPosititon() {
        return clubPosition;
    }

    //No setters, data should never be altered
}
