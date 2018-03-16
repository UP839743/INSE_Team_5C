/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

import static fdb.FDB.searchPlayers;
import static fdb.FXMLDocumentController.root;
import static fdb.FXMLDocumentController.stage;
import static fdb.FXMLDocumentController.stylesheet;
import static fdb.FXMLDocumentController.teamID;
import static fdb.FXMLDocumentController.teamName;
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
 * Search Results FXML Controller class
 *
 * @author INSE Team 5C
 */
public class SearchResultsController implements Initializable {

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
    private Button btnHome;
    @FXML
    private Button btnTottenham;
    @FXML
    private Button btnManCity;
    @FXML
    private TextField searchBar;
    @FXML
    private TableView<Player> searchTable;
    @FXML
    private Label resultsLabel;

    /**
     * Initialises the controller class. Sets up the search results page by
     * setting the label for the number of results found, loading the stylesheet and
     * populating the search table with the queried results.
     *
     * @param url The parameter is the url for the controller.
     * @param rb ResourceBundle used by the controller.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // list of players found.
        ObservableList<Player> playersResults = FXCollections.observableArrayList(searchPlayers(searchString));
        searchTable.setItems(playersResults);
        if (playersResults.size() != 0) {
            // states the number of results found.
            resultsLabel.setText(playersResults.size() + " Result(s) Found");
        }
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
            // loads the search page.
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
            selectClub(event);
            Button btn = (Button) event.getSource();
            stage = (Stage) btn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        }// loads the team details page. 
        else if (event.getSource() == btnTeamDetails) {
            stage = (Stage) btnTeamDetails.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Team Details.fxml"));
        }// loads the fixtures and results page. 
        else if (event.getSource() == btnFixtures) {
            stage = (Stage) btnFixtures.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Fixtures and Results.fxml"));
        }// loads the club details.
        else if (event.getSource() == btnClubDetails) {
            stage = (Stage) btnClubDetails.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Club Details.fxml"));
        }

        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(stylesheet);
        stage.show();

    }
/**
 * Sets the team name and ID to the selected team via the button pressed.
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
