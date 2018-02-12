/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author accou
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("Connection attempted");
        label.setText("Connection attempted, check terminal");
        try{  
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://10.128.48.198/Test","INSE","root");  
        //here sonoo is database name, root is username and password  
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from Student");  
        while(rs.next())  
            System.out.println(rs.getString(1));  
            con.close();  }
    catch(Exception e){
        System.out.println(e);
        System.out.println("Connection Failed");
        label.setText("Connection Failed, check terminal");
    }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
