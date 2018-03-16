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
import static fdb.TeamDetailsController.searchString;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * Home FXML Controller class
 *
 * @author INSE Team 5C
 */
public class HomeController implements Initializable {

    @FXML
    private Label lblTeamName;
    @FXML
    private Label lblStory;
    @FXML
    private ComboBox<String> seasonBox;
    @FXML
    private Label lblCurrentPosition;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnTeamDetails;
    @FXML
    private Button btnFixtures;
    @FXML
    private Button btnClubDetails;
    @FXML
    private Button btnArsenal;
    @FXML
    private Button btnChelsea;
    @FXML
    private Button btnTottenham;
    @FXML
    private Button btnManCity;
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
    @FXML
    private Button btnChangeDefaultClub;
    @FXML
    private TextField searchBar;

    // stylesheet URLs
    private final String chelseaThemeUrl = getClass().getResource("css/Chelsea.css").toExternalForm();
    private final String arsenalThemeUrl = getClass().getResource("css/Arsenal.css").toExternalForm();
    private final String tottenhamThemeUrl = getClass().getResource("css/Tottenham.css").toExternalForm();
    private final String mancityThemeUrl = getClass().getResource("css/Man City.css").toExternalForm();
    // variable to check first time set up
    private static Boolean intialised = false;

    /**
     * Initializes the controller class. Checks if the program is on it's intial
     * run. If it is the team ID is taken from the ini file.
     *
     * @param url url of the controller
     * @param rb resources used by the controller
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // checks if the program has been intialised
        if (!intialised) {
            try {
                // reads the ini file to find teamID
                teamID = FDB.readIniFile();

                intialised = true;
            } catch (Exception ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            // laods the home page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            try {
                root = loader.load();
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            // loads stylesheet
            Scene scene = new Scene(root);
            scene.getStylesheets().add(stylesheet);
        }
        // updates the page for the selected team.
        loadHomeStyle();
        lblTeamName.setText(teamName);
        lblFounderName.setText(founder);
        lblChairmanName.setText(chairman);
        lblStadiumName.setText(populateStadiumName(teamID));
        lblManagerName.setText(populateManagerName(teamID));
        lblLeagueName.setText("Premier League");
        seasonBox.getSelectionModel().selectFirst();
        lblCurrentPosition.setText("" + FDB.populatePosition(seasonBox.getValue(), teamID));
        lblStory.setText(FDB.populateNews(teamID));

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
            // resets search bar
            searchBar.setText("");
            // loads the search page
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
            loadClub(event);
            Button btn = (Button) event.getSource();
            stage = (Stage) btn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        }// loads the team details page 
        else if (event.getSource() == btnTeamDetails) {
            stage = (Stage) btnTeamDetails.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Team Details.fxml"));
        }// loads the fixtures page
        else if (event.getSource() == btnFixtures) {
            stage = (Stage) btnFixtures.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Fixtures and Results.fxml"));
        }// loads the club details page
        else if (event.getSource() == btnClubDetails) {
            stage = (Stage) btnClubDetails.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Club Details.fxml"));
        }// loads the welcome page
        else if (event.getSource() == btnChangeDefaultClub) {
            stage = (Stage) btnChangeDefaultClub.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
            stylesheet = "WelcomeFromChangeDefaultClub.css";
        }
        scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(stylesheet);
        stage.show();

    }

    /**
     * sets the season position label to the current value of the combo box.
     *
     * @param event the value of the selected option from the combo box
     */
    @FXML
    public void showSeasonPosition(ActionEvent event) {
        lblCurrentPosition.setText(Integer.toString(populatePosition(seasonBox.getValue(), teamID)));
    }

    /**
     * Sets the team id for the selected club
     *
     * @param event the club button pressed.
     */
    public void loadClub(ActionEvent event) {

        if (event.getSource() == btnArsenal) {
            teamID = 1;
        } else if (event.getSource() == btnChelsea) {
            teamID = 2;
        } else if (event.getSource() == btnTottenham) {
            teamID = 3;
        } else if (event.getSource() == btnManCity) {
            teamID = 4;
        }

    }

    /**
     * Sets the team name, stylesheet, founder and chairman for the selected
     * team.
     */
    public void loadHomeStyle() {
        switch (teamID) {
            case 1:
                teamName = "Arsenal";
                stylesheet = arsenalThemeUrl;
                founder = "David Danskin";
                chairman = "Chips Keswik";
                break;
            case 2:
                teamName = "Chelsea";
                stylesheet = chelseaThemeUrl;
                founder = "Gus & Joseph Mears";
                chairman = "Bruce Buck";
                break;
            case 3:
                teamName = "Tottenham";
                stylesheet = tottenhamThemeUrl;
                founder = "Robert Buckle, Sam Casey & John Anderson";
                chairman = "Daniel Levy";
                break;
            case 4:
                teamName = "Man City";
                stylesheet = mancityThemeUrl;
                founder = "Anna & Arthur Connell, William Beastow  & Thomas Goodbehere";
                chairman = "Khaldoon Al Mubarak";
                break;
            default:
                break;

        }

    }

}
