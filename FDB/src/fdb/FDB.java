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
   
//    private String arsenalThemeUrl = getClass().getResource("@css/Arsenal.css").toExternalForm();
//    private String chelseaThemeUrl = getClass().getResource("@css/Chelsea.css").toExternalForm();
//    private String tottenhamThemeUrl = getClass().getResource("@css/Tottenham.css").toExternalForm();
//    private String manCityThemeUrl = getClass().getResource("@css/ManCity.css").toExternalForm();
    
    public void start(Stage stage) throws Exception {
        Parent root = null;
        if (team.equals("Arsenal") || team.equals("Tottenham") || team.equals("Man City") || team.equals("Chelsea")){
            root = FXMLLoader.load(getClass().getResource("Home.fxml"));}
        else {
            root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));}
        Scene scene = new Scene(root);
        stage.setMaxHeight(1000);
        stage.setMaxWidth(1400);
        stage.setMinHeight(1000);
        stage.setMinWidth(1400);
        stage.setScene(scene);
        stage.show();
    }
   
    static String team = "";
    static ArrayList<Player> allPlayers = new ArrayList();
    static ArrayList<Manager> allManagers = new ArrayList();
    static ArrayList<Fixture> allFixtures = new ArrayList();
    static ArrayList<Club> allClubs = new ArrayList();
    static ArrayList<News> allNews = new ArrayList();
    static ArrayList<Trophy> allTrophies = new ArrayList();
    static ArrayList<Stadium> allStadiums = new ArrayList();
    static ArrayList<PosHist> AllposHists = new ArrayList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        //Connect to Database
        Connection con = initDatabase();
        //Load in objects
        if (con != null){
            ArrayList<Player> team = new ArrayList();
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
            ArrayList<Fixture> spursResults = populateResults("Tottenham Hotspur");
            ArrayList<Fixture> spursFixtures = populateFixtures("Tottenham Hotspur");
            ArrayList<Trophy> trophyCabinet = populateTrophies(1);
            //tests as follows 1-SquadNo 2- LastName 3-Position 4-Nationality 5-PrefFoot 6-FirstName 7-First and last name together
            ArrayList<Player> searchedPlayers = searchPlayers(7);
            ArrayList<Player> searchedPlayers2 = searchPlayers("Son");
            ArrayList<Player> searchedPlayers3 = searchPlayers("MID");
            ArrayList<Player> searchedPlayers4 = searchPlayers("England");
            ArrayList<Player> searchedPlayers5 = searchPlayers("L");
            ArrayList<Player> searchedPlayers6 = searchPlayers("Harry");
            ArrayList<Player> searchedPlayers7 = searchPlayers("Harry Kane");
            System.out.println(news);
            System.out.println("breakpoint met");
            //End Of Tests
            }
        else {System.out.println("Check connection to database");}
        //See if a team is pre set, if not set up (then launch gui)
        readIniFile();
        launch(args);
    }
    
    public static Connection initDatabase(){
        System.out.println("Connection attempted");
        Connection con = null;
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/FDB","root","root");
            }       
        catch(Exception e){
            System.out.println(e);
            System.out.println("Connection Failed");
        }
        return con;
    }
    
    //TODO - Ini with GUI
    public static void readIniFile() throws Exception{
        try{
            String file = "C:\\FDB\\ini.txt";
            String line;
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    team = line;
                    //Load GUI to default team page
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("File Read Failed, Creating ini File");
            //Load GUI to welcome page to pick default team
            createIniFile(team);
        }
    }
    
        //TODO - Ini with GUI
    public static void createIniFile(String team) throws Exception{
        try{
            //Create directory and file
            File dir = new File("C:\\FDB");
            dir.mkdir();
            File file = new File("C:\\FDB\\ini.txt");

            
            //Create the file
            if (file.createNewFile()){
                System.out.println("File is created!");}
            else{
                System.out.println("File already exists.");}

            //Write team to file
            FileWriter writer = new FileWriter(file);
            if (team.equals("")){team = "Arsenal";}
            writer.write(team);
            writer.close();
        }
        catch(Exception e){
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
    public static ArrayList<Player> populateClubPlayers(int requestedTeam){
    ArrayList<Player> players = new ArrayList();
    for (Player plr: allPlayers) {
        if (plr.getclubID() == requestedTeam){
            players.add(plr);
        }
    }
    return players;
    }
    
    public static String populateManagerName(int requestedTeam){
    String managerName = "";
    for (Manager mgr: allManagers) {
        if (mgr.getclubID() == requestedTeam){
            managerName = mgr.getfirstName() + " " + mgr.getLastName();
        }
    }
    return managerName;
    }
    
    public static String populateStadiumName(int requestedTeam){
    String StadiumName = "";
    for (Stadium stdm: allStadiums) {
        if (stdm.getClubID() == requestedTeam){
            StadiumName = stdm.getName();
        }
    }
    return StadiumName;
    }
    
    public static int populatePosition(String season, int requestedTeam){
        int pos = 0;
        //Currentseason
        if (season == "17/18"){
            for (Club clb: allClubs) {
                if (clb.getClubID() == requestedTeam){
                    pos = clb.getClubPosititon();
                }
            }
        }
        //past seasons
        else if (season == "16/17"){
            for (PosHist psHst: AllposHists) {
                if (psHst.getClubID() == requestedTeam && psHst.getYear() == 2017){
                    pos = psHst.getPosition();
                }
            }
        }
        else if (season == "15/16"){
            for (PosHist psHst: AllposHists) {
                if (psHst.getClubID() == requestedTeam && psHst.getYear() == 2016){
                    pos = psHst.getPosition();
                }
            }
        }
        else if (season == "14/15"){
            for (PosHist psHst: AllposHists) {
                    if (psHst.getClubID() == requestedTeam && psHst.getYear() == 2015){
                        pos = psHst.getPosition();
                    }
                }
        }
        else{}
    return pos;
    }
    
    public static String populateNews(int requestedTeam){
    String StadiumNews = "";
    for (News nws: allNews) {
        if (nws.getClubId() == requestedTeam){
            StadiumNews = "--" + nws.getTitle() + "-- \n" 
                    + nws.getAuthor() + "\n"
                    + nws.getContent();
        }
    }
    return StadiumNews;
    }
    
    public static ArrayList<Fixture> populateFixtures(String requestedTeam){
    java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
    ArrayList<Fixture> results = new ArrayList();
    for (Fixture ftx: allFixtures) {
        if (ftx.getHomeTeam().equals(requestedTeam) || ftx.getAwayTeam().equals(requestedTeam)){
            if (ftx.getMatchDate().compareTo(currentDate) > 0){
            results.add(ftx);}}
    }
    return results;
    }
    
    public static ArrayList<Fixture> populateResults(String requestedTeam){
    java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
    ArrayList<Fixture> results = new ArrayList();
    for (Fixture ftx: allFixtures) {
        if (ftx.getHomeTeam().equals(requestedTeam) || ftx.getAwayTeam().equals(requestedTeam)){
            if (ftx.getMatchDate().compareTo(currentDate) < 0){
            results.add(ftx);}}
    }
    return results;
    }
    
    public static ArrayList<Trophy> populateTrophies(int requestedTeam){
    ArrayList<Trophy> TrophyCabinet = new ArrayList();
    for (Trophy trphy: allTrophies) {
        if (trphy.getClubId() == requestedTeam){
            TrophyCabinet.add(trphy);
        }
    }
    return TrophyCabinet;
    }
    
    //Overwritting methods with different arguments!
    public static ArrayList<Player> searchPlayers(int SquadNo){
    ArrayList<Player> players = new ArrayList();
    for (Player plr: allPlayers) {
        if (plr.getSquadNumber() == SquadNo){
            players.add(plr);
        }
    }
    return players;
    }
    
    public static ArrayList<Player> searchPlayers(String searchString){
    ArrayList<Player> players = new ArrayList();
    for (Player plr: allPlayers) {
        //Used contains for first and last name so that users can input part or all of a name
        if (searchString.contains(plr.getFirstName())|| searchString.contains(plr.getLastName())
                || plr.getNationality().equals(searchString)|| plr.getPrefFoot().equals(searchString) 
                || plr.getPosition().equals(searchString)){
            players.add(plr);
        }
    }
    return players;
    }
}

