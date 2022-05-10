/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemacscode;

import com.edu.project.entities.Admin;
import com.edu.project.services.ServiceUser;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class ViewoftableuserController implements Initializable {

    @FXML
    private AnchorPane ancherofuser;
    @FXML
    private Label nameofuser;
    @FXML
    private Label lastnameofuser;
    @FXML
    private Label emailofuser;
    @FXML
    private Label ageofuser;
    @FXML
    private Label passwordofuser;
    @FXML
    private Label usernameofuser;
    public int id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public AnchorPane getAncherofuser() {
        return ancherofuser;
    }

    public void setAncherofuser(AnchorPane ancherofuser) {
        this.ancherofuser = ancherofuser;
    }

    public Label getNameofuser() {
        return nameofuser;
    }

    public void setNameofuser(Label nameofuser) {
        this.nameofuser = nameofuser;
    }

    public Label getLastnameofuser() {
        return lastnameofuser;
    }

    public void setLastnameofuser(Label lastnameofuser) {
        this.lastnameofuser = lastnameofuser;
    }

    public Label getEmailofuser() {
        return emailofuser;
    }

    public void setEmailofuser(Label emailofuser) {
        this.emailofuser = emailofuser;
    }

    public Label getAgeofuser() {
        return ageofuser;
    }

    public void setAgeofuser(Label ageofuser) {
        this.ageofuser = ageofuser;
    }

    public Label getPasswordofuser() {
        return passwordofuser;
    }

    public void setPasswordofuser(Label passwordofuser) {
        this.passwordofuser = passwordofuser;
    }

    public Label getUsernameofuser() {
        return usernameofuser;
    }

    public void setUsernameofuser(Label usernameofuser) {
        this.usernameofuser = usernameofuser;
    }

    @FXML
    private void ondeleteme(ActionEvent event) throws SQLException {
        ServiceUser us= new ServiceUser();
        Admin t= new Admin();
        us.supprimer(t, id);
        
        
    }
    
    
}
