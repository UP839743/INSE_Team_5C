package fdb;

/**
 *
 * @author INSE Team 5C
 */
public class PosHist {

    int clubID;
    String competition;
    int year;
    int position;

    /**
     * Constructor for position history
     *
     * @param db_clubID
     * @param db_competition
     * @param db_year
     * @param db_position
     */
    public PosHist(int db_clubID, String db_competition, int db_year, int db_position) {
        clubID = db_clubID;
        competition = db_competition;
        year = db_year;
        position = db_position;
    }

    //Getters
    /**
     * get the club ID of the position History record
     *
     * @return
     */
    public int getClubID() {
        return clubID;
    }

    /**
     * get the competition of the position history record
     *
     * @return competition
     */
    public String getCompetition() {
        return competition;
    }

    /**
     * get the year the season concludes in the position history record
     *
     * @return
     */
    public int getYear() {
        return year;
    }

    /**
     * get the position of the club in the position history record
     *
     * @return
     */
    public int getPosition() {
        return position;
    }
    
//No setters, data should never be altered
}
