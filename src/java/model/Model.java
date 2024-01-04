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
public class Model {
    private int id;
    private String nom;
    private String details;

    // setters & getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    
    // constructeur
    public Model(){}
    
    public Model(String id) throws Exception{
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
            statement = connection.prepareStatement("Select * from [Model] where id = ?");
            statement.setInt(1, this.getId());
            result= statement.executeQuery();
            while(result.next()){
                this.setNom(result.getString("nom"));
                this.setDetails(result.getString("details"));
            }
        } catch(Exception e){
            e.printStackTrace();
            throw new Exception("Erreur de sélection: ne peut pas trouver le [model] avec cet id");
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

    public List<Model> findAll(Connection connection) throws Exception{
        List<Model> liste = new ArrayList<>();
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet result = null;
        try{
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Select * from [Model]");
            result= statement.executeQuery();
            while(result.next()){
                Model model = new Model();
                model.setId(result.getInt("id"));
                model.setNom(result.getString("nom"));
                model.setDetails(result.getString("details"));
                liste.add(model);
            }
            return liste;
        } catch(Exception e){
            throw new Exception("Erreur de sélection: Ne peut pas avoir tous les éléments de [Model]");
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
            statement = connection.prepareStatement("Insert into [Model](id,nom,details) values(?,?,?)");
            statement.setInt(1, this.getId());
            statement.setString(2, this.getNom());
            statement.setString(3, this.getDetails());
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
            statement = connection.prepareStatement("Update [Model] set nom = ? , details = ? where id = ?");
            statement.setInt(1, this.getId());
            statement.setString(2, this.getNom());
            statement.setString(3, this.getDetails());
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
 
    public Model getLast(Connection connection)throws Exception{
        Model model = new Model();
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
                model.setId(result.getInt("id"));
                model.setNom(result.getString("nom"));
                model.setDetails(result.getString("details"));
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
        return model;
    }
    
    
}
