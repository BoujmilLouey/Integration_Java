/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.project.entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author THEOLDISBACK
 */
public class User {
    private int key=5;
    private int id;
    private String username,password;
    private Date age;
    private  String nom;
    private  String prenom;
    private  String role;
    private  int numtel;
    private  String email;

    public User() {
    }

    
    
    
    public User(int id, String username, String password, Date age, String nom, String prenom, String role, int numtel, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.numtel = numtel;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", nom=" + nom + ", prenom=" + prenom + ", role=" + role + ", numtel=" + numtel + ", email=" + email + '}';
    }

    
    public String encrypt (String text)
    {
        String altern="";
        char[] chars= text.toCharArray();
        for(char c: chars) {
            c+=this.key;
            altern+=c;
        }
        return altern;
    }
    public String decrypt (String text)
    {
                String altern="";

       
        char[] chars= text.toCharArray();
        for(char c: chars) {
            c-=this.key;
            altern+=c;
        }
       
        return altern;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }
  
    
}
