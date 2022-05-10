/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.project.Controller;

import com.edu.project.entities.User;
import com.edu.project.services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class ModifieruserController implements Initializable {
        User u = new User();
        private int id;
    @FXML
    private AnchorPane anchorme;
    @FXML
        private ComboBox<String> combobox;
    /**
     * initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        combobox.getItems().add("admin");
        combobox.getItems().add("client");
        
    }    

    public void  getdata (User u)
    {
        
    }
    @FXML
    private void annuleruser(ActionEvent event) throws IOException {
         anchorme.setVisible(false);
        
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/com/edu/project/gui/usersview.fxml"));
                           Parent root =load.load();
                           UsersviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    }

    @FXML
    private void modifieruser(ActionEvent event) throws IOException, SQLException {
                         ServiceUser ue = new ServiceUser();
                         System.out.println(id);
                         ue.modifierrole(combobox.getValue(),id);
                        Alert a = new Alert(Alert.AlertType.INFORMATION, "votre utilisateur est modifier ");
                        a.show();
        
                          anchorme.setVisible(false);
        
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/com/edu/project/gui/usersview.fxml"));
                           Parent root =load.load();
                           UsersviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u=u;
        id=u.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
