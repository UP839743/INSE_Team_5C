/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

import java.sql.*;
import java.io.*;
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
        readIniFile();
        launch(args);
        Player plr = new Player();
        plr.loadPlayer("PLAYERID = 1");
    }     
        public static void initDatabase(){
        System.out.println("Connection attempted");
        try{  
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/homes","root","password");  
        //here sonoo is database name, root is username and password  
        Statement stmt=con.createStatement();  
        con.close();  }
        /**
        ResultSet rs=stmt.executeQuery("select * from branch");  
        while(rs.next())  
            System.out.println(rs.getString(1));  
            */
           
        catch(Exception e){
            System.out.println(e);
            System.out.println("Connection Failed");
        }
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
}
