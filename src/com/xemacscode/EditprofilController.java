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
import java.sql.Date;
import java.sql.SQLException;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class EditprofilController implements Initializable {

    @FXML
    private AnchorPane ancherancher;
    @FXML
    private DatePicker datepickmeage;
    @FXML
    private TextField ffusername;
    @FXML
    private TextField ffname;
    @FXML
    private TextField fflast;
    @FXML
    private TextField ffpass;
    @FXML
    private TextField ffemail;
    @FXML
    private TextField ffnumtel;
    @FXML
    private Button cancelmodif;
    private int ide;
    /**
     * initialises the controller class.
     */
    
    User ue= new User();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifyprofile(ActionEvent event) throws SQLException, IOException {
        User u = new User();
        ServiceUser s = new ServiceUser();
        if (!ffusername.getText().equals(""))
        {
            u.setUsername(ffusername.getText());
        }
        else
            u.setUsername(ffusername.getPromptText());
        
             if (!ffname.getText().equals(""))
        {
            u.setNom(ffname.getText());
        }
        else
            u.setNom(ffname.getPromptText());
        
                  if (!fflast.getText().equals(""))
        {
            u.setPrenom(fflast.getText());
        }
        else
            u.setPrenom(fflast.getPromptText());
        
                       if (!ffpass.getText().equals(""))
        {
            u.setPassword(u.encrypt(ffpass.getText()));
        }
        else
            u.setPassword(ffpass.getPromptText());
        
                            if (!ffemail.getText().equals(""))
        {
            u.setEmail(ffemail.getText());
        }
        else
            u.setEmail(ffemail.getPromptText());
        
                                 if (!ffnumtel.getText().equals(""))
        {
           int i=Integer.parseInt(ffnumtel.getText());  

            u.setNumtel(i);
        }
        else
                                 {
                           int k=Integer.parseInt(ffnumtel.getPromptText());  

                               u.setNumtel(k);

                                 }
        Date d= new Date(datepickmeage.getValue().getYear(), datepickmeage.getValue().getMonthValue(), datepickmeage.getValue().getDayOfMonth());
        u.setAge(d);
        
        s.modifier(u);
        
        
        String sss=Integer.toString(u.getNumtel());
        
        
            FXMLLoader load = new FXMLLoader(getClass().getResource("profil.fxml"));
                   Parent root =load.load();
                   ProfilController c2=  load.getController();
                   c2.getinfo(u.getUsername(), u.getNom(),u.getPrenom(), u.getEmail(), u.getAge().toLocalDate(), sss, u.getPassword());
                     Scene ss= new Scene(root);
                   Stage se= new Stage();
                   se=(Stage)((Node)event.getSource()).getScene().getWindow();
                      se.setScene(ss);
                      se.show();
        
    }

 
    
      public void getinfo(String usernamelab,String firstnamelab,String lastnamelab,String emaillab,LocalDate datepicklab,String numtellab,String passwordlab)
    {
     this.ffusername.setPromptText(usernamelab);
     this.ffname.setPromptText(firstnamelab);
     this.fflast.setPromptText(lastnamelab);
     this.ffemail.setPromptText(emaillab);
     this.datepickmeage.setValue(datepicklab);
     this.ffnumtel.setPromptText(numtellab);
     this.ffpass.setPromptText(passwordlab);
    }

    @FXML
    private void cancelme(ActionEvent event) throws IOException {
          FXMLLoader load = new FXMLLoader(getClass().getResource("profil.fxml"));
                   Parent root =load.load();
                   ProfilController c2=  load.getController();
                   c2.getinfo(ffusername.getPromptText(), ffname.getPromptText(), fflast.getPromptText(), ffemail.getPromptText(), datepickmeage.getValue(), ffnumtel.getPromptText(), ffpass.getPromptText());
                     Scene ss= new Scene(root);
                   Stage s= new Stage();
                   s=(Stage)((Node)event.getSource()).getScene().getWindow();
                      s.setScene(ss);
                      s.show();
        
    }

    public User getUe() {
        return ue;
    }

    public void setUe(User ue) {
        this.ue = ue;
    }
    
}
