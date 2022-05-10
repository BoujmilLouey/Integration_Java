/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemacscode;

import com.edu.project.entities.User;
import com.edu.project.services.Mail;
import com.edu.project.services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class ForgetpasswordController implements Initializable {

    private Parent fxml;
    @FXML
    private VBox newvbox2;
    @FXML
    private TextField emailv3;
    /**
     * initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendthismail(ActionEvent event) throws SQLException, Exception {
        int code=0;
        ServiceUser us = new ServiceUser();
        code = us.generer(7);
        Mail.sendMail(emailv3.getText(), code);
   
        
        FXMLLoader load = new FXMLLoader(getClass().getResource("enternewcode.fxml"));
    

        
        
         TranslateTransition t = new TranslateTransition(Duration.seconds(1), newvbox2);
        t.setToX(newvbox2.getLayoutX() * 20);
        t.play();
        t.setOnFinished((e) ->{
            try{
              
                    Parent root =load.load();
                   EnternewcodeController c2=  load.getController();
                    c2.setT(emailv3.getText());
                      
                newvbox2.getChildren().removeAll();
                newvbox2.getChildren().setAll(root);
            }catch(IOException ex){
                
            }
        });
    }
    
}
