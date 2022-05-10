/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author sofia
 */
public class Participants {
/*
    public static Object Stream() {
       Participants c = new Participants();
    List<Participants> list = Arrays.asList();
    list.stream().forEach(a ->
      System.out.println(a.getNom() + " " + a.getPrenom() + " " + a.getAge()));
 //To change body of generated methods, choose Tools | Templates.
        return null;
    }*/
    private int id_evenement,id_participant,age;
    private String nom,prenom,participation_approuve;

    public int getId_evenement() {
        return id_evenement;
    }

    public int getId_participant() {
        return id_participant;
    }

    public int getAge() {
        return age;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getParticipation_approuve() {
        return participation_approuve;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public void setId_participant(int id_participant) {
        this.id_participant = id_participant;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setParticipation_approuve(String participation_approuve) {
        this.participation_approuve = participation_approuve;
    }

    @Override
    public String toString() {
        return "Participants{" + "id_evenement=" + id_evenement + ", id_participant=" + id_participant + ", age=" + age + ", nom=" + nom + ", prenom=" + prenom + ", participation_approuve=" + participation_approuve + '}';
    }

    public Participants(int id_participant, String nom, String prenom, int age,int id_evenement, String participation_approuve) {
        this.id_evenement = id_evenement;
        this.id_participant = id_participant;
        this.age = age;
        this.nom = nom;
        this.prenom = prenom;
        this.participation_approuve = participation_approuve;
    }
    public Participants()
    {
        
    }
    
}
