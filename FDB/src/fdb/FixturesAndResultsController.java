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
     * Initializes the controller class.
     * 
     * 
     * @param url The parameter is the url for the controller.
     * @param rb ResourceBundle used by the controller.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblTeamName.setText(teamName);
        loadFixtureStyle();
        scene.getStylesheets().add(stylesheet);
        resultSeason.getSelectionModel().selectFirst();
        ObservableList<Fixture> fixtures = FXCollections.observableArrayList(FDB.populateFixtures(teamName));
        fixtureTable.setItems(fixtures);
        String season = (String) resultSeason.getValue();
        ObservableList<Fixture> results = FXCollections.observableArrayList(FDB.populateResults(teamName, season));
        resultTable.setItems(results);
    }

    @FXML
    public void search(KeyEvent keyEvent) throws IOException {
        //if key pressed is enter AND text box is not empty
        if (keyEvent.getCode() == KeyCode.ENTER && !"".equals(searchBar.getText())) {
            searchString = searchBar.getText();
            searchBar.setText("");
            root = FXMLLoader.load(getClass().getResource("Search Results.fxml"));
            Scene scene = new Scene(root);
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
        Scene scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(stylesheet);
        stage.show();

    }

    @FXML
    public void showSeasonPosition(ActionEvent event) {
        String season = (String) resultSeason.getValue();
        ObservableList<Fixture> results = FXCollections.observableArrayList(FDB.populateResults(teamName, season));
        resultTable.setItems(results);
    }

    public void loadFixtureStyle() {
        switch (teamID) {
            case 1:
                stylesheet = arsenalFixturesURL;

                break;
            case 2:
                stylesheet = chelseaFixturesURL;

                break;
            case 3:
                stylesheet = tottenhamFixturesURL;

                break;
            case 4:
                stylesheet = mancityFixturesURL;

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
