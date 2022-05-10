/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.project.Controller;

import com.edu.project.entities.User;
import com.xemacscode.MyListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class OneuserviewController implements Initializable {

    @FXML
    private Label username;
    @FXML
    private Label email;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label age;
    @FXML
    private Label role;
    @FXML
    private Label numtel;
        private User user;
    private MyListener myListener;
    /**
     * initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onclick(MouseEvent event) {
             myListener.onClickListener(user);
    
    }
    
    public void setData(User user, MyListener myListener) {
        this.user = user;
        this.myListener = myListener;
       
        username.setText(user.getUsername());
        email.setText(user.getUsername());
        nom.setText(user.getNom());
        prenom.setText(user.getPrenom());
        age.setText(user.getAge().toString());
        role.setText(user.getRole());
        numtel.setText(""+user.getNumtel());
    }
}
