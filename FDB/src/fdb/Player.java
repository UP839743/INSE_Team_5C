/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samuel
 */
public class Player{
    String playerFirstName;
    String playerLastName;
    int squadNumber;
    String position;
    String height;
    String prefFoot;
    String DoB;
    int clubApps;
    int seasonApps;
    String nationality;
    int clubGoals;
    int seasonGoals;
    String cleanSheets; //if they're not a keeper then tell the user.
    
    public Player(){};

    public void loadPlayer(String query){
    System.out.println("Connection attempted");
    try{  
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/FDB","root","password");  
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from Player where " + query);  
        while(rs.next()){
            System.out.println(rs.getString(1));
            playerFirstName = rs.getString(2);
            playerLastName = rs.getString(3);
            squadNumber = rs.getInt(4);
            position = rs.getString(5);
            height = rs.getString(6);
            prefFoot = rs.getString(7);
            DoB = rs.getString(8);
            clubApps = rs.getInt(9);
            seasonApps = rs.getInt(10);
            nationality = rs.getString(11);
            clubGoals = rs.getInt(12);
            seasonGoals = rs.getInt(13);
            cleanSheets = rs.getString(14);
        }
            con.close();  }
    catch(Exception e){
        System.out.println(e);
        System.out.println("Error");}
    }
    
    public void loadAllPlayers(String clubID){
        List players = new ArrayList();
        Boolean complete = false;
        int i = 1;
        while (!complete){
            loadPlayer("PlayerID = " +  i + "AND ClubID = " + clubID); //Wont work right now.. no club ID in player
            i++;
        }
    }
    
    //Getters
    private String getFirstName(String query){
    return playerFirstName;
    }

    private String getLastName(){
    return playerLastName;
    }

    private String getPosition(){
    return position;
    }

    private String getDoB(){
    return DoB;
    }

    private String getNationality(){
    return nationality;
    }
}