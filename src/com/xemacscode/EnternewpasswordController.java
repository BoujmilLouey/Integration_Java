/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemacscode;

import com.edu.project.entities.User;
import com.edu.project.services.ServiceUser;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class EnternewpasswordController implements Initializable {
    private String t;
    private Parent root;
    @FXML
    private VBox label28;
    private Label label27;
    @FXML
    private Text text27;
    @FXML
    private Label passlabell;
    @FXML
    private TextField newpassenter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    } 
    
        public void setT(String t) {
        this.t = t;
       
  passlabell.setText(t);

        
    }

    @FXML
    private void changepasscc(ActionEvent event) throws SQLException {
        ServiceUser s= new ServiceUser();
        User ss = new User();
        s.enternewpassword(newpassenter.getText(),s.serchwithmail(passlabell.getText()).get(0).getId());
        
        
           FXMLLoader load = new FXMLLoader(getClass().getResource("SignIn.fxml"));
    
     
        
        
        
        
        
        
        
        
        
         TranslateTransition t = new TranslateTransition(Duration.seconds(1), label28);
        t.setToX(label28.getLayoutX() * 20);
        t.play();
        t.setOnFinished((e) ->{
            try{
              
                    Parent root =load.load();
                   SignInController c2=  load.getController();
                  
                      
                label28.getChildren().removeAll();
                label28.getChildren().setAll(root);
            }catch(IOException ex){
                
            }
        });
    }
}
