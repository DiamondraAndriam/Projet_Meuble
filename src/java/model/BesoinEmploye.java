/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import util.Util;

/**
 *
 * @author Diamondra
 */
public class BesoinEmploye {
    private int id;
    private Meuble meuble;
    private HashMap<Poste,Integer> nombreEmploye;
    private double heure;
    
    public BesoinEmploye() {}

    // getters & setters
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Meuble getMeuble() {
        return meuble;
    }

    public void setMeuble(Meuble meuble) {
        this.meuble = meuble;
    }

    public double getHeure() {
        return heure;
    }

    public void setHeure(double heure) {
        this.heure = heure;
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
            statement = connection.prepareStatement("Select * from BesoinEmploye where id_meuble = ?");
            statement.setInt(1, this.getId());
            result= statement.executeQuery();
            while(result.next()){
                this.setId(result.getInt("id_besoin"));
            }
        } catch(Exception e){
            e.printStackTrace();
            throw new Exception("Erreur de sélection: ne peut pas trouver le BesoinEmploye avec cet id");
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

    public List<BesoinEmploye> findAll(Connection connection) throws Exception{
        List<BesoinEmploye> liste = new ArrayList<>();
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet result = null;
        try{
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Select * from BesoinEmploye");
            result= statement.executeQuery();
            while(result.next()){
                BesoinEmploye BesoinEmploye = new BesoinEmploye();
                BesoinEmploye.setId(result.getInt("id"));
                liste.add(BesoinEmploye);
            }
            return liste;
        } catch(Exception e){
            throw new Exception("Erreur de sélection: Ne peut pas avoir tous les éléments de BesoinEmploye");
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
            statement = connection.prepareStatement("Insert into BesoinEmploye(id,nom,details) values(?,?,?)");
            statement.setInt(1, this.getId());
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
            statement = connection.prepareStatement("Update BesoinEmploye set nom = ? , details = ? where id = ?");
            statement.setInt(1, this.getId());
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
 
    public BesoinEmploye getLast(Connection connection)throws Exception{
        BesoinEmploye BesoinEmploye = new BesoinEmploye();
        PreparedStatement statement = null;
        ResultSet result = null;
        boolean newConnection = false;
        try{
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Select * from BesoinEmploye order by id desc limit 1");
            result= statement.executeQuery();
            while(result.next()){
                BesoinEmploye.setId(result.getInt("id"));
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
        return BesoinEmploye;
    }
}
