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
 * Club Details FXML Controller class
 *
 * @author INSE Team 5C
 */
public class ClubDetailsController implements Initializable {
//  intialised all the used componenets in the UI.

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
//  URLs for the CSS files used depending on team selected.
    private final String arsenalClubDetailsURL = getClass().getResource("css/ArsenalClubDetails.css").toExternalForm();
    private final String chelseaClubDetailsURL = getClass().getResource("css/ChelseaClubDetails.css").toExternalForm();
    private final String tottenhamClubDetailsURL = getClass().getResource("css/TottenhamClubDetails.css").toExternalForm();
    private final String mancityClubDetailsURL = getClass().getResource("css/ManCityClubDetails.css").toExternalForm();

    /**
     * Initializes the controller class. 
     * Changes lblTeamName to the selected
     * team. The team stylesheet is loaded and added to the scene. Players and
     * trophies are loaded into the player and trophy tables depending on which
     * team has been selected.
     *
     * @param url The parameter is the url for the controller.
     * @param rb ResourceBundle used by the controller.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblTeamName.setText(teamName);
        loadClubStyle();
        scene.getStylesheets().add(stylesheet);
        // List of players
        ObservableList<Player> players = FXCollections.observableArrayList(populateClubPlayers(teamID));
        recordTable.setItems(players);
        //List of trophies
        ObservableList<Trophy> trophies = FXCollections.observableArrayList(FDB.populateTrophies(teamID));
        trophyCabinet.setItems(trophies);

    }

    /**
     * Search event triggered by pressing the enter key. calls the search method
     * when enter is pressed. loads the search page with the queried results.
     *
     * @param keyEvent the key pressed.
     * @throws IOException
     */
    @FXML
    public void search(KeyEvent keyEvent) throws IOException {
        //if key pressed is enter AND text box is not empty
        if (keyEvent.getCode() == KeyCode.ENTER && !"".equals(searchBar.getText())) {
            searchString = searchBar.getText();
            //makes the search bar blank again.
            searchBar.setText("");
            //finds and loads the Search Results.fxml file.
            root = FXMLLoader.load(getClass().getResource("Search Results.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            scene.getStylesheets().add(stylesheet);
            stage.show();
        }

    }

    /**
     * Button event for all the buttons on the page. Depending on the button
     * pressed the desired page will load. And set the correct stylesheet.
     *
     * @param event The button pressed.
     * @throws IOException
     */
    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException {
        // loads the home page by pressing the club buttons or home button.
        if (event.getSource() == btnChelsea || event.getSource() == btnArsenal || event.getSource() == btnTottenham || event.getSource() == btnManCity || event.getSource() == btnHome) {
            // loads the stylesheet for the desired club.
            selectClub(event);
            // changes the root pane to home.fxml
            Button btn = (Button) event.getSource();
            stage = (Stage) btn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        } // sets the root and stage to the team details page.
        else if (event.getSource() == btnTeamDetails) {
            stage = (Stage) btnTeamDetails.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Team Details.fxml"));

        } // sets the root and stage to the Fixtures and results page.
        else if (event.getSource() == btnFixtures) {
            stage = (Stage) btnFixtures.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Fixtures and Results.fxml"));

        } // sets the root and stage to the club details page.
        else if (event.getSource() == btnClubDetails) {
            stage = (Stage) btnClubDetails.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Club Details.fxml"));

        } // sets the root and stage to the welcome page.
        else if (event.getSource() == btnChangeDefaultClub) {
            stage = (Stage) btnChangeDefaultClub.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
            stylesheet = "";
        }
        //create a new scene with previously set root and sets the stage
        scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(stylesheet);
        stage.show();

    }

    /**
     * Sets what stylesheet will be used depending on which club has been
     * chosen.
     */
    public void loadClubStyle() {
        switch (teamID) {
            case 1:
                //loads Arsenal
                stylesheet = arsenalClubDetailsURL;

                break;
            case 2:
                //loads Chelsea
                stylesheet = chelseaClubDetailsURL;

                break;
            case 3:
                // loads Tottenham
                stylesheet = tottenhamClubDetailsURL;

                break;
            case 4:
                // loads Man City
                stylesheet = mancityClubDetailsURL;

                break;
            default:
                break;
        }
    }

    /**
     * Sets the team name and teamID depending on the button pressed
     *
     * @param event The club button pressed.
     */
    public void selectClub(ActionEvent event) {
        // Sets to Arsenal
        if (event.getSource() == btnArsenal) {
            teamName = "Arsenal";
            teamID = 1;
        } // Sets to Chelsea
        else if (event.getSource() == btnChelsea) {
            teamName = "Chelsea";
            teamID = 2;
        } // Sets to Tottenham
        else if (event.getSource() == btnTottenham) {
            teamName = "Tottenham";
            teamID = 3;
        } // Sets to Man City
        else if (event.getSource() == btnManCity) {
            teamName = "Man City";
            teamID = 4;
        }

    }

}
