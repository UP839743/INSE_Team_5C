/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author INSE Team 5C
 */
public class FDB extends Application {
    
    ArrayList<Player> allPlayers = null;
    ArrayList<Manager> allManagers = null;
    ArrayList<Fixture> allFixtures = null;
    ArrayList<Club> allClubs = null;
    ArrayList<News> allNews = null;
    ArrayList<Trophy> allTrophies = null;
    ArrayList<Stadium> allStadiumss = null;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        Scene scene = new Scene(root);
        stage.setMaxHeight(1000);
        stage.setMaxWidth(1400);
        stage.setMinHeight(1000);
        stage.setMinWidth(1400);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public void main(String[] args) throws Exception {
        //See if a team is pre set, if not set up
        readIniFile();
        //Connect to Database
        Connection con = initDatabase();
        //Load in objects
        if (con != null) {
            allPlayers = loadPlayers(con);
            allManagers = loadManagers(con);
            allFixtures = loadFixtures(con);
            allClubs = loadClubs(con);
            allNews = loadNews(con);
            allTrophies = loadTrophies(con);
            allStadiumss = loadStadiums(con);
            System.out.println("Done...");
        } else {
            System.out.println("Check connection to database");
        }
        //Load GUI
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

    public static void readIniFile() throws Exception {
        try {
            String file = "C:\\FDB\\ini.txt";
            String line;
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("File Read Failed, Creating ini File");
            //Change this later - call welcome page, then call create.
            createIniFile("spurs");
        }
    }

    public static void createIniFile(String team) throws Exception {
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

            //Write team to file
            FileWriter writer = new FileWriter(file);
            writer.write(team);
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("File creation Failed");
        }
    }

    public static ArrayList<Player> loadPlayers(Connection con) throws SQLException {
        System.out.println("Loading Players...");
        ArrayList<Player> players = new ArrayList();
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
                int cleanSheets = rs.getInt(15);
                Player plr = new Player(playerID, clubID, playerFirstName,
                        playerLastName, squadNumber, position, height,
                        prefFoot, dob, clubApps, seasonApps, nationality,
                        clubGoals, seasonGoals, cleanSheets);
                players.add(plr);
                System.out.println("Player Loaded In...");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error");
        } finally {
            rs.close();
            System.out.println("All players Loaded Successfully");
            return players;
        }
    }

    public static ArrayList<Manager> loadManagers(Connection con) throws SQLException {
        System.out.println("Loading Managers...");
        ArrayList<Manager> managers = new ArrayList();
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
                managers.add(mngr);
                System.out.println("Manager Loaded In...");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error");
        } finally {
            rs.close();
            System.out.println("All Managers Loaded Successfully");
            return managers;
        }
    }

    public static ArrayList<Fixture> loadFixtures(Connection con) throws SQLException {
        System.out.println("Loading Fixtures...");
        ArrayList<Fixture> fixtures = new ArrayList();
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
                fixtures.add(fxtr);
                System.out.println("Fixture Loaded In...");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error");
        } finally {
            rs.close();
            System.out.println("All Fixtures Loaded Successfully");
            return fixtures;
        }
    }

    public static ArrayList<Club> loadClubs(Connection con) throws SQLException {
        System.out.println("Loading Clubs...");
        ArrayList<Club> clubs = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("select * from Club");
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(2));
                int clubID = rs.getInt(1);
                String clubName = rs.getString(2);
                String manager = rs.getString(3);
                String stadium = rs.getString(4);
                int clubPosititon = rs.getInt(5);
                Club clb = new Club(clubID, clubName, manager,
                        stadium, clubPosititon);
                clubs.add(clb);
                System.out.println("Club Loaded In...");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error");
        } finally {
            rs.close();
            System.out.println("All Clubs Loaded Successfully");
            return clubs;
        }
    }

    public static ArrayList<News> loadNews(Connection con) throws SQLException {
        System.out.println("Loading News...");
        ArrayList<News> newsArticles = new ArrayList();
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
                News nws = new News(newsID, clubID, title, content);
                newsArticles.add(nws);
                System.out.println("News Loaded In...");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error");
        } finally {
            rs.close();
            System.out.println("All News Loaded Successfully");
            return newsArticles;
        }
    }

    public static ArrayList<Trophy> loadTrophies(Connection con) throws SQLException {
        System.out.println("Loading Trophies...");
        ArrayList<Trophy> trophies = new ArrayList();
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
                trophies.add(tro);
                System.out.println("Trophies Loaded In...");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error");
        } finally {
            rs.close();
            System.out.println("All Trophies Loaded Successfully");
            return trophies;
        }
    }

    public static ArrayList<Stadium> loadStadiums(Connection con) throws SQLException {
        System.out.println("Loading Stadium...");
        ArrayList<Stadium> stadiums = new ArrayList();
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
                stadiums.add(stad);
                System.out.println("Stadium Loaded In...");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error");
        } finally {
            rs.close();
            System.out.println("All Stadiums Loaded Successfully");
            return stadiums;
        }
    }

    public String loadTeamNews(int teamID) {
        String news = "";
        int i = 0;
        while (i <= allNews.size()) {
            News article = allNews.get(i);
            if (article.getClubId() == teamID){
                news = article.getTitle() + "\n" + article.getContent() + "\n";
            }
            i++;
        }
        return news;
    }
    
    public static String loadTeamBasicDetails(int teamID) {
        String basicDetails = "";
        return basicDetails;
    }
    
    public static String loadTeamPosition(int teamID, String season) {
        String position = "";
        return position;
    }
    
    public static String loadTeamPlayers(int teamID) {
        String position = "";
        return position;
    }
    
    public static String loadTeamFixtures(int teamID, String season, String date) {
        String position = "";
        return position;
    }
    
    public static String loadTeamResults(int teamID, String season) {
        String position = "";
        return position;
    }
    
}
