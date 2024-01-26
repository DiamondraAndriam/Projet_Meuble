/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import util.Util;

/**
 *
 * @author HERINIAINA
 */
public class Client {
    private int id;
    private String nom;
    private String prenom;
    private int genre;

    // setters & getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setId(String id) {
        setId(Integer.parseInt(id));
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
    
    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }
    public void setGenre(String genre) {
        setGenre(Integer.parseInt(genre));
    }
    
    // constructeur
    public Client(){}
    
    public Client(String id) throws Exception{
        try{
            this.setId(Integer.parseInt(id));}
        catch(NumberFormatException e){
            throw new Exception("Erreur parsing: id pas sous le format nombre");
        }
        this.findById(null);
    }

    // dao
    public void findById(Connection connection) throws Exception {
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet result = null;
        try{
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Select * from Client where id = ?");
            statement.setInt(1, this.getId());
            result= statement.executeQuery();
            while(result.next()){
                this.setNom(result.getString("nom"));
                this.setPrenom(result.getString("prenom"));
                this.setGenre(result.getInt("genre"));
            }
        } catch(Exception e){
            e.printStackTrace();
            throw new Exception("Erreur de sélection: ne peut pas trouver le [Client] avec cet id");
        } finally{
            if(result != null){
                result.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null && newConnection == true){
                connection.close();
            }
        }   
    }

    public static List<Client> findAll(Connection connection) throws Exception{
        List<Client> liste = new ArrayList<>();
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet result = null;
        try{
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Select * from client");
            result= statement.executeQuery();
            while(result.next()){
                Client client = new Client();
                client.setId(result.getInt("id_client"));
                client.setNom(result.getString("nom"));
                client.setPrenom(result.getString("prenom"));
                client.setGenre(result.getInt("genre"));
                liste.add(client);
            }
            return liste;
        } catch(Exception e){
            throw new Exception("Erreur de sélection: Ne peut pas avoir tous les éléments de Client");
        } finally{
            if(result != null){
                result.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null && newConnection == true){
                connection.close();
            }
        }
    }
    
    public void save(Connection connection)throws Exception{
        boolean newConnection = false;
        PreparedStatement statement = null;
        try {
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Insert into Client(nom,prenom,genre) values(?,?,?)");
            statement.setString(1, this.getNom());
            statement.setString(2, this.getPrenom());
            statement.setInt(3, this.getGenre());
            statement.executeUpdate();
        } catch(Exception e){
            throw e;
        } finally{
            if(statement != null){
                statement.close();
            }
            if(connection != null && newConnection == true){
                connection.close();
            }
        }
    }
    
    public void update(Connection connection)throws Exception{
        boolean newConnection = false;
        PreparedStatement statement = null;
        try {
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Update Client set nom = ? , prenom = ?, genre = ? where id = ?");
            statement.setInt(1, this.getId());
            statement.setString(2, this.getNom());
            statement.setInt(3, this.getGenre());
            statement.setString(4, this.getPrenom());
            statement.executeUpdate();
        } catch(Exception e){
            throw new Exception();
        } finally{
            if(statement != null){
                statement.close();
            }
            if(connection != null && newConnection == true){
                connection.close();
            }
        }
    }
 
    public Client getLast(Connection connection)throws Exception{
        Client client = new Client();
        PreparedStatement statement = null;
        ResultSet result = null;
        boolean newConnection = false;
        try{
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Select * from Facture order by id desc limit 1");
            result= statement.executeQuery();
            while(result.next()){
                client.setId(result.getInt("id"));
                client.setNom(result.getString("nom"));
                client.setPrenom(result.getString("prenom"));
                client.setGenre(result.getInt("genre"));
            }
        } catch(Exception e){
            throw e;
        } finally{
            if(result != null){
                result.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null && newConnection == true){
                connection.close();
            }
        }
        return client;
    }
    
    
}
