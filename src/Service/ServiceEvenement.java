/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Evenement;
import Services.IServiceEvenement;
import Utils.Maconnexion;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author sofia
 */
public class ServiceEvenement implements IServiceEvenement {
    Connection cnx;
    
    
    
    @Override
    public ObservableList<Evenement> GetEvenement() throws SQLException {
       
            ObservableList<Evenement> list = FXCollections.observableArrayList();
            try {
                PreparedStatement ps = cnx.prepareStatement("SELECT id,nom_evenement,Date,lieu,nbr_place FROM evenement");
                ResultSet rs = ps.executeQuery();
                
                while(rs.next()){
                    list.add(new Evenement(Integer.parseInt(rs.getString("id")),rs.getString("Nom_evenement"),rs.getString("Lieu"),rs.getString("Date"),Integer.parseInt(rs.getString("Nbr_place")) ));
                }
                    
                
            }catch(SQLException e)
            {
                System.out.println("Probleme selection de table"); 
            }
                
         
        return list;
        
    }
    

    @Override
    public void DeleteEvenement(int id) {
        try
        {
       Statement stm = cnx.createStatement();
       String query = "DELETE FROM `evenement` WHERE id="+id+";";
       stm.executeUpdate(query);
       System.out.println("Suppression effectue avec succes");
        }catch(SQLException ex){
            System.out.println("Erreur Suppresions");
             
        }
       
    }
    
    public ObservableList<Evenement> SearchEvenements(String critera) {
        ObservableList<Evenement> myList = FXCollections.observableArrayList();
        try {
            String query = "SELECT id,Nom_evenement,Date,Lieu FROM evenement where ( Nom_evenement LIKE '%"+critera+"%' or Lieu LIKE '%"+critera+"%' );";
            Statement st = Maconnexion.getInstance().getConnection().createStatement();
            ResultSet res = st.executeQuery(query);
            System.out.print(query);
            

            while (res.next()) {
                Evenement c = new Evenement();
                c.setId(res.getInt("id"));
                c.setNom(res.getString("Nom_evenement"));
                c.setLieu(res.getString("Lieu"));
                c.setDate(res.getString("Date"));
               
                myList.add(c);
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return myList;
    }

    
   /* public ObservableList<Evenement> MyProductFilteredByName(String n) throws SQLException {

        ObservableList<Evenement> rec = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String requete = "Select * from annonce where text like '%" + n + "%'";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(requete);
            Evenement Evenement;
            while (rs.next()) {
                
                Evenement= new Evenement(rs.getInt(1), rs.getString(5), rs.getString(4), rs.getString(7), rs.getString(3), rs.getString(2), rs.getString(6));
                rec.add(Evenement);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rec;
    }*/

    public ServiceEvenement() {
        cnx = Maconnexion.getInstance().getConnection();
    }
    @Override
    public void AddEvenement(Evenement e) {
        try {
           
            //Statement stm = cnx.createStatement();
            
            //String query = "INSERT INTO `evenement`(`Nom_evenement`, `Lieu`, `Date`,`Nbr_place` ,`image`) VALUES ('"+e.getNom()+"','"+e.getLieu()+"','"+e.getDate()+"','"+e.getNbr_place()+"','"+numOfBytes+"');";
            String query = "insert into evenement(Nom_evenement, Lieu, Date,Nbr_place) values (?,?,?,?);";
            
            
            
            PreparedStatement stm = cnx.prepareStatement(query);
            stm.setString(1, e.getNom());
            stm.setString(2, e.getLieu());
            stm.setString(3, e.getDate());
            stm.setInt(4, e.getNbr_place());
            
            /*stm.setString(1, e.getNom());
            stm.setString(2, e.getLieu());
            stm.setString(3, e.getDate());
            stm.setInt(4, e.getNbr_place());*/
            
            
             stm.executeUpdate();
             System.out.println("Ajout avec succes");
        } catch (SQLException ex) {
            System.out.println("probleme ajout");
           
        }
    }
    @Override
    public void AddEvenement(Evenement e,FileInputStream fis) {
        try {
           
            //Statement stm = cnx.createStatement();
            
            //String query = "INSERT INTO `evenement`(`Nom_evenement`, `Lieu`, `Date`,`Nbr_place` ,`image`) VALUES ('"+e.getNom()+"','"+e.getLieu()+"','"+e.getDate()+"','"+e.getNbr_place()+"','"+numOfBytes+"');";
            String query = "insert into evenement(Nom_evenement, Lieu, Date,Nbr_place ,image) values (?,?,?,?,?);";
            
            
            
            PreparedStatement stm = cnx.prepareStatement(query);
            stm.setString(1, e.getNom());
            stm.setString(2, e.getLieu());
            stm.setString(3, e.getDate());
            stm.setInt(4, e.getNbr_place());
            stm.setBinaryStream(5, fis);
            /*stm.setString(1, e.getNom());
            stm.setString(2, e.getLieu());
            stm.setString(3, e.getDate());
            stm.setInt(4, e.getNbr_place());*/
            
            
             stm.executeUpdate();
             System.out.println("Ajout avec succes");
        } catch (SQLException ex) {
            System.out.println("probleme ajout");
            
        }
    }

    

    

    @Override
    public void UpdateEvenement(int id,String nom,String lieu,String date) {
        try {
            Statement stm = cnx.createStatement();
            String query = "UPDATE `evenement` SET `Nom_evenement`='"+nom+"',`Date`='"+date+"',`Lieu`='"+lieu+"' WHERE id="+id+"";
            stm.executeUpdate(query);
             System.out.println("Modification effectué avec succés");
            
             
        } catch (SQLException ex) {
            System.out.println("probleme modification");
            
        }
        
        
    }

    @Override
    public boolean Checkid(int id) throws SQLException {
            
                Statement stm = cnx.createStatement();
        String query = "SELECT * FROM `evenement` WHERE id="+id+"";
        ResultSet rs = stm.executeQuery(query);
        boolean empty = true;
        while( rs.next() ) {
         //ResultSet processing here
        empty = false;
                           }

        if( empty ) {
        System.out.println("L'id saisie  existe pas dans la table evenement");
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Erreur");
        alert.setContentText("L'id saisie  existe pas dans la table evenement");
        alert.show();
        }
        else
        System.out.println("L'id saisie  existe dans la table evenement");
         return empty;
        
        
           
        
    }
    
    
    
    
}
