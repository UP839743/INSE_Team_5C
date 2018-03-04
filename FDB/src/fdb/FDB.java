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
 * @author accou
 */
public class FDB extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //See if a team is pre set, if not set up
        readIniFile();
        //Connect to Database
        Connection con = initDatabase();
        //launch(args);
        //Load in players
        loadPlayers(con, "select * from Player where ClubID = 1");
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
    
    public static void readIniFile() throws Exception{
        try{
            String file = "C:\\FDB\\ini.txt";
            String line;
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("File Read Failed, Creating ini File");
            //Change this later - call welcome page, then call create.
            createIniFile("spurs");
        }
    }
    
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
            writer.write(team);
            writer.close();
        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("File creation Failed");
        }
    }
        
    public static void loadPlayers(Connection con, String query) {
    System.out.println("Loading Players...");
    List players = new ArrayList();
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        ps = con.prepareStatement(query);
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
            String dob = rs.getString(9);
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
            System.out.println("Player Added...");
        }
    } catch (Exception e) {
        System.out.println(e);
        System.out.println("Error");
    } finally {//rs.Close();
            }
        }
}
