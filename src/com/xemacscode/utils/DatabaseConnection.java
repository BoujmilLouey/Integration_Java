package com.xemacscode.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

       final static String URL = "jdbc:mysql://127.0.0.1:3306/panier_symfony";
    final static String LOGIN = "root";
    final static String PWD = "";
    static DatabaseConnection instance =null;
    private Connection cnx;

    private DatabaseConnection() {
      try
        {
        cnx=DriverManager.getConnection(URL, LOGIN, PWD);
        System.out.println("Connexion etablie ");
        }catch(SQLException ex){
            System.out.println("Pas de connexion");
        }
    }

    public static DatabaseConnection getInstance() {
          if(instance == null)
        {
            instance = new DatabaseConnection();
        }
        
        return instance;
    }
    
    public Connection getConnection()
    {
        return cnx;
    }
            
}

