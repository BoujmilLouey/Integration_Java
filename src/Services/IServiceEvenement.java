/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Evenement;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author sofia
 */
public interface IServiceEvenement {
    public void AddEvenement(Evenement e,FileInputStream fis);
    public void AddEvenement(Evenement e);
    public void DeleteEvenement(int id);
    public ObservableList<Evenement> SearchEvenements(String critera);
    public void UpdateEvenement(int id,String nom,String lieu,String Date);
    public boolean Checkid(int id) throws SQLException;
    public ObservableList<Evenement> GetEvenement() throws SQLException;
}
