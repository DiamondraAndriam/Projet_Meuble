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
import java.util.List;
import util.Util;

/**
 *
 * @author Diamondra
 */
public class StockMateriau {
    private int id;
    private Materiau materiau;
    private int quantite;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Materiau getMateriau() {
        return materiau;
    }

    public void setMateriau(Materiau materiau) {
        this.materiau = materiau;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    public double getMontant(){
        return this.getMateriau().getPrix()*quantite;
    }

    
    public StockMateriau(){}
    
    public StockMateriau(String idMateriau, String qte) throws Exception{
        setMateriau(new Materiau(idMateriau));
        setQuantite(qte);
    }
    
    public StockMateriau(int idMateriau, int qte) throws Exception{
        setMateriau(new Materiau(idMateriau));
        setQuantite(qte);
    }
    
    public void saveAchat(Connection connection) throws Exception{
        boolean newConnection = false;
        PreparedStatement statement = null;
        try {
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Insert into achat_materiau(id_materiau,quantite) values(?,?)");
            statement.setInt(1, this.getMateriau().getId());
            statement.setInt(2, quantite);
            statement.executeUpdate();
            statement = connection.prepareStatement("Insert into stock_materiau(id_materiau,quantite) values(?,?)");
            statement.setInt(1, this.getMateriau().getId());
            statement.setInt(2, quantite);
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
    
    public static List<StockMateriau> findAll(Connection connection) throws Exception{
        List<StockMateriau> liste = new ArrayList<>();
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet result = null;
        try{
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Select * from v_stock_materiau");
            result= statement.executeQuery();
            while(result.next()){
                Materiau materiau = new Materiau(result.getInt("id"));
                materiau.setNom(result.getString("nom"));
                materiau.setPrix(result.getDouble("prix"));
                StockMateriau stock = new StockMateriau();
                stock.setMateriau(materiau);
                stock.setQuantite(result.getInt("int"));
                liste.add(stock);
            }
            return liste;
        } catch(Exception e){
            throw new Exception("Erreur de sélection: Ne peut pas avoir tous les éléments de stock");
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
    
    public static List<StockMateriau> findByMateriau(Connection connection, String idMateriau) throws Exception{
        List<StockMateriau> liste = new ArrayList<>();
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet result = null;
        try{
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Select * from v_stock_materiau where nom like ?");
            statement.setString(1,idMateriau);
            result= statement.executeQuery();
            while(result.next()){
                Materiau materiau = new Materiau(result.getInt("id"));
                materiau.setNom(result.getString("nom"));
                materiau.setPrix(result.getDouble("prix"));
                StockMateriau stock = new StockMateriau();
                stock.setMateriau(materiau);
                stock.setQuantite(result.getInt("int"));
                liste.add(stock);
            }
            return liste;
        } catch(Exception e){
            throw new Exception("Erreur de sélection: Ne peut pas avoir tous les éléments de stock");
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

    private void setQuantite(String qte) throws Exception {
        try{
        setQuantite(Integer.parseInt(qte));
        } catch(Exception e){
            throw new Exception("Erreur de données d'entrée"); 
        }
    }

    public void save(Connection connection) throws Exception {
        boolean newConnection = false;
        PreparedStatement statement = null;
        try {
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Insert into stock_materiau(id_materiau,quantite) values(?,?)");
            statement.setInt(1, this.getMateriau().getId());
            statement.setInt(2, quantite);
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
    
    
}
