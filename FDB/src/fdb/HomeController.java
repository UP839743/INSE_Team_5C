/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

import static fdb.FDB.populateManagerName;
import static fdb.FDB.populateStadiumName;
import static fdb.FDB.populatePosition;
import static fdb.FXMLDocumentController.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author up816736
 */
public class HomeController implements Initializable {

    @FXML
    private Label lblTeamName;
    @FXML
    private Label lblNews;
    @FXML
    private VBox newsBox;
    @FXML
    private Label lblStory;
    @FXML
    private Label lblClubDetails;
    private Button btnMoreDetails;
    @FXML
    private Label lblSeason;
    @FXML
    private Label lblPosition;
    @FXML
    private ComboBox<String> seasonBox;
    @FXML
    private Label lblCurrentPosition;
    @FXML
    private Label lblStadium;
    @FXML
    private Label lblFounder;
    @FXML
    private Label lblManager;
    @FXML
    private Label lblChairman;
    @FXML
    private Label lblLeague;
    @FXML
    private HBox menuBox;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnTeamDetails;
    @FXML
    private Button btnFixtures;
    @FXML
    private Button btnClubDetails;
    @FXML
    private VBox teamBox;
    @FXML
    private Button btnArsenal;
    @FXML
    private Button btnChelsea;
    @FXML
    private Button btnTottenham;
    @FXML
    private Button btnManCity;
    @FXML
    private TextField searchField;

    private final String chelseaThemeUrl = getClass().getResource("css/Chelsea.css").toExternalForm();
    private final String arsenalThemeUrl = getClass().getResource("css/Arsenal.css").toExternalForm();
    private final String tottenhamThemeUrl = getClass().getResource("css/Tottenham.css").toExternalForm();
    private final String mancityThemeUrl = getClass().getResource("css/Man City.css").toExternalForm();

    @FXML
    private Label lblStadiumName;
    @FXML
    private Label lblFounderName;
    @FXML
    private Label lblManagerName;
    @FXML
    private Label lblChairmanName;
    @FXML
    private Label lblLeagueName;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadHomeStyle();
        lblTeamName.setText(teamName);
        lblFounderName.setText(founder);
        lblChairmanName.setText(chairman);
        lblStadiumName.setText(populateStadiumName(team));  
        lblManagerName.setText(populateManagerName(team));
        
        lblLeagueName.setText ("Premier League");
        seasonBox.getSelectionModel().selectFirst();


    }

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

    @FXML
    public void showSeasonPosition(ActionEvent event) {
        lblCurrentPosition.setText(Integer.toString(populatePosition(seasonBox.getValue(),team)));
    }
    
    public void loadClub(ActionEvent event) {

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

    public void loadHomeStyle() {
        switch (team) {
            case 1:
                stylesheet = arsenalThemeUrl;
                founder = "David Danskin";
                chairman = "Chips Keswik";
                break;
            case 2:
                stylesheet = chelseaThemeUrl;
                founder = "Gus & Joseph Mears";
                chairman = "Bruce Buck";
                break;
            case 3:
                stylesheet = tottenhamThemeUrl;
                founder = "Robert Buckle, Sam Casey & John Anderson";
                chairman = "Daniel Levy";
                break;
            case 4:
                stylesheet = mancityThemeUrl;
                founder = "Anna & Arthur Connell, William Beastow  & Thomas Goodbehere";
                chairman = "Khaldoon Al Mubarak";
                break;
            default:
                break;
        }

    }

}
