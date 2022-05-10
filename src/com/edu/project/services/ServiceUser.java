/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.project.services;

import com.edu.project.entities.Admin;
import com.edu.project.entities.User;
import com.edu.project.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author THEOLDISBACK
 */
public class ServiceUser implements Iservice<User> {
    private Connection cnx;
    
    public ServiceUser()
    {
        cnx= DBConnection.Getinstance().getCnx();
    }

    
    

       
    @Override
    public void ajouter(User t) throws SQLException{
     
         int k=0;
        
        List<User> users= new ArrayList<>();
        users=afficher();
        for (int i = 0; i < users.size(); i++) {
            User get = users.get(i);
            
            if (get.getUsername().equals(t.getUsername()))
            {
                k=1;
                System.out.println("this username is used");
            }
        }
        
  if (k==0)
         {
               
       String req="INSERT INTO `user`(`username`, `password`, `age`, `nom`, `prenom`, `role`, `numtel`, `email`) VALUES ('"+t.getUsername()+"','"+t.getPassword()+"','"+t.getAge().toString()+"','"+t.getNom()+"','"+t.getPrenom()+"','"+t.getRole()+"',"+t.getNumtel()+",'"+t.getEmail()+"');";
        Statement st=cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("ajouter avec success");
         }
    }
                                           
    /*   public void ajouter1(User t) throws SQLException{
       String req="INSERT INTO `user`(`username`, `password`, `age`) VALUES ( ?,?,?);";
         PreparedStatement pre=cnx.prepareStatement(req);
         pre.setString(1, t.getUsername());
         pre.setString(2, t.getPassword());
         pre.setInt(3, t.getAge());
         pre.executeUpdate(req);
           System.out.println("success!");
        
    }
*/
    @Override
    public void modifier(User t) throws SQLException{

        
        
        String req="UPDATE `user` SET `username`='"+t.getUsername()+"',`password`='"+t.getPassword()+"',`age`='"+t.getAge().toString()+"',`nom`='"+t.getNom()+"',`prenom`='"+t.getPrenom()+"',`numtel`="+t.getNumtel()+",`email`='"+t.getEmail()+"' WHERE email='"+t.getEmail()+"';";
        Statement st=cnx.createStatement();
        st.executeUpdate(req);
    }
  public void modifierrole(String role, int id) throws SQLException{

        
        
        String req="UPDATE `user` SET `role`='"+role+"' where id="+id;
        Statement st=cnx.createStatement();
        st.executeUpdate(req);
    }

    
    public void supprimer(User t,int t1) throws SQLException{
        
       if (t instanceof Admin)
       {
           
    
         String req="DELETE FROM `user` WHERE id="+t1+";";
   
        Statement st=cnx.createStatement();
        st.executeUpdate(req);
        }
       else
            System.out.println("only admin can delete");
    }

    @Override
    public List<User> afficher()  throws SQLException {
        List<User> users= new ArrayList<>();
        
        String req="SELECT * FROM user";
               Statement st=cnx.createStatement();
        ResultSet RS=st.executeQuery(req);
        
        while (RS.next()){
            
           
            User u = new User();
            u.setId(RS.getInt(1));
            u.setUsername(RS.getString(2));
             u.setPassword( u.decrypt(RS.getString(3)))   ;
            u.setAge(RS.getDate(4));
            u.setNom(RS.getString(5));
            u.setPrenom(RS.getString(6));
            u.setRole(RS.getString(7));
            u.setNumtel(RS.getInt(8));
            u.setEmail(RS.getString(9));
       //     u.setAge(RS.getInt(4));
       users.add(u);
            
        }
        
        return users;
    }

