/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemacscode;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class EnternewcodeController implements Initializable {
  private Parent fxml;
    @FXML
    private VBox oldvbox1;
    @FXML
    private TextField enteryournewcode;
    @FXML
    private Button codeenter;
    private String t;
    @FXML
    private Label label123;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
  
       

    }    

    @FXML
    private void sendcode(ActionEvent event) throws SQLException {
         System.out.println(label123.getText());
         ServiceUser us= new ServiceUser();
         System.out.println(us.serchwithmail(label123.getText()));
         System.out.println(us.serchwithmail(label123.getText()).get(0).getId());
           FXMLLoader load = new FXMLLoader(getClass().getResource("enternewpassword.fxml"));
            if(   us.resetpassword(enteryournewcode.getText(), us.serchwithmail(label123.getText()).get(0).getId()).isEmpty())
            {
                System.out.println("code incorrect");
            }
            else
            {
                
                     TranslateTransition t = new TranslateTransition(Duration.seconds(1), oldvbox1);
        t.setToX(oldvbox1.getLayoutX() * 20);
        t.play();
        t.setOnFinished((e) ->{
            try{
                Parent root =load.load();
                   EnternewpasswordController c2=  load.getController();
                   c2.setT(label123.getText());
                      
                oldvbox1.getChildren().removeAll();
                oldvbox1.getChildren().setAll(root);
            }catch(IOException ex){
                
            }
        });
                
                
                
            }
         
         
     
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
       
  label123.setText(t);

        
    }

 
    
}
