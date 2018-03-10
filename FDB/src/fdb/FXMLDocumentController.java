/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

import static fdb.FDB.loadTrophies;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author INSE Team 5C
 */


public class FXMLDocumentController implements Initializable {
  
    @FXML
    private Button btnChelsea;
    @FXML
    private Button btnArsenal;
    @FXML
    private Button btnTottenham;
    @FXML
    private Button btnManCity;
    @FXML
    private Button btnTeamDetails;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnFixtures;
    @FXML
    private Button btnClubDetails;
    @FXML
    private Button btnMoreDetails;
    
    private final String chelseaThemeUrl = getClass().getResource("css/Chelsea.css").toExternalForm();
    private final String arsenalThemeUrl = getClass().getResource("css/Arsenal.css").toExternalForm();
    private final String tottenhamThemeUrl = getClass().getResource("css/Tottenham.css").toExternalForm();
    private final String mancityThemeUrl = getClass().getResource("css/Man City.css").toExternalForm();
    private final String arsenalTeamDetailsURL = getClass().getResource("css/ArsenalTeamDetails.css").toExternalForm();
    private final String chelseaTeamDetailsURL = getClass().getResource("css/ChelseaTeamDetails.css").toExternalForm();
    private final String tottenhamTeamDetailsURL = getClass().getResource("css/TottenhamTeamDetails.css").toExternalForm();
    private final String mancityTeamDetailsURL = getClass().getResource("css/ManCityTeamDetails.css").toExternalForm();
    private final String arsenalClubDetailsURL = getClass().getResource("css/ArsenalClubDetails.css").toExternalForm();
    private final String chelseaClubDetailsURL = getClass().getResource("css/ChelseaClubDetails.css").toExternalForm();
    private final String tottenhamClubDetailsURL = getClass().getResource("css/TottenhamClubDetails.css").toExternalForm();
    private final String mancityClubDetailsURL = getClass().getResource("css/ManCityClubDetails.css").toExternalForm();
    private final String arsenalFixturesURL = getClass().getResource("css/ArsenalFixturesAndResults.css").toExternalForm();
    private final String chelseaFixturesURL = getClass().getResource("css/ChelseaFixturesAndResults.css").toExternalForm();
    private final String tottenhamFixturesURL = getClass().getResource("css/TottenhamFixturesAndResults.css").toExternalForm();
    private final String mancityFixturesURL = getClass().getResource("css/ManCityFixturesAndResults.css").toExternalForm();
    
    
    private static String stylesheet = "";  
    private static int team = 0;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
     Stage stage = null; 
     Parent root = null;
          
     if(event.getSource()== btnChelsea || event.getSource()== btnArsenal || event.getSource()== btnTottenham || event.getSource()== btnManCity || event.getSource() == btnHome){
                            
         if(event.getSource() == btnArsenal){
           stylesheet = arsenalThemeUrl;
           team = 1;
         }
         else if (event.getSource()== btnChelsea){
           stylesheet = chelseaThemeUrl;
           team = 2;
         }
         else if (event.getSource() == btnTottenham){
             stylesheet = tottenhamThemeUrl;
             team = 3;
         }
         else if (event.getSource() == btnManCity){
             stylesheet = mancityThemeUrl;
             team = 4;
         }
                 
        Button btn = (Button) event.getSource(); 
        stage = (Stage) btn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        System.out.println("root = " + root);
     }
          
     else if (event.getSource() == btnTeamDetails){
        stage = (Stage) btnTeamDetails.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Team Details.fxml"));
        
        if (team == 1){
            stylesheet = arsenalTeamDetailsURL;
        }
        else if (team == 2){
            stylesheet = chelseaTeamDetailsURL;
        }
        else if (team == 3){
            stylesheet = tottenhamTeamDetailsURL;
        }
        else if (team == 4){
            stylesheet = mancityTeamDetailsURL;
        }
     
     }
     
     else if (event.getSource() == btnFixtures){
        stage = (Stage) btnFixtures.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Fixtures and Results.fxml"));
       
        if (team == 1){
            stylesheet = arsenalFixturesURL;
        }
        else if (team == 2){
            stylesheet = chelseaFixturesURL;
        }
        else if (team == 3){
            stylesheet = tottenhamFixturesURL;
        }
        else if (team == 4){
            stylesheet = mancityFixturesURL;
        }
        
     }
     
     else if (event.getSource() == btnClubDetails || event.getSource() == btnMoreDetails){
        stage = (Stage) btnClubDetails.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Club Details.fxml"));
        
        if (team == 1){
            stylesheet = arsenalClubDetailsURL;
        }
        else if (team == 2){
            stylesheet = chelseaClubDetailsURL;
        }
        else if (team == 3){
            stylesheet = tottenhamClubDetailsURL;
        }
        else if (team == 4){
            stylesheet = mancityClubDetailsURL;
        }
        
     }
     //create a new scene with root and set the stage
      Scene scene = new Scene(root);
      stage.setScene(scene);
      scene.getStylesheets().add(stylesheet);
      stage.show();

    } 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
