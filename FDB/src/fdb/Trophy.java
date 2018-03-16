package fdb;

/**
 *
 * @author INSE Team 5C
 */
public class Trophy {

    String competition;
    int year;
    int ClubId;

    /**
     *
     * @param tro_Competition
     * @param tro_Year
     * @param tro_ClubId
     */
    public Trophy(String tro_Competition, int tro_Year, int tro_ClubId) {
        competition = tro_Competition;
        year = tro_Year;
        ClubId = tro_ClubId;
    }

    /**
     * get the competition the trophy belongs to
     *
     * @return competition
     */
    public String getCompetition() {
        return competition;
    }

    /**
     * get the year the trophy was won
     *
     * @return
     */
    public int getYear() {
        return year;
    }

    /**
     * get the clubID the trophy belongs to
     *
     * @return
     */
    public int getClubId() {
        return ClubId;
    }
    //No setters, data should never be altered
}
