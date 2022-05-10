/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author sofia
 */
public class Evenement {
    private int id,nbr_place;
    private String nom,lieu,date;

    public Evenement(int id, String nom, String lieu, String date,int nbr_place) {
        this.id = id;
        this.nbr_place = nbr_place;
        this.nom = nom;
        this.lieu = lieu;
        this.date = date;
    }
    public Evenement()
    {
        
    }

    public int getId() {
        return id;
    }

    public int getNbr_place() {
        return nbr_place;
    }

    public String getNom() {
        return nom;
    }

    public String getLieu() {
        return lieu;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNbr_place(int nbr_place) {
        this.nbr_place = nbr_place;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", nbr_place=" + nbr_place + ", nom=" + nom + ", lieu=" + lieu + ", date=" + date + '}';
    }

    
    
    
}
