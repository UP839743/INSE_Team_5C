/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author accou
 */
public class FDB extends Application {
   
//    private String arsenalThemeUrl = getClass().getResource("@css/Arsenal.css").toExternalForm();
//    private String chelseaThemeUrl = getClass().getResource("@css/Chelsea.css").toExternalForm();
//    private String tottenhamThemeUrl = getClass().getResource("@css/Tottenham.css").toExternalForm();
//    private String manCityThemeUrl = getClass().getResource("@css/ManCity.css").toExternalForm();
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        
        Scene scene = new Scene(root);
//        scene.getStylesheets().add(arsenalThemeUrl);
//        scene.getStylesheets().add(chelseaThemeUrl);
//        scene.getStylesheets().add(tottenhamThemeUrl);
//        scene.getStylesheets().add(manCityThemeUrl);
        
        stage.setMaxHeight(930);
        stage.setMaxWidth(1400);
        stage.setMinHeight(930);
        stage.setMinWidth(1400);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
