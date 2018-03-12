/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

import static fdb.FXMLDocumentController.*;
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
 * FXML Controller class
 *
 * @author up816736
 */
public class TeamDetailsController implements Initializable {

    @FXML
    private Button btnTeamDetails;
    @FXML
    private Button btnFixtures;
    @FXML
    private Button btnClubDetails;
    @FXML
    private Button btnHome;
    @FXML
    private Label lblTeamName;
    @FXML
    private Button btnArsenal;
    @FXML
    private Button btnChelsea;
    @FXML
    private Button btnTottenham;
    @FXML
    private Button btnManCity;

    private final String arsenalTeamDetailsURL = getClass().getResource("css/ArsenalTeamDetails.css").toExternalForm();
    private final String chelseaTeamDetailsURL = getClass().getResource("css/ChelseaTeamDetails.css").toExternalForm();
    private final String tottenhamTeamDetailsURL = getClass().getResource("css/TottenhamTeamDetails.css").toExternalForm();
    private final String mancityTeamDetailsURL = getClass().getResource("css/ManCityTeamDetails.css").toExternalForm();

    /**
     * Initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblTeamName.setText(teamName);
        loadTeamStyle();
        root.getStylesheets().add(stylesheet);
    }    

    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException {
        

        if (event.getSource() == btnChelsea || event.getSource() == btnArsenal || event.getSource() == btnTottenham || event.getSource() == btnManCity || event.getSource() == btnHome) {
            selectClub(event);
            Button btn = (Button) event.getSource();
            stage = (Stage) btn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Home.fxml"));     
        } else if (event.getSource() == btnTeamDetails) {
            stage = (Stage) btnTeamDetails.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Team Details.fxml"));
        } else if (event.getSource() == btnFixtures) {
            stage = (Stage) btnFixtures.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Fixtures and Results.fxml"));
        } else if (event.getSource() == btnClubDetails) {
            stage = (Stage) btnClubDetails.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Club Details.fxml"));
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(stylesheet);
        stage.show();
        
    }
    
        public void loadTeamStyle(){
        switch (team) {
                case 1:
                    stylesheet = arsenalTeamDetailsURL;

                    break;
                case 2:
                    stylesheet = chelseaTeamDetailsURL;

                    break;
                case 3:
                    stylesheet = tottenhamTeamDetailsURL;

                    break;
                case 4:
                    stylesheet = mancityTeamDetailsURL;

                    break;
                default:
                    break;
            }
    }
        
        public void selectClub(ActionEvent event){
        
        if (event.getSource() == btnArsenal) {
                teamName = "Arsenal";
                team = 1;
            } else if (event.getSource() == btnChelsea) {
                teamName = "Chelsea";
                team = 2;
            } else if (event.getSource() == btnTottenham) {
                teamName = "Tottenham";
                team = 3;
            } else if (event.getSource() == btnManCity) {
                teamName = "Man City";
                team = 4;
            }
        
           
    }
    
}