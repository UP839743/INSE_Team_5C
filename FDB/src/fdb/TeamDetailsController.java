/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

import static fdb.FDB.populateClubPlayers;
import static fdb.FXMLDocumentController.*;
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
 * Team Details FXML Controller class
 *
 * @author INSE Team 5C
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
    @FXML
    private Button btnChangeDefaultClub;
    @FXML
    private TextField searchBar;

    private final String arsenalTeamDetailsURL = getClass().getResource("css/ArsenalTeamDetails.css").toExternalForm();
    private final String chelseaTeamDetailsURL = getClass().getResource("css/ChelseaTeamDetails.css").toExternalForm();
    private final String tottenhamTeamDetailsURL = getClass().getResource("css/TottenhamTeamDetails.css").toExternalForm();
    private final String mancityTeamDetailsURL = getClass().getResource("css/ManCityTeamDetails.css").toExternalForm();
    @FXML
    private TableView<Player> playerTable;
    public static String searchString = "";

    /**
     * Initializes the controller class. Sets up the team details page by
     * setting the team name for the label, loading the stylesheet and
     * populating the player table with the selected clubs players.
     *
     * @param url The parameter is the url for the controller.
     * @param rb ResourceBundle used by the controller.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblTeamName.setText(teamName);
        loadTeamStyle();
        scene.getStylesheets().add(stylesheet);
        // loads the players from the player class into a list and adds them to the table.
        ObservableList<Player> players = FXCollections.observableArrayList(populateClubPlayers(teamID));
        playerTable.setItems(players);

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
            // resets the search bar.
            searchBar.setText("");
            // loads the serach page
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
            // sets the team name and team id
            selectClub(event);
            Button btn = (Button) event.getSource();
            // sets the root and stage for the home page.
            stage = (Stage) btn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        } else if (event.getSource() == btnTeamDetails) {
            // sets the root and stage for the team details page.
            stage = (Stage) btnTeamDetails.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Team Details.fxml"));
        } else if (event.getSource() == btnFixtures) {
            // sets the root and stage for the fixtures page.
            stage = (Stage) btnFixtures.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Fixtures and Results.fxml"));
        } else if (event.getSource() == btnClubDetails) {
            // sets the root and stage for the club details page.
            stage = (Stage) btnClubDetails.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Club Details.fxml"));
        } else if (event.getSource() == btnChangeDefaultClub) {
            // sets the root and stage for the welcome page.
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
/**
 * selects the style for the page depending on the chosen team
 */
    public void loadTeamStyle() {
        switch (teamID) {
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
/**
 * Changes the team name and ID depending on which club button has been pressed.
 * @param event The club button pressed.
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
