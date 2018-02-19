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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author accou
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
            
    
    
     @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
     Stage stage; 
     Parent root;
     if(event.getSource()==btnChelsea || event.getSource()==btnArsenal || event.getSource()==btnTottenham || event.getSource()==btnManCity){
        //get reference to the button's stage         
        stage=(Stage) btnChelsea.getScene().getWindow();
        //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource("Home.fxml"));
     //create a new scene with root and set the stage
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
    }
 }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
