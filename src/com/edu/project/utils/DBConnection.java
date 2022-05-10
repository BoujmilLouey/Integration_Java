/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.project.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author THEOLDISBACK
 */
public class DBConnection {
   
    private static DBConnection instance;
    private Connection  cnx;
    private final String URL="jdbc:mysql://localhost:3306/pi_java";
    private final String USER="root";
    private final String PWD="";

    public Connection getCnx() {
        return cnx;
    }
    
    private DBConnection()
    {
        try {
            cnx=DriverManager.getConnection(URL, USER, PWD);
            System.out.println("Connected Successfully!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    public static DBConnection Getinstance (){
        if(instance==null)
        instance= new DBConnection();
        return instance;
    } 
}
