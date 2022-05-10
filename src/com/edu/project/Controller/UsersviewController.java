/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.project.Controller;

import com.edu.project.entities.Admin;
import com.edu.project.entities.User;
import com.edu.project.services.ServiceUser;
import com.xemacscode.MyListener;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author THEOLDISBACK
 */
public class UsersviewController implements Initializable {

    @FXML
    private VBox chosenFruitCard;
    private Label campname;
    private Label prixcamp;
    @FXML
    private ImageView fruitImg;
    private Label nbplace;
    private Label region;
    private Label type;
    private Label datedeb;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private AnchorPane anchorforedit;
private List<User>  users= new ArrayList<>();
private User currentuser;
    private Image image;
    private MyListener myListener;
    @FXML
    private Label username;
    @FXML
    private Label userrole;
    @FXML
    private Label userage;
    @FXML
    private Label usernumtel;
    @FXML
    private Label useremail;
    @FXML
    private Label usernom;
    @FXML
    private Label userprenom;
    @FXML
    private TextField searchbox;
    private Parent fxml;
    /**
     * initialises the controller class.
     */
    
     private List<User> getData() throws SQLException {
      
            List<User> users = new ArrayList<>();
        ServiceUser s = new ServiceUser();
        User user1;

        for (int i = 0; i < s.afficher().size(); i++) {
            User get = s.afficher().get(i);
            
            
            user1 = new User();
            user1.setId(get.getId());
            user1.setAge(get.getAge());
            user1.setEmail(get.getEmail());
            user1.setNom(get.getNom());
            user1.setPrenom(get.getPrenom());
            user1.setPassword(get.getPassword());
            user1.setRole(get.getRole());
            user1.setNumtel(get.getNumtel());
            user1.setUsername(get.getUsername());
           
            
         
            users.add(user1);
        }
    

      
        return users;
    }
     
     private List<User> getDatafromsearcg() throws SQLException {
      
            List<User> users = new ArrayList<>();
        ServiceUser s = new ServiceUser();
        User user1;

        for (int i = 0; i < s.rechercher(searchbox.getText()).size(); i++) {
            User get = s.rechercher(searchbox.getText()).get(i);
            
            
            user1 = new User();
            user1.setId(get.getId());
            user1.setAge(get.getAge());
            user1.setEmail(get.getEmail());
            user1.setNom(get.getNom());
            user1.setPrenom(get.getPrenom());
            user1.setPassword(get.getPassword());
            user1.setRole(get.getRole());
            user1.setNumtel(get.getNumtel());
            user1.setUsername(get.getUsername());
           
            
         
            users.add(user1);
        }
    

      
        return users;
    }
     
     private void setChosenCamping(User user) {
       
    }
     
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         anchorforedit.setVisible(false);
            grid.getChildren().clear();
        try {
            // TODO
            afficher();
        } catch (SQLException ex) {
         
        }
  
    }    
    
    
    
    
    public void afficher() throws SQLException
    {
               users.addAll(getData());
               if (users.size() > 0) {
            setChosenCamping(users.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(User user) {
                    setChosenCamping(user);
                
                
                }

              

          

            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < users.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/edu/project/gui/oneuserview.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                OneuserviewController oneuserviewController = fxmlLoader.getController();
                oneuserviewController.setData(users.get(i),myListener);

                if (column == 1) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void modifieruser(ActionEvent event) throws IOException {
    anchorforedit.setVisible(true);
           
                fxml = FXMLLoader.load(getClass().getResource("/com/edu/project/gui/modifieruser.fxml"));
                         FXMLLoader load = new FXMLLoader(getClass().getResource("/com/edu/project/gui/modifieruser.fxml"));
                           Parent root =load.load();
                           ModifieruserController c2=  load.getController();
                           c2.setId(currentuser.getId());
                          fxml=root;
                            anchorforedit.getChildren().removeAll();
                             anchorforedit.getChildren().setAll(fxml);
                              anchorforedit.setVisible(true);   
    
    }

    @FXML
    private void supprimeruser(ActionEvent event) throws SQLException, IOException {
   
          ServiceUser u = new ServiceUser();
        u.supprimer(new Admin(), currentuser.getId());
        fxml = FXMLLoader.load(getClass().getResource("/com/edu/project/gui/usersview.fxml"));
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
    private void searchmewell(KeyEvent event) throws SQLException {
        if (  searchbox.getText().equals(""))
        {
            users.clear();
             afficher();
        }
        else
        {
            grid.getChildren().clear();
           users.clear();
               users.addAll(getDatafromsearcg());
               if (users.size() > 0) {
            setChosenCamping(users.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(User user) {
                    setChosenCamping(user);
                   
                
                
                }

               

          

            };
        }
        int column = 0;
        int row = 1;
        try {
     
            for (int i = 0; i < users.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/edu/project/gui/oneuserview.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                OneuserviewController oneuserviewController = fxmlLoader.getController();
                oneuserviewController.setData(users.get(i),myListener);

                if (column == 1) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        }
    
    
    }

    @FXML
    private void backtomain(ActionEvent event) throws IOException {
      
    }

    @FXML
    private void gotoformation(MouseEvent event) throws IOException {
          
    }



}
