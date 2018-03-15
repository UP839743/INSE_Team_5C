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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Samuel
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
    private Button btnTottenham;
    @FXML
    private Button btnManCity;
    @FXML
    private TextField searchBar;
    @FXML
    private TableView<Player> searchTable;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Player> playersResults = FXCollections.observableArrayList(searchPlayers(searchString));
        searchTable.setItems(playersResults);
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
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
}
