/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

import java.sql.*;
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
    public static void main(String[] args) {
        initDatabase();
        launch(args); 
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
}