    @Override
    public void supprimer(int t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        public List<User> trierasc(String trier)  throws SQLException {
        List<User> users= new ArrayList<>();
        
        String req="SELECT * FROM `user` ORDER BY `user`.`"+trier+"` ASC";
               Statement st=cnx.createStatement();
        ResultSet RS=st.executeQuery(req);
        
        while (RS.next()){
            
           
            User u = new User();
            u.setId(RS.getInt(1));
            u.setUsername(RS.getString(2));
             u.setPassword( u.decrypt(RS.getString(3)))   ;
            u.setAge(RS.getDate(4));
            u.setNom(RS.getString(5));
            u.setPrenom(RS.getString(6));
            u.setRole(RS.getString(7));
            u.setNumtel(RS.getInt(8));
            u.setEmail(RS.getString(9));
       //     u.setAge(RS.getInt(4));
       users.add(u);
            
        }
        
        return users;
    }
          public List<User> trierdesc(String trier)  throws SQLException {
        List<User> users= new ArrayList<>();
        
        String req="SELECT * FROM `user` ORDER BY `user`.`"+trier+"` DESC";
               Statement st=cnx.createStatement();
        ResultSet RS=st.executeQuery(req);
        
        while (RS.next()){
            
           
            User u = new User();
            u.setId(RS.getInt(1));
            u.setUsername(RS.getString(2));
             u.setPassword( u.decrypt(RS.getString(3)))   ;
            u.setAge(RS.getDate(4));
            u.setNom(RS.getString(5));
            u.setPrenom(RS.getString(6));
            u.setRole(RS.getString(7));
            u.setNumtel(RS.getInt(8));
            u.setEmail(RS.getString(9));
       //     u.setAge(RS.getInt(4));
       users.add(u);
            
        }
        
        return users;
    }
            public List<User> rechercher(String chercher)  throws SQLException {
        List<User> users= new ArrayList<>();
        
        String req="SELECT * FROM user WHERE id like '%"+chercher+"%' or username like '%"+chercher+"%' or age like '%"+chercher+"%' or nom like '%"+chercher+"%' or prenom like '%"+chercher+"%' or role like '%"+chercher+"%' or numtel like '%"+chercher+"%' or email like '%"+chercher+"%'";
               Statement st=cnx.createStatement();
        ResultSet RS=st.executeQuery(req);
        
        while (RS.next()){
            
           
            User u = new User();
            u.setId(RS.getInt(1));
            u.setUsername(RS.getString(2));
             u.setPassword( u.decrypt(RS.getString(3)))   ;
            u.setAge(RS.getDate(4));
            u.setNom(RS.getString(5));
            u.setPrenom(RS.getString(6));
            u.setRole(RS.getString(7));
            u.setNumtel(RS.getInt(8));
            u.setEmail(RS.getString(9));
       //     u.setAge(RS.getInt(4));
       users.add(u);
            
        }
        
        return users;
    }
            
            
               public int generer(int ID_UTILISATEUR) throws SQLException{
        Random rand = new Random();
        int code = rand.nextInt((9999 - 1000) + 1) + 1000;
        
        String req="UPDATE `user` SET `CODE`= ? WHERE id=?";
            
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,code);
            pst.setInt(2,ID_UTILISATEUR);            
            pst.executeUpdate();
        return code;
    }
    public  List<User>  login (String username,String password) throws SQLException
    {
      List<User> users= new ArrayList<>();
        User c= new User();
        String req="SELECT * FROM user WHERE  username='"+username+"' and password='"+password+"'"; 
               Statement st=cnx.createStatement();
        ResultSet RS=st.executeQuery(req);
        
        while (RS.next()){
            
           
            User u = new User();
            u.setId(RS.getInt(1));
            u.setUsername(RS.getString(2));
             u.setPassword( u.decrypt(RS.getString(3)))   ;
            u.setAge(RS.getDate(4));
            u.setNom(RS.getString(5));
            u.setPrenom(RS.getString(6));
            u.setRole(RS.getString(7));
            u.setNumtel(RS.getInt(8));
            u.setEmail(RS.getString(9));
       //     u.setAge(RS.getInt(4));
       users.add(u);
            
        }
        if (users.size()==0)
            System.out.println("username or password incorrect");
        return users;
        
    }
    
    
      public  List<User>  serchwithmail (String mail) throws SQLException
    {
      List<User> users= new ArrayList<>();
        User c= new User();
        String req="SELECT id FROM user WHERE   email='"+mail+"';"; 
               Statement st=cnx.createStatement();
        ResultSet RS=st.executeQuery(req);
        
        while (RS.next()){
            
           
            User u = new User();
            u.setId(RS.getInt(1));
           
       //     u.setAge(RS.getInt(4));
       users.add(u);
            
        }
        if (users.size()==0)
            System.out.println("username or password incorrect");
        return users;
        
    }
    
      
      
    public List<User>  resetpassword (String code,int id) throws SQLException
    {
              List<User> users= new ArrayList<>();

        String req="SELECT * FROM user WHERE code="+code+" AND id="+id;
               Statement st=cnx.createStatement();
        ResultSet RS=st.executeQuery(req);
          while (RS.next()){
            
           
            User u = new User();
            u.setId(RS.getInt(1));
            u.setUsername(RS.getString(2));
             u.setPassword( u.decrypt(RS.getString(3)))   ;
            u.setAge(RS.getDate(4));
            u.setNom(RS.getString(5));
            u.setPrenom(RS.getString(6));
            u.setRole(RS.getString(7));
            u.setNumtel(RS.getInt(8));
            u.setEmail(RS.getString(9));
       //     u.setAge(RS.getInt(4));
       users.add(u);
            
        }
          if(users.size()==0)
          {
              System.out.println("code incorrect");
          }
    
       return  users;
    }
    public void enternewpassword (String password, int id) throws SQLException
    {
          
        String req="UPDATE `user` SET `password`='"+password+"' WHERE id="+id+";";
        Statement st=cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("mot de passe a changer");
    }
    
    
      public boolean isValidEmailAddress(String email) {
           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(email);
           return m.matches();
    }
}
