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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author sofia
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    private TextField tfnom;
    private TextField tfprenom;
    private TextField fsnomE;
    private TextField fsDateE;
    private TextField fsLieuE;
    @FXML
    private TextField fsNomE;
    @FXML
    private Label AEvenement;
    @FXML
    private TextField fsIdES;
    @FXML
    private TableView<Evenement> ViewEvenement;
    @FXML
    private TableColumn<Evenement, Integer> ViewId;
    @FXML
    private TableColumn<Evenement, String> ViewNomE;
    @FXML
    private TableColumn<Evenement, String> ViewLieu;
    @FXML
    private TableColumn<Evenement, String> ViewDate;
    @FXML
    private TableColumn<Evenement, String> ViewNbrPlace;
    
    ObservableList<Evenement> listM;
    ObservableList<Participants> listMP;
    int index = -1;
    private TextField fsDateEM;
    private TextField fsLieuEM;
    @FXML
    private TextField fsNomEM;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    private TextField fsDate;
    @FXML
    private TextField fsLieu;
    @FXML
    private TextField fsLieuM;
    @FXML
    private TextField fsDateM;
    @FXML
    private Button BoutonM;
    @FXML
    private TextField fsNbrPlace;
    @FXML
    private TableView<Participants> ViewParticipants;
    @FXML
    private TableColumn<Participants, Integer> ViewIdPP;
    @FXML
    private TableColumn<Participants, String> ViewNom;
    @FXML
    private TableColumn<Participants, String> ViewPrenom;
    @FXML
    private TableColumn<Participants, Integer> ViewAge;
    @FXML
    private TableColumn<Participants, Integer> ViewIdE;
    @FXML
    private TableColumn<Participants, String> ViewApprobationP;
    @FXML
    private DatePicker fsDateN;
    @FXML
    private ImageView ImageView;
    private Connection con = null;
    
    
    /*try{
    
    }catch()*/
    private File f = null;
    @FXML
    private TextField fsIdPA;
    @FXML
    private RadioButton fsradNom;
    @FXML
    private RadioButton fsradPrenom;
    @FXML
    private RadioButton fsradAge;
    @FXML
    private RadioButton fsradAppro;
    @FXML
    private AnchorPane FennetreAdmin;
    
    
    
    
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      Actualiser_tableE();
      Actualiser_tableP();
      con = Maconnexion.getInstance().getConnection();
      setCellValueFromTable();
        
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
    private void setCellValueFromTable()
    {
        ViewEvenement.setOnMouseClicked(e-> { 
          Evenement ev =  ViewEvenement.getItems().get(ViewEvenement.getSelectionModel().getSelectedIndex());
          System.out.println("clique");
          showEvenementImage(ev.getId());
          
                  
            
            
        });
    }
    public void Actualiser_tableE()
    {
        ViewId.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("id"));
        ViewNomE.setCellValueFactory(new PropertyValueFactory<Evenement,String>("nom"));
        ViewLieu.setCellValueFactory(new PropertyValueFactory<Evenement,String>("lieu"));
        ViewDate.setCellValueFactory(new PropertyValueFactory<Evenement,String>("date"));
        ViewNbrPlace.setCellValueFactory(new PropertyValueFactory<Evenement,String>("nbr_place"));
        ServiceEvenement sp = new ServiceEvenement();
        try{
        listM = sp.GetEvenement();
        }catch(SQLException e)
        {
            System.out.println("Probleme affichage table evenement (fel main)\n");
        }
        ViewEvenement.setItems(listM);
    }
      public void Actualiser_tableP()
    {
        ViewIdPP.setCellValueFactory(new PropertyValueFactory<>("id_participant"));
        ViewNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        ViewPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        ViewAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        ViewIdE.setCellValueFactory(new PropertyValueFactory<>("id_evenement"));
        ViewApprobationP.setCellValueFactory(new PropertyValueFactory<>("participation_approuve"));
        ServiceParticipants sp = new ServiceParticipants();
        try{
        listMP = sp.GetParticipant("select * from participants");
        }catch(SQLException e)
        {
            System.out.println("Probleme affichage table participant(fel main)\n");
        }
        ViewParticipants.setItems(listMP);
    }
    private void switch_nable(boolean mode)
    {
        label1.setDisable(mode);
        label2.setDisable(mode);
        label3.setDisable(mode);
        fsNomEM.setDisable(mode);
        fsLieuM.setDisable(mode);
        fsDateM.setDisable(mode);
        BoutonM.setDisable(mode);
    }

   
    @FXML
    private void ChooseFile(ActionEvent event) {
        FileChooser filechooser = new FileChooser();
        f = filechooser.showOpenDialog(ImageView.getScene().getWindow());
       
        try
        {
            
            FileInputStream fileInputStream = new FileInputStream(f);
           
            Image image = new Image(fileInputStream);
            
            ImageView.setImage(image);
        }catch(IOException e){
        
            System.out.println(e.getMessage());
            System.out.println("erreur fichier image");
        }
    }
    @FXML
    private void AjouterEvenement(ActionEvent event) throws FileNotFoundException  {
        if(!fsNomE.getText().equals("") && fsDateN.getValue() != null && !fsLieu.getText().equals("") && !fsNbrPlace.getText().equals(""))
        {
           if(Integer.parseInt(fsNbrPlace.getText()) > 0 && Integer.parseInt(fsNbrPlace.getText()) < 50 )
           {
        FileInputStream FS = null;
        try {
            ServiceEvenement sp = new ServiceEvenement();
            Evenement p = new Evenement();
            p.setNom(fsNomE.getText());
            LocalDate myDate = fsDateN.getValue();
            String dateS = myDate.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));
            p.setDate(dateS);
            p.setLieu(fsLieu.getText());
            p.setNbr_place(Integer.parseInt(fsNbrPlace.getText()));
            if(f!=null)
            {
            FS = new FileInputStream(f);
            sp.AddEvenement(p,FS);
            }
            else
            sp.AddEvenement(p);
            fsNomE.setText("");
            fsLieu.setText("");
            //fsDate.setText("");
            fsNbrPlace.setText("");
            Actualiser_tableE();
        }catch (FileNotFoundException ex) {
            System.out.println("erreur fichier");
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } 
           } 
        else
        { 
               System.out.println("Nombre de place doit etre compris entre 0 et 50");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Erreur");
        alert.setContentText("Nombre de place doit etre compris entre 0 et 50");
        alert.show(); 
        }
                
            
            //f.delete();
        
        }
        else
        {
            System.out.println("Veuiller remplir toute les case");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Erreur");
        alert.setContentText("Veuiller remplir toute les case");
        alert.show();
        }
    }

    private void AfficherEvenement(ActionEvent event) {
       /* ServiceEvenement sp = new ServiceEvenement();

            //sp.AfficherEvenement();
            System.out.println("affichage reussie\n");
     */
            
        }
    

    @FXML
    private void SupprimerEvenement(ActionEvent event) {
        ServiceEvenement sp = new ServiceEvenement();
        try
        {
        if(sp.Checkid(Integer.parseInt(fsIdES.getText())) == false)
            sp.DeleteEvenement(Integer.parseInt(fsIdES.getText()));
       
            
        
            }catch(SQLException e)
            {
                System.out.println("erreuur suppresion");
            }
        
        Actualiser_tableE();
    }

    @FXML
    private void ModifierForAppear(ActionEvent event) {
        switch_nable(false);
        ServiceEvenement sp = new ServiceEvenement();
        try
        {
        boolean test = sp.Checkid(Integer.parseInt(fsIdES.getText()));
        if(test == false)
            switch_nable(false); // existe 
        else
            switch_nable(true); //existe pas
        }catch(SQLException e)
        {
            System.out.println("Erreur recherche \n");
        }
        
        
            
        
        
    }

    @FXML
    private void ModifierEvenement(ActionEvent event) {
        ServiceEvenement sp = new ServiceEvenement();
        sp.UpdateEvenement(Integer.parseInt(fsIdES.getText()), fsNomEM.getText(), fsLieuM.getText(), fsDateM.getText());
        switch_nable(true);
        fsNomEM.setText("");
        fsLieuM.setText("");
        fsDateM.setText("");
        fsIdES.setText("");
        
        Actualiser_tableE();
    }

    @FXML
    private void Approuve_participant(ActionEvent event) throws SQLException {
        if(!fsIdPA.getText().equals(""))
        {
        String query = "update participants set approbation = 'Oui' where id =? ;";
        PreparedStatement stm = con.prepareStatement(query);
        stm.setInt(1, Integer.parseInt(fsIdPA.getText()));
        stm.executeUpdate();
        Actualiser_tableP();
        }
        else
            
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Erreur");
        alert.setContentText("Veuillez saisir l'id d'un participant");
        alert.show(); 
        }
    }

    @FXML
    private void TrieParNom(ActionEvent event) {
        try{
            ServiceParticipants sp = new ServiceParticipants();
        listMP = sp.GetParticipant("select * from participants order by nom");
        }catch(SQLException e)
        {
            System.out.println("Probleme affichage table participant(fel main)\n");
        }
        ViewParticipants.setItems(listMP);
        fsradPrenom.setSelected(false);
        fsradAge.setSelected(false);
        fsradAppro.setSelected(false);
    }

    @FXML
    private void TrieParPrenom(ActionEvent event) {
        try{
            ServiceParticipants sp = new ServiceParticipants();
        listMP = sp.GetParticipant("select * from participants order by prenom");
        }catch(SQLException e)
        {
            System.out.println("Probleme affichage table participant(fel main)\n");
        }
        ViewParticipants.setItems(listMP);
        fsradNom.setSelected(false);
        fsradAge.setSelected(false);
        fsradAppro.setSelected(false);
    }

    @FXML
    private void TrieParAge(ActionEvent event) {
        try{
            ServiceParticipants sp = new ServiceParticipants();
        listMP = sp.GetParticipant("select * from participants order by age");
        }catch(SQLException e)
        {
            System.out.println("Probleme affichage table participant(fel main)\n");
        }
        ViewParticipants.setItems(listMP);
        fsradPrenom.setSelected(false);
        fsradNom.setSelected(false);
        fsradAppro.setSelected(false);
    }

    @FXML
    private void TrieParApprobation(ActionEvent event) {
        try{
            ServiceParticipants sp = new ServiceParticipants();
        listMP = sp.GetParticipant("select * from participants order by approbation");
        }catch(SQLException e)
        {
            System.out.println("Probleme affichage table participant(fel main)\n");
        }
        ViewParticipants.setItems(listMP);
        fsradPrenom.setSelected(false);
        fsradNom.setSelected(false);
        fsradAge.setSelected(false);
    }
    

    @FXML
    private void RetourMenu(ActionEvent event) throws IOException {
         AnchorPane root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
       
         
        Stage Old_stage = (Stage) FennetreAdmin.getScene().getWindow();
        Scene scene = new Scene(root);
        Stage stage = new Stage();    
        stage.setScene(scene);
        stage.setTitle("Menu");
        
        
        
       Old_stage.close();
        stage.show();
    }

    
    
}