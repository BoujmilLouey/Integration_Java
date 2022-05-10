/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_java;

import Entity.Evenement;
import Entity.Participants;
import Service.ServiceEvenement;
import Service.ServiceParticipants;
import Utils.Maconnexion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import static java.nio.file.Files.list;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sofia
 */
public class EvenementFOController implements Initializable {
    
    @FXML
    private TableView<Evenement> ViewEvenement;
    @FXML
    private TableColumn<Evenement, String> ViewNomE;
    @FXML
    private TableColumn<Evenement, String> ViewLieu;
    @FXML
    private TableColumn<Evenement, String> ViewDate;
    @FXML
    private TableColumn<Evenement, Integer> ViewNbrPlace;
    @FXML
    private TextField tfsearch;
    @FXML
    private Button btnsearch;
    int index = -1;
    ObservableList<Evenement> listM;
    @FXML
    private TextField fpNomP;
    @FXML
    private TextField fpPrenomP;
    @FXML
    private TextField fpAgeP;
    @FXML
    private Button bP;
    @FXML
    private ImageView ImageView;
    private Connection con = null;
    @FXML
    private AnchorPane FennetreUtilisateur;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceEvenement sp = new ServiceEvenement();
        try{
        listM = sp.GetEvenement();
        }catch(SQLException e)
        {
            System.out.println("Probleme affichage table evenement (fel main)\n");
        }
        Actualiser_tableE(listM);
        con = Maconnexion.getInstance().getConnection();
        setCellValueFromTable();
    }    
    private void setCellValueFromTable()
    {
        ViewEvenement.setOnMouseClicked(e-> { 
          Evenement ev =  ViewEvenement.getItems().get(ViewEvenement.getSelectionModel().getSelectedIndex());
         
          showEvenementImage(ev.getId());
          
                  
            
            
        });
    }
  
     private void showEvenementImage(int id)
    {
        try{
            
            PreparedStatement ps = con.prepareStatement("Select image from evenement where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                InputStream is = rs.getBinaryStream(1);
                OutputStream os = new FileOutputStream(new File("photo.jpg"));
                byte[] contents = new byte[1024];
                int size = 0;
                while((size = is.read(contents)) != -1){
                    os.write(contents, 0, size);
                    
                }
                Image i = new Image("file:photo.jpg",ImageView.getFitWidth(),ImageView.getFitHeight(),true,true);
                ImageView.setImage(i);
                    
            }
            
        }catch(SQLException e)
        {
            System.out.println("erreur sql");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Actualiser_tableE(ObservableList<Evenement> listM)
    {
        ViewNomE.setCellValueFactory(new PropertyValueFactory<Evenement,String>("nom"));
        ViewLieu.setCellValueFactory(new PropertyValueFactory<Evenement,String>("lieu"));
        ViewDate.setCellValueFactory(new PropertyValueFactory<Evenement,String>("date"));
        ViewNbrPlace.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("nbr_place"));
        
        ViewEvenement.setItems(listM);
    }

    @FXML
    private void AjouterParticipants(ActionEvent event) {
        if(ViewEvenement.getSelectionModel().getSelectedItem()==null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Erreur");
        alert.setContentText("Veuiller selectioné evenement du tableau");
        alert.show();
        }else{
         if(!fpNomP.getText().equals("") && !fpPrenomP.getText().equals("") && !fpAgeP.getText().equals("")  )
        {
        ServiceParticipants PP = new ServiceParticipants();
        Participants G = new Participants();
        G.setNom(fpNomP.getText());
        G.setPrenom(fpPrenomP.getText());
        G.setAge(Integer.parseInt(fpAgeP.getText()));
        G.setId_evenement(ViewEvenement.getSelectionModel().getSelectedItem().getId());
        
        PP.AddParticipants(G);
        ServiceEvenement sp = new ServiceEvenement();
        try{
        listM = sp.GetEvenement();
        }catch(SQLException e)
        {
            System.out.println("Probleme affichage table evenement (fel main)\n");
        }
        Actualiser_tableE(listM);
        }
         else
             System.out.println("Veuillez saisir tout les champ !");
         System.out.println("Veuiller remplir toute les case");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Erreur");
        alert.setContentText("Veuiller remplir toute les case");
        alert.show();
    }}

    @FXML
    private void RetourMenu(ActionEvent event) throws IOException {
         AnchorPane root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
       
         
        Stage Old_stage = (Stage) FennetreUtilisateur.getScene().getWindow();
        Scene scene = new Scene(root);
        Stage stage = new Stage();    
        stage.setScene(scene);
        stage.setTitle("Menu");
        
        
        
       Old_stage.close();
        stage.show();
    }
 
    @FXML
    private void SearchEvenements(InputMethodEvent event) {
        ServiceEvenement service=new ServiceEvenement();//esm l service
        listM=service.SearchEvenements(tfsearch.getText()); 
         Actualiser_tableE(listM);
        
    }

    @FXML
    private void recherche(ActionEvent event) {
        ServiceEvenement service=new ServiceEvenement();//esm l service
        listM=service.SearchEvenements(tfsearch.getText()); 
         Actualiser_tableE(listM);
    }
    
}