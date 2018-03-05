/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

import java.io.IOException;
import java.net.URL;
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
 * @author accou
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
    
    @FXML
    private final String chelseaThemeUrl = getClass().getResource("css/Chelsea.css").toExternalForm();
    @FXML
    private final String arsenalThemeUrl = getClass().getResource("css/Arsenal.css").toExternalForm();
    @FXML
    private String stylesheet;    

    public FXMLDocumentController() {
        this.stylesheet = "";
    }
    
     @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
     Stage stage = null; 
     Parent root = null;
     
     
     if(event.getSource()== btnChelsea || event.getSource()== btnArsenal || event.getSource()== btnTottenham || event.getSource()== btnManCity || event.getSource() == btnHome){
        
         if(event.getSource() == btnChelsea){
           stylesheet = chelseaThemeUrl;  
         }
         else if (event.getSource()== btnArsenal){
           stylesheet = arsenalThemeUrl;
         }
         
        Button btn = (Button) event.getSource(); 
        stage=(Stage) btn.getScene().getWindow();
        //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        
     }
          
     else if (event.getSource() == btnTeamDetails){
        stage = (Stage) btnTeamDetails.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Team Details.fxml"));
        
     }
     
     else if (event.getSource() == btnFixtures){
         stage = (Stage) btnFixtures.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Fixtures and Results.fxml"));
       
     }
     
     else if (event.getSource() == btnClubDetails || event.getSource() == btnMoreDetails){
        stage = (Stage) btnClubDetails.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Club Details.fxml"));
        
     }
     //create a new scene with root and set the stage
      Scene scene = new Scene(root);
      stage.setScene(scene);
      scene.getStylesheets().add(stylesheet);
         System.out.println("Stylesheet= " + stylesheet);
      stage.show();
} 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
