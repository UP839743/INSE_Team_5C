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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author INSE Team 5C
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label lblTeamName;
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
    
    public static Scene scene;
    public static Stage stage;
    public static Parent root;
    public static String stylesheet = "";
    public static int team = 0;
    public static String teamName = "";
    public static String founder = "";
    public static String chairman = "";

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == btnChelsea || event.getSource() == btnArsenal || event.getSource() == btnTottenham || event.getSource() == btnManCity || event.getSource() == btnHome) {
            loadClub(event);
            Button btn = (Button) event.getSource();
            stage = (Stage) btn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Home.fxml"));     
        } else if (event.getSource() == btnTeamDetails) {
            stage = (Stage) btnTeamDetails.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Team Details.fxml"));
        } else if (event.getSource() == btnFixtures) {
            stage = (Stage) btnFixtures.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Fixtures and Results.fxml"));
        } else if (event.getSource() == btnClubDetails || event.getSource() == btnMoreDetails) {
            stage = (Stage) btnClubDetails.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Club Details.fxml"));
        }
        //create a new scene with root and set the stage
        scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(stylesheet);
        stage.show();
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
          
    }
    
    public void loadClub(ActionEvent event){
        
        if (event.getSource() == btnArsenal) {
                stylesheet = arsenalThemeUrl;
                teamName = "Arsenal";
                
                team = 1;
            } else if (event.getSource() == btnChelsea) {
                stylesheet = chelseaThemeUrl;
                teamName = "Chelsea";
                
                team = 2;
            } else if (event.getSource() == btnTottenham) {
                stylesheet = tottenhamThemeUrl;
                teamName = "Tottenham";
                
                team = 3;
            } else if (event.getSource() == btnManCity) {
                stylesheet = mancityThemeUrl;
                teamName = "Man City";
                team = 4;
            }
        
           
    }
    

    
 

    
}
