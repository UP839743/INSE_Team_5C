/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

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
import javafx.stage.Stage;

/**
 * @author INSE Team 5C
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btnChelsea;
    @FXML
    private Button btnArsenal;
    @FXML
    private Button btnTottenham;
    @FXML
    private Button btnManCity;
// stylesheet URLs
    private final String chelseaThemeUrl = getClass().getResource("css/Chelsea.css").toExternalForm();
    private final String arsenalThemeUrl = getClass().getResource("css/Arsenal.css").toExternalForm();
    private final String tottenhamThemeUrl = getClass().getResource("css/Tottenham.css").toExternalForm();
    private final String mancityThemeUrl = getClass().getResource("css/Man City.css").toExternalForm();

// Global variables
    public static Scene scene;
    public static Stage stage;
    public static Parent root;
    public static String stylesheet = "";
    public static int teamID = 0;
    public static String teamName = "";
    public static String founder = "";
    public static String chairman = "";

    /**
     * loads the home page and loads a stylesheet depending on which team was
     * chosen. Also sets the default club by creating the ini file when a team
     * is chosen.
     *
     * @param event the club button that was pressed.
     * @throws IOException
     */
    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException, Exception {

        if (event.getSource() == btnChelsea) {
            FDB.createIniFile("Chelsea");

        } else if (event.getSource() == btnArsenal) {
            FDB.createIniFile("Arsenal");

        } else if (event.getSource() == btnTottenham) {
            FDB.createIniFile("Tottenham");

        } else if (event.getSource() == btnManCity) {
            FDB.createIniFile("Man City");

        }
        // Loads the home page
        loadClub(event);
        Button btn = (Button) event.getSource();
        stage = (Stage) btn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Home.fxml"));

        //create a new scene with root and set the stage
        scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(stylesheet);
        stage.show();
    }

    /**
     * Intialise class for the controller.
     *
     * @param url url of the fxml file.
     * @param rb The resource bundle used for the fxml file.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    /**
     * Selects a stylesheet and sets the team name. Depending on what club you
     * have picked via a button pressed.
     *
     * @param event The club button pressed.
     */
    public void loadClub(ActionEvent event) {
        // Arsenal
        if (event.getSource() == btnArsenal) {
            stylesheet = arsenalThemeUrl;
            teamName = "Arsenal";
            teamID = 1;
        }// Chelsea
        else if (event.getSource() == btnChelsea) {
            stylesheet = chelseaThemeUrl;
            teamName = "Chelsea";
            teamID = 2;
        }// Tottenham
        else if (event.getSource() == btnTottenham) {
            stylesheet = tottenhamThemeUrl;
            teamName = "Tottenham";
            teamID = 3;
        }// Man City
        else if (event.getSource() == btnManCity) {
            stylesheet = mancityThemeUrl;
            teamName = "Man City";
            teamID = 4;
        }

    }

}
