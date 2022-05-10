/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_java;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author sofia
 */
public class MenuController implements Initializable {

    @FXML
    private AnchorPane FenntreSeConnecter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("salut");
        
        // TODO
    }    

    @FXML
    private void Se_Connecter(ActionEvent event) throws IOException {
        /*if((fsPseudo.getText().toUpperCase().equals("ADMIN")) && (fsPswd.getText().toUpperCase().equals("ADMIN")))
        {*/
            AnchorPane root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       
         
        Stage Old_stage = (Stage) FenntreSeConnecter.getScene().getWindow();
        Scene scene = new Scene(root);
        Stage stage = new Stage();    
        stage.setScene(scene);
        stage.setTitle("Gestion des evenement/participant");
        
        
        
       Old_stage.close();
        stage.show();
        //}
        
        
        
        
        
        
        
    }

    @FXML
    private void Se_connecterU(ActionEvent event)  throws IOException {
         AnchorPane root = FXMLLoader.load(getClass().getResource("EvenementFO.fxml"));
       
         
        Stage Old_stage = (Stage) FenntreSeConnecter.getScene().getWindow();
        Scene scene = new Scene(root);
        Stage stage = new Stage();    
        stage.setScene(scene);
        stage.setTitle("Participer a un evenement");
        
        
        
       Old_stage.close();
        stage.show();
    }
      @FXML
    private void PDF (ActionEvent event)  throws IOException {
         
    }

    
}
