/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Participants;
import Services.IServiceParticipants;
import Utils.Maconnexion;
import com.mysql.jdbc.MysqlDataTruncation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author sofia
 */
public class ServiceParticipants implements IServiceParticipants {
Connection cnx;
    public ServiceParticipants()
    {
    cnx = Maconnexion.getInstance().getConnection();
    }
    @Override
    public ObservableList<Participants> GetParticipant(String trie) throws SQLException {
         ObservableList<Participants> list = FXCollections.observableArrayList();
            try {
                PreparedStatement ps = cnx.prepareStatement(trie);
                ResultSet rs = ps.executeQuery();
                
                
                while(rs.next()){
                    list.add(new Participants(Integer.parseInt(rs.getString("id")),rs.getString("Nom"),rs.getString("prenom"),Integer.parseInt(rs.getString("age")),Integer.parseInt(rs.getString("id_evenement")), rs.getString("approbation")));
                }
                    
                
            }catch(SQLException e)
            {
                System.out.println("Probleme selection de table partcipants"); 
            }
              
         
        return list;
        
    }

    @Override
    public void AddParticipants(Participants par) {
         try {
          ServiceEvenement SE = new ServiceEvenement();
            if(!SE.Checkid(par.getId_evenement()))
            {
            String query = "insert into participants(nom, prenom, age, id_evenement) values (?,?,?,?);";
            PreparedStatement state = cnx.prepareStatement(query);
            state.setString(1, par.getNom());
            state.setString(2, par.getPrenom());
            state.setInt(3, par.getAge());
            state.setInt(4, par.getId_evenement());
             state.executeUpdate();
             System.out.println("Ajout avec succes");
             
             query = "update evenement set nbr_place = nbr_place - 1 where id =? ;";
             state = cnx.prepareStatement(query);
             state.setInt(1, par.getId_evenement());
             state.executeUpdate();
            }
            else
            {
                System.out.println("Selectionner une id d'evenement valide ");
            }
             
             
        } catch (SQLException ex) {
            System.out.println("probleme ajout");
            System.out.println("L'evenement est plein !");
            Logger.getLogger(ServiceParticipants.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
}
