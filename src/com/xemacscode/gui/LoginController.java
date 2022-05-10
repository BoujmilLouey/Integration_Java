package com.xemacscode.gui;

import com.xemacscode.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

/**
 *
 * @author yessin
 */
public class LoginController implements Initializable {



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
    private void frontend(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/com/xemacscode/gui/front/MainWindow.fxml"));
       
         
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();    
        stage.setScene(scene);
        stage.setTitle("Gestion des evenement/participant");
        
        
        
   
        stage.show();
        //}
        
        
        
        
        
        
        
    }

    @FXML
    private void backend(ActionEvent event) throws IOException {
         AnchorPane root = FXMLLoader.load(getClass().getResource("/com/xemacscode/gui/back/MainWindow.fxml"));
       
         
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();    
        stage.setScene(scene);
        stage.setTitle("Gestion des evenement/participant");
        
        
        
   
        stage.show();
        //}
    }
    }


   
   
