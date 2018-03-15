/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

import static fdb.FXMLDocumentController.scene;
import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author INSE Team 5C
 */
public class FDB extends Application {
    public void start(Stage stage) throws Exception {       
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));       
        if (teamString.equals("Arsenal")) {
            root.getStylesheets().add(getClass().getResource("css/Arsenal.css").toExternalForm());
        }
        else if (teamString.equals("Chelsea")) {
            root.getStylesheets().add(getClass().getResource("css/Chelsea.css").toExternalForm());
        }
        else if (teamString.equals("Tottenham")) {
            root.getStylesheets().add(getClass().getResource("css/Tottenham.css").toExternalForm());
        }
              else if (teamString.equals("Man City")) {
            root.getStylesheets().add(getClass().getResource("css/Man City.css").toExternalForm());
                  }       
        Scene scene = new Scene(root);
        stage.setMaxHeight(1000);
        stage.setMaxWidth(1400);
        stage.setMinHeight(1000);
        stage.setMinWidth(1400);
        stage.setScene(scene);
        stage.show();
    }

    static String teamString = "";
    static ArrayList<Player> allPlayers = new ArrayList();
    static ArrayList<Manager> allManagers = new ArrayList();
    static ArrayList<Fixture> allFixtures = new ArrayList();
    static ArrayList<Club> allClubs = new ArrayList();
    static ArrayList<News> allNews = new ArrayList();
    static ArrayList<Trophy> allTrophies = new ArrayList();
    static ArrayList<Stadium> allStadiums = new ArrayList();
    static ArrayList<PosHist> AllposHists = new ArrayList();

    public static int teamStringToID(String teamName) {
        int teamID = 0;
        switch (teamName) {
            case "Arsenal":
                teamID = 1;
                break;
            case "Chelsea":
                teamID = 2;
                break;
            case "Tottenham":
                teamID = 3;
                break;
            case "Man City":
                teamID = 4;
                break;
            default:
                break;
        }
        return teamID;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        

        //Connect to Database
        Connection con = initDatabase();
        //Load in objects
        if (con != null) {
            ArrayList<Player> teamString = new ArrayList();
            loadPlayers(con);
            loadManagers(con);
            loadFixtures(con);
            loadClubs(con);
            loadNews(con);
            loadTrophies(con);
            loadStadiums(con);
            loadPosHistory(con);
            System.out.println("DB Cached...");
            
            
            //Pre GUI imp tests
            int positition = populatePosition("16/17", 3);
            int positition2 = populatePosition("17/18", 3);
            String news = populateNews(3);
            ArrayList<Fixture> chelseaResults = populateResults("Chelsea", "16/17");
            ArrayList<Fixture> chelseaFixtures = populateFixtures("Chelsea");
            ArrayList<Trophy> trophyCabinet = populateTrophies(1);
            //tests as follows 1-SquadNo 2- LastName 3-Position 4-Nationality 5-PrefFoot 6-FirstName 7-First and last name together
            //ArrayList<Player> searchedPlayers = searchPlayers(7);
            ArrayList<Player> searchedPlayers2 = searchPlayers("Son");
            ArrayList<Player> searchedPlayers3 = searchPlayers("MID");
            ArrayList<Player> searchedPlayers4 = searchPlayers("England");
            ArrayList<Player> searchedPlayers5 = searchPlayers("L");
            ArrayList<Player> searchedPlayers6 = searchPlayers("Harry");
            ArrayList<Player> searchedPlayers7 = searchPlayers("HaRry kAne");
            System.out.println(news);
            System.out.println("breakpoint met");
            //End Of Tests
            
        } else {
            System.out.println("Check connection to database");
        }
        //See if a teamString is pre set, if not set up (then launch gui)
        readIniFile();
        launch(args);
    }

    public static Connection initDatabase() {
        System.out.println("Connection attempted");
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/FDB", "root", "root");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Connection Failed");
        }
        return con;
    }

    //TODO - Ini with GUI
    public static int readIniFile() throws Exception {
        int teamID = 0;
        try {
            String file = "C:\\FDB\\ini.txt";
            String line;
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    teamString = line;
                    teamID = teamStringToID(teamString);

                    //Load GUI to default teamString page
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("File Read Failed, Creating ini File");
            //Load GUI to welcome page to pick default teamString
            createIniFile(teamString);
        }
        return teamID;
    }

    //TODO - Ini with GUI
    public static void createIniFile(String teamString) throws Exception {
        try {
            //Create directory and file
            File dir = new File("C:\\FDB");
            dir.mkdir();
            File file = new File("C:\\FDB\\ini.txt");

            //Create the file
            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }

            //Write teamString to file
            FileWriter writer = new FileWriter(file);
            if (teamString.equals("")) {
                teamString = "Arsenal";
            }
            writer.write(teamString);
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("File creation Failed");
        }
    }

    public static void loadPlayers(Connection con) throws SQLException {
        System.out.println("Loading Players...");
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("select * from Player");
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(3) + " " + rs.getString(4));
                int playerID = rs.getInt(1);
                int clubID = rs.getInt(2);
                String playerFirstName = rs.getString(3);
                String playerLastName = rs.getString(4);
                int squadNumber = rs.getInt(5);
                String position = rs.getString(6);
                String height = rs.getString(7);
                String prefFoot = rs.getString(8);
                Date dob = rs.getDate(9);
                int clubApps = rs.getInt(10);
                int seasonApps = rs.getInt(11);
                String nationality = rs.getString(12);
                int clubGoals = rs.getInt(13);
                int seasonGoals = rs.getInt(14);
                int seasonAssists = rs.getInt(15);
                int cleanSheets = rs.getInt(16);
                Player plr = new Player(playerID, clubID, playerFirstName,
                        playerLastName, squadNumber, position, height,
                        prefFoot, dob, clubApps, seasonApps, nationality,
                        clubGoals, seasonGoals, seasonAssists, cleanSheets);
                allPlayers.add(plr);
                System.out.println("Player Loaded In...");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error");
        } finally {
            rs.close();
            System.out.println("All players Loaded Successfully");
        }
    }

    public static void loadManagers(Connection con) throws SQLException {
        System.out.println("Loading Managers...");
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("select * from Manager");
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(3) + " " + rs.getString(4));
                int managerID = rs.getInt(1);
                int clubID = rs.getInt(2);
                String managerFirstName = rs.getString(3);
                String managerLastName = rs.getString(4);
                Date dob = rs.getDate(5);
                String joinedClub = rs.getString(6);
                String nationality = rs.getString(7);
                Manager mngr = new Manager(managerID, clubID, managerFirstName,
                        managerLastName, dob, joinedClub, nationality);
                allManagers.add(mngr);
                System.out.println("Manager Loaded In...");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error");
        } finally {
            rs.close();
            System.out.println("All Managers Loaded Successfully");
        }
    }

    public static void loadFixtures(Connection con) throws SQLException {
        System.out.println("Loading Fixtures...");
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("select * from Fixture");
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(3) + " Vs. " + rs.getString(4));
                int matchID = rs.getInt(1);
                Date matchDate = rs.getDate(2);
                String homeTeam = rs.getString(3);
                String awayTeam = rs.getString(4);
                int homeScore = rs.getInt(5);
                int awayScore = rs.getInt(6);
                Fixture fxtr = new Fixture(matchID, matchDate, homeTeam,
                        awayTeam, homeScore, awayScore);
                allFixtures.add(fxtr);
                System.out.println("Fixture Loaded In...");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error");
        } finally {
            rs.close();
            System.out.println("All Fixtures Loaded Successfully");
        }
    }

    public static void loadClubs(Connection con) throws SQLException {
        System.out.println("Loading Clubs...");
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("select * from Club");
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(2));
                int clubID = rs.getInt(1);
                String clubName = rs.getString(2);
                String stadium = rs.getString(3);
                int clubPosititon = rs.getInt(4);
                Club clb = new Club(clubID, clubName,
                        stadium, clubPosititon);
                allClubs.add(clb);
                System.out.println("Club Loaded In...");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error");
        } finally {
            rs.close();
            System.out.println("All Clubs Loaded Successfully");
        }
    }

    public static void loadNews(Connection con) throws SQLException {
        System.out.println("Loading News...");
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("select * from News");
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(3));
                int newsID = rs.getInt(1);
                int clubID = rs.getInt(2);
                String title = rs.getString(3);
                String content = rs.getString(4);
                String author = rs.getString(5);
                News nws = new News(newsID, clubID, title, content, author);
                allNews.add(nws);
                System.out.println("News Loaded In...");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error");
        } finally {
            rs.close();
            System.out.println("All News Loaded Successfully");
        }
    }

    public static void loadTrophies(Connection con) throws SQLException {
        System.out.println("Loading Trophies...");
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("select * from Trophy");
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
                String competition = rs.getString(1);
                int year = rs.getInt(2);
                int ClubId = rs.getInt(3);
                Trophy tro = new Trophy(competition, year, ClubId);
                allTrophies.add(tro);
                System.out.println("Trophies Loaded In...");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error");
        } finally {
            rs.close();
            System.out.println("All Trophies Loaded Successfully");
        }
    }

    public static void loadStadiums(Connection con) throws SQLException {
        System.out.println("Loading Stadium...");
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("select * from Stadium");
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
                String name = rs.getString(1);
                int clubID = rs.getInt(2);
                String address = rs.getString(3);
                String postcode = rs.getString(4);
                int capacity = rs.getInt(5);
                Date dateBuilt = rs.getDate(6);
                Stadium stad = new Stadium(name, clubID, address, postcode, capacity, dateBuilt);
                allStadiums.add(stad);
                System.out.println("Stadium Loaded In...");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error");
        } finally {
            rs.close();
            System.out.println("All Stadiums Loaded Successfully");
        }
    }

    public static void loadPosHistory(Connection con) throws SQLException {
        System.out.println("Loading Position...");
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("select * from Position_History");
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(2) + " " + rs.getInt(4));
                int clubID = rs.getInt(1);
                String competition = rs.getString(2);
                int year = rs.getInt(3);
                int position = rs.getInt(4);
                PosHist posHists = new PosHist(clubID, competition, year, position);
                AllposHists.add(posHists);
                System.out.println("position History Loaded In...");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error");
        } finally {
            rs.close();
            System.out.println("All position History Loaded Successfully");
        }
    }

    //SHIV - Can we just re-use this for Club details left table?
    public static ArrayList<Player> populateClubPlayers(int requestedTeam) {
        ArrayList<Player> players = new ArrayList();
        for (Player plr : allPlayers) {
            if (plr.getclubID() == requestedTeam) {
                players.add(plr);
            }
        }
        return players;
    }

    public static String populateManagerName(int requestedTeam) {
        String managerName = "";
        for (Manager mgr : allManagers) {
            if (mgr.getclubID() == requestedTeam) {
                managerName = mgr.getfirstName() + " " + mgr.getLastName();
            }
        }
        return managerName;
    }

    public static String populateStadiumName(int requestedTeam) {
        String StadiumName = "";
        for (Stadium stdm : allStadiums) {
            if (stdm.getClubID() == requestedTeam) {
                StadiumName = stdm.getName();
            }
        }
        return StadiumName;
    }

    public static int populatePosition(String season, int requestedTeam) {
        int pos = 0;

        switch (season) {
            case "17/18":
                for (Club clb : allClubs) {
                    if (clb.getClubID() == requestedTeam) {
                        pos = clb.getClubPosititon();
                    }
                }
                break;
            case "16/17":
                for (PosHist psHst : AllposHists) {
                    if (psHst.getClubID() == requestedTeam && psHst.getYear() == 2017) {
                        pos = psHst.getPosition();
                    }
                }
                break;
            case "15/16":
                for (PosHist psHst : AllposHists) {
                    if (psHst.getClubID() == requestedTeam && psHst.getYear() == 2016) {
                        pos = psHst.getPosition();
                    }
                }
                break;
            case "14/15":
                for (PosHist psHst : AllposHists) {
                    if (psHst.getClubID() == requestedTeam && psHst.getYear() == 2015) {
                        pos = psHst.getPosition();
                    }
                }
                break;
            default:
                break;
        }
        return pos;
    }

    public static String populateNews(int requestedTeam) {
        String clubNews = "";
        String clubStory = "";
        for (News nws : allNews) {
            if (nws.getClubId() == requestedTeam) {
                clubStory = "--" + nws.getTitle() + "-- \n"
                        + nws.getAuthor() + "\n"
                        + nws.getContent();
                clubNews += clubStory + "\n \n";
            }
        }
        return clubNews;
    }

    public static ArrayList<Fixture> populateFixtures(String requestedTeam) {
        java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
        ArrayList<Fixture> results = new ArrayList();
        for (Fixture ftx : allFixtures) {
            if (ftx.getHomeTeam().equals(requestedTeam) || ftx.getAwayTeam().equals(requestedTeam)) {
                if (ftx.getMatchDate().compareTo(currentDate) > 0) {
                    results.add(ftx);
                }
            }
        }
        return results;
    }

    public static ArrayList<Fixture> populateResults(String requestedTeam, String season) {
        java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
        ArrayList<Fixture> results = new ArrayList();
        java.sql.Date seasonStartDate = null;
        java.sql.Date seasonEndDate = null;
        switch (season) {
            case "17/18":
                seasonStartDate = java.sql.Date.valueOf("2017-08-12");
                seasonEndDate = java.sql.Date.valueOf("2018-05-13");
                break;
            case "16/17":
                //	13 August 2016 – 21 May 2017
                seasonStartDate = java.sql.Date.valueOf("2016-08-13");
                seasonEndDate = java.sql.Date.valueOf("2017-05-21");
                break;
            case "15/16":
                //8 August 2015 – 17 May 2016
                seasonStartDate = java.sql.Date.valueOf("2015-08-08");
                seasonEndDate = java.sql.Date.valueOf("2016-05-17");
                break;
            case "14/15":
                //16 August 2014 and concluded on 24 May 2015.
                seasonStartDate = java.sql.Date.valueOf("2014-08-16");
                seasonEndDate = java.sql.Date.valueOf("2015-05-24");
                break;
            default:
                break;
        }
        for (Fixture ftx : allFixtures) {
            if (ftx.getHomeTeam().equals(requestedTeam) || ftx.getAwayTeam().equals(requestedTeam)) {
                if (ftx.getMatchDate().compareTo(currentDate) < 0) {
                    if (ftx.getMatchDate().compareTo(seasonStartDate) >= 0
                            && ftx.getMatchDate().compareTo(seasonEndDate) <= 0) {
                        results.add(ftx);
                    }
                }
            }
        }
        return results;
    }

    public static ArrayList<Trophy> populateTrophies(int requestedTeam) {
        ArrayList<Trophy> TrophyCabinet = new ArrayList();
        for (Trophy trphy : allTrophies) {
            if (trphy.getClubId() == requestedTeam) {
                TrophyCabinet.add(trphy);
            }
        }
        return TrophyCabinet;
    }

    //Overwritting methods with different arguments!
    //Feature temporaily disabled
//    public static ArrayList<Player> searchPlayers(int SquadNo){
//    ArrayList<Player> players = new ArrayList();
//    for (Player plr: allPlayers) {
//        if (plr.getSquadNumber() == SquadNo){
//            players.add(plr);
//        }
//    }
//    return players;
//    }
    public static ArrayList<Player> searchPlayers(String searchString) {
        ArrayList<Player> players = new ArrayList();
        String formattedSearchString = searchString.toLowerCase();
        for (Player plr : allPlayers) {
            //Used contains for first and last name so that users can input part or all of a name
            if (formattedSearchString.contains(plr.getFirstName().toLowerCase()) || 
                formattedSearchString.contains(plr.getLastName().toLowerCase()) || 
                plr.getNationality().toLowerCase().equals(formattedSearchString) ||
                plr.getPrefFoot().toLowerCase().equals(formattedSearchString)|| 
                plr.getPosition().toLowerCase().equals(formattedSearchString)) 
            {
                players.add(plr);
            }
        }
        return players;
    }
}
