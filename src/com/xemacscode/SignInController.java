/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemacscode;


import com.edu.project.Controller.UsersviewController;
import com.edu.project.entities.Client;
import com.edu.project.entities.User;
import com.edu.project.services.ServiceUser;
import com.sun.deploy.util.FXLoader;
import com.sun.javafx.scene.control.skin.ButtonSkin;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class SignInController implements Initializable {

    @FXML
    private VBox newvbox1;
    @FXML
    private Hyperlink forgetpass;
     private Parent fxml;
    @FXML
    private TextField emmail;
    @FXML
    private TextField password3;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void forgetmypass(ActionEvent event) {
      TranslateTransition t = new TranslateTransition(Duration.seconds(1), newvbox1);
        t.setToX(newvbox1.getLayoutX() * 20);
        t.play();
        t.setOnFinished((e) ->{
            try{
                fxml = FXMLLoader.load(getClass().getResource("forgetpassword.fxml"));
                newvbox1.getChildren().removeAll();
                newvbox1.getChildren().setAll(fxml);
            }catch(IOException ex){
                
            }
        });
    }

    @FXML
    private void signmein(ActionEvent event) throws SQLException, IOException {
        ServiceUser us = new ServiceUser();
       User ue = new User();
       ue=us.login(emmail.getText(),password3.getText()).get(0);
               String sss=Integer.toString(ue.getNumtel());

        System.out.println( us.login(emmail.getText(), password3.getText()));
        
        if ( us.login(emmail.getText(), password3.getText()).size()==1)
        {
             Alert a =new Alert(Alert.AlertType.INFORMATION, "log in  avec success");
             a.show();
                 if ( us.login(emmail.getText(),password3.getText()).get(0).getRole().equals("admin"))
                 {
                     
                     
                      FXMLLoader load = new FXMLLoader(getClass().getResource("/com/edu/project/gui/usersview.fxml"));
                           Parent root =load.load();
                           UsersviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
        
                 }
                 else
                 {
                     
                   
              FXMLLoader load = new FXMLLoader(getClass().getResource("profil.fxml"));
                   Parent root =load.load();
                   ProfilController c2=  load.getController();
                   c2.getinfo(ue.getUsername(), ue.getNom(),ue.getPrenom(), ue.getEmail(), ue.getAge().toLocalDate(), sss, ue.getPassword());
                     Scene ss= new Scene(root);
                   Stage se= new Stage();
                   se=(Stage)((Node)event.getSource()).getScene().getWindow();
                      se.setScene(ss);
                      se.show();
                     
                 }
                   
        }
        else
        {
              Alert a =new Alert(Alert.AlertType.ERROR, "username or password incorrect");
             a.show();
            
        }
       
    }
    
}
