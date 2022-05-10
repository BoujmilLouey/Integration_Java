/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemacscode;

import com.edu.project.entities.Client;
import com.edu.project.entities.User;
import com.edu.project.services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javax.validation.constraints.AssertTrue;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField firstname1;
    @FXML
    private TextField lastname1;
    @FXML
    private TextField username1;
    @FXML
    private DatePicker datepick1;
    @FXML
    private TextField phonenumber1;
    @FXML
    private TextField email1;
    @FXML
    private TextField password1;
    @FXML
    private VBox newvbox77;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void signmeup(ActionEvent event) throws SQLException {
      String  regexPattern = "^(.+)@(\\S+)$";
        ServiceUser us = new ServiceUser();
        User u = new User();

        if ((!firstname1.getText().equals("")) && (!lastname1.getText().equals("")) && (!username1.getText().equals("")) && (!phonenumber1.getText().equals("")) && (us.isValidEmailAddress(email1.getText())) &&(!password1.getText().equals(""))) 
        {
                  Date d= new Date(datepick1.getValue().getYear(), datepick1.getValue().getMonthValue(), datepick1.getValue().getDayOfMonth());

             int i=Integer.parseInt(phonenumber1.getText());  
        us.ajouter(new Client(username1.getText(),u.encrypt(password1.getText()),d, firstname1.getText(), lastname1.getText(), i, email1.getText()));
        
        
   FXMLLoader load = new FXMLLoader(getClass().getResource("SignIn.fxml"));

      TranslateTransition t = new TranslateTransition(Duration.seconds(1), newvbox77);
        t.setToX(newvbox77.getLayoutX() * 20);
        t.play();
        t.setOnFinished((e) ->{
            try{
                Parent root =load.load();
                   SignInController c2=  load.getController();
                 
                      
                newvbox77.getChildren().removeAll();
                newvbox77.getChildren().setAll(root);
            }catch(IOException ex){
                
            }
        });
        
            
            
        }
        else 
        {
            
             firstname1.setPromptText("veiller remplir le nom");
             lastname1.setPromptText("veiller remplir le prenom");
             username1.setPromptText("veiller remplir le pseudo nom");
             phonenumber1.setPromptText("veiller remplir le numtel");
             email1.setPromptText("veiller remplir le email");
             password1.setPromptText("veiller choisir le mot de passe");
            Alert a = new Alert(Alert.AlertType.ERROR,"veiller remplir le formulaire " );
            a.show();
        }

       
        
        
        
        
        
        
        
        
                }
}
