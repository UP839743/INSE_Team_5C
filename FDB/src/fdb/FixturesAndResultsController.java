/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * Fixtures and Results FXML Controller class
 *
 * @author INSE Team 5C
 */
public class FixturesAndResultsController implements Initializable {
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
    private Button btnArsenal;
    @FXML
    private Button btnChelsea;
    @FXML
    private Button btnTottenham;
    @FXML
    private Button btnManCity;
    @FXML
    private Label lblTeamName;
    @FXML
    private Button btnChangeDefaultClub;
    @FXML
    private TableView<Fixture> fixtureTable;
    @FXML
    private TableView<Fixture> resultTable;
    @FXML
    private ComboBox resultSeason;
    @FXML
    private TextField searchBar;
//  URLs for the CSS files used depending on team selected.

    private final String arsenalFixturesURL = getClass().getResource("css/ArsenalFixturesAndResults.css").toExternalForm();
    private final String chelseaFixturesURL = getClass().getResource("css/ChelseaFixturesAndResults.css").toExternalForm();
    private final String tottenhamFixturesURL = getClass().getResource("css/TottenhamFixturesAndResults.css").toExternalForm();
    private final String mancityFixturesURL = getClass().getResource("css/ManCityFixturesAndResults.css").toExternalForm();

    /**
     * Initializes the controller class. Sets up the Fixtures and Results page by
     * setting the team name for the label, loading the correct style for the
     * selected team and populating the fixtures and results table.
     *
     * @param url The parameter is the url for the controller.
     * @param rb ResourceBundle used by the controller.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblTeamName.setText(teamName);
        loadFixtureStyle();
        scene.getStylesheets().add(stylesheet);
        // Shows the first item in the results combo box rather than the prompt text.
        resultSeason.getSelectionModel().selectFirst();
        // loads the fixtures
        ObservableList<Fixture> fixtures = FXCollections.observableArrayList(FDB.populateFixtures(teamName));
        fixtureTable.setItems(fixtures);
        String season = (String) resultSeason.getValue();
        //loads the results
        ObservableList<Fixture> results = FXCollections.observableArrayList(FDB.populateResults(teamName, season));
        resultTable.setItems(results);
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
        }// sets the root and stage to the team details page. 
        else if (event.getSource() == btnTeamDetails) {
            stage = (Stage) btnTeamDetails.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Team Details.fxml"));

        } // sets the root and stage to the fixtures and results page. 
        else if (event.getSource() == btnFixtures) {
            stage = (Stage) btnFixtures.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Fixtures and Results.fxml"));

        } // sets the root and stage to the club details page. 
        else if (event.getSource() == btnClubDetails) {
            stage = (Stage) btnClubDetails.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Club Details.fxml"));

        }// sets the root and stage to the welcome page. 
        else if (event.getSource() == btnChangeDefaultClub) {
            stage = (Stage) btnChangeDefaultClub.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
            stylesheet = "";
        }
        //create a new scene with previously set root and sets the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(stylesheet);
        stage.show();

    }

    /**
     * Changes the list of results in the results table by changing the value selected
     * in the results combo box.
     * @param event the value selected in the combo box.
     */
    @FXML
    public void showSeasonPosition(ActionEvent event) {
        String season = (String) resultSeason.getValue();
        ObservableList<Fixture> results = FXCollections.observableArrayList(FDB.populateResults(teamName, season));
        resultTable.setItems(results);
    }
/**
 * changes the stylesheet variable depending on the team chosen.
 */
    public void loadFixtureStyle() {
        switch (teamID) {
            //Arsenal
            case 1:
                stylesheet = arsenalFixturesURL;
                break;
            //Chelsea
            case 2:
                stylesheet = chelseaFixturesURL;
                break;
            //Tottenham
            case 3:
                stylesheet = tottenhamFixturesURL;
                break;
            //Man City
            case 4:
                stylesheet = mancityFixturesURL;
                break;
            default:
                break;
        }
    }
/**
 * Sets the team name and team id depending on the button pressed
 * @param event The club buttons
 */
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
