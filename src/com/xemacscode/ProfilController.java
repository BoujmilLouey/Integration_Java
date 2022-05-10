/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemacscode;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class ProfilController implements Initializable {

    @FXML
    private Label usernamelab;
    @FXML
    private Label firstnamelab;
    @FXML
    private Label lastnamelab;
    @FXML
    private Label emaillab;
    @FXML
    private DatePicker datepicklab;
    @FXML
    private Label numtellab;
    @FXML
    private Label passwordlab;
    @FXML
    private Button db;
    @FXML
    private Button db1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void signmein(ActionEvent event) throws IOException {
          FXMLLoader load = new FXMLLoader(getClass().getResource("editprofil.fxml"));
                   Parent root =load.load();
                   EditprofilController c2=  load.getController();
                   c2.getinfo(usernamelab.getText(), firstnamelab.getText(), lastnamelab.getText(), emaillab.getText(), datepicklab.getValue(), numtellab.getText(), passwordlab.getText());
                      Scene ss= new Scene(root);
                   Stage s= new Stage();
                   s=(Stage)((Node)event.getSource()).getScene().getWindow();
                      s.setScene(ss);
           
              s.show();
    }
    public void getinfo(String usernamelab,String firstnamelab,String lastnamelab,String emaillab,LocalDate datepicklab,String numtellab,String passwordlab)
    {
     this.usernamelab.setText(usernamelab);
     this.firstnamelab.setText(firstnamelab);
     this.lastnamelab.setText(lastnamelab);
     this.emaillab.setText(emaillab);
     this.datepicklab.setValue(datepicklab);
     this.numtellab.setText(numtellab);
     this.passwordlab.setText(passwordlab);
    }

    @FXML
    private void Dashboard(ActionEvent event) throws IOException {
         AnchorPane root = FXMLLoader.load(getClass().getResource("/projet_java/Menu.fxml"));
       
         
        Stage Old_stage = (Stage) db.getScene().getWindow();
        Scene scene = new Scene(root);
        Stage stage = new Stage();    
        stage.setScene(scene);
        stage.setTitle("Participer a un evenement");
        
        
        
       Old_stage.close();
        stage.show();
    }

    @FXML
    private void commade(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("Login.fxml"));
       
         
        Stage Old_stage = (Stage) db.getScene().getWindow();
        Scene scene = new Scene(root);
        Stage stage = new Stage();    
        stage.setScene(scene);
        stage.setTitle("Participer a un evenement");
        
        
        
       Old_stage.close();
        stage.show();
    }
}
