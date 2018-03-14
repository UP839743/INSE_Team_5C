/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

import static fdb.FDB.populateClubPlayers;
import static fdb.FXMLDocumentController.*;
import static fdb.TeamDetailsController.searchString;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author up816736
 */
public class ClubDetailsController implements Initializable {

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
    @FXML
    private Button btnChangeDefaultClub;
    @FXML
    private TableView<Player> recordTable;
    @FXML
    private TableView<Trophy> trophyCabinet;
    @FXML
    private TextField searchBar;
    

    private final String arsenalClubDetailsURL = getClass().getResource("css/ArsenalClubDetails.css").toExternalForm();
    private final String chelseaClubDetailsURL = getClass().getResource("css/ChelseaClubDetails.css").toExternalForm();
    private final String tottenhamClubDetailsURL = getClass().getResource("css/TottenhamClubDetails.css").toExternalForm();
    private final String mancityClubDetailsURL = getClass().getResource("css/ManCityClubDetails.css").toExternalForm();

    public ClubDetailsController() throws IOException {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblTeamName.setText(teamName);
        loadClubStyle();
        scene.getStylesheets().add(stylesheet);
        ObservableList<Player> players = FXCollections.observableArrayList(populateClubPlayers(teamID));
        recordTable.setItems(players);
        ObservableList<Trophy> trophies = FXCollections.observableArrayList(FDB.populateTrophies(teamID));
        trophyCabinet.setItems(trophies);

    }
    
        @FXML
    public void search(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            searchString = searchBar.getText();
            searchBar.setText("");
            root = FXMLLoader.load(getClass().getResource("SearchResults.fxml"));
            Scene scene = new Scene(root);
            System.out.println("Scene: " + scene);
            stage.setScene(scene);
            scene.getStylesheets().add(stylesheet);
            stage.show();
        }
        //create a new scene with root and set the stage

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

        } else if (event.getSource() == btnChangeDefaultClub) {
            stage = (Stage) btnChangeDefaultClub.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
            stylesheet = "";
        }
        //create a new scene with root and set the stage
        scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(stylesheet);
        stage.show();

    }

    public void loadClubStyle() {
        switch (teamID) {
            case 1:
                stylesheet = arsenalClubDetailsURL;

                break;
            case 2:
                stylesheet = chelseaClubDetailsURL;

                break;
            case 3:
                stylesheet = tottenhamClubDetailsURL;

                break;
            case 4:
                stylesheet = mancityClubDetailsURL;

                break;
            default:
                break;
        }
    }

    public void selectClub(ActionEvent event) {

        if (event.getSource() == btnArsenal) {
            teamName = "Arsenal";
            teamID = 1;
        } else if (event.getSource() == btnChelsea) {
            teamName = "Chelsea";
            teamID = 2;
        } else if (event.getSource() == btnTottenham) {
            teamName = "Tottenham";
            teamID = 3;
        } else if (event.getSource() == btnManCity) {
            teamName = "Man City";
            teamID = 4;
        }

    }

}
