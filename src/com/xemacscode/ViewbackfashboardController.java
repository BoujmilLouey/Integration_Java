/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemacscode;

import com.edu.project.entities.User;
import com.edu.project.services.ServiceUser;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.WHITE;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class ViewbackfashboardController implements Initializable {

    @FXML
    private ListView<AnchorPane> listviewback;
    private Parent fxml;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<AnchorPane> pubss = FXCollections.observableArrayList();
        ServiceUser us = new ServiceUser();
        try {
            for (int i = 0; i < us.afficher().size(); i++) {
                User get = us.afficher().get(i);
                
               
                      FXMLLoader load = new FXMLLoader(getClass().getResource("viewoftableuser.fxml"));
                    ViewoftableuserController tt= new ViewoftableuserController();
                try {
                    Parent root =load.load();
                } catch (IOException ex) {
                    Logger.getLogger(ViewbackfashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
                   ViewoftableuserController c2=  load.getController();
                  c2.id=get.getId();
                  AnchorPane p = new AnchorPane(c2.getAncherofuser());
                  Label l= new Label(get.getNom(), tt.getNameofuser());
                    l.setLayoutX(154.0);
                    l.setLayoutY(64.0);
                    l.setPrefWidth(222.0);
                    l.setTextFill(BLACK);
                  Label l2= new Label(get.getPrenom(), tt.getLastnameofuser());
                   l2.setLayoutX(154.0);
                   l2.setLayoutY(129.0);
                    l.setPrefWidth(222.0);
                    l.setTextFill(BLACK);
                  Label l3= new Label(get.getEmail(), tt.getEmailofuser());
                   l3.setLayoutX(154.0);
                   l3.setLayoutY(187.0);
                    l.setPrefWidth(222.0);
                    l.setTextFill(BLACK);
                  Label l4= new Label(get.getUsername(), tt.getUsernameofuser());
                   l4.setLayoutX(154.0);
                   l4.setLayoutY(324.0);
                    l.setPrefWidth(222.0);
                    l.setTextFill(BLACK);
                     Label l5= new Label(get.getPassword(), tt.getPasswordofuser());
                   l5.setLayoutX(154.0);
                   l5.setLayoutY(274.0);
                    l.setPrefWidth(222.0);
                    l.setTextFill(BLACK);
                     Label l6= new Label(get.getAge().toString(), tt.getAgeofuser());
                   l6.setLayoutX(154.0);
                   l6.setLayoutY(234.0);
                    l.setPrefWidth(222.0);
                    l.setTextFill(BLACK);
                   
                   
                  p.getChildren().add(l);
                  p.getChildren().add(l2);
                  p.getChildren().add(l3);
                  p.getChildren().add(l4);
                  p.getChildren().add(l5);
                  p.getChildren().add(l6);
          
                  
                  

          pubss.add(p);
            }
            
            listviewback.getItems().setAll(pubss);
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ViewbackfashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }    
    
}
