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
public class Fabrication {
    private int id;
    private Meuble meuble;
    private int quantite;

    public Fabrication(String idmeuble, String nb) {
        setMeuble(idmeuble);
        setQuantite(nb);
    }

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

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    public void fabriquer(Connection connection) throws Exception{
        boolean newConnection = false;
        try {
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            check(connection);
            save(connection);
        } catch (Exception e){
            throw e;
        } finally{
            if(connection != null && newConnection == true){
                connection.close();
            }
        }
    }

    private void save(Connection connection) throws Exception {
        boolean newConnection = false;
        PreparedStatement statement = null;
        try {
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("INSERT INTO fabrication\n" +
                    "(id_meuble, nombre) VALUES ( ?, ?);");
            statement.setInt(1, this.getMeuble().getId());
            statement.setInt(2, this.getQuantite());
            statement.executeUpdate();
            List<FormuleQuantite> formule = meuble.getFormules(connection);
            for (FormuleQuantite formuleQuantite : formule) {
                StockMateriau stock = new StockMateriau(formuleQuantite.getMateriau().getId(), -formuleQuantite.getQuantite()*this.getQuantite());
                stock.save(connection);
            }
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

    private void check(Connection connection) throws Exception {
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("select * from v_fab_meuble_stock_materiau where id_meuble = ?");
            statement.setInt(1, meuble.getId());
            rs = statement.executeQuery();
            List<StockMateriau> reste = new ArrayList<>();
            while(rs.next()){
                int resteFab = rs.getInt("quantite_stock") - rs.getInt("quantite_materiau")*quantite;
                StockMateriau stock = new StockMateriau(rs.getInt("id_materiau"), resteFab);
                stock.getMateriau().setPrix(rs.getDouble("prix"));
                stock.getMateriau().setNom(rs.getString("nom_materiau"));
                reste.add(stock);
            }
            String exception = "";
            for (StockMateriau stockMateriau : reste) {
                if(stockMateriau.getQuantite()<0){
                    exception += stockMateriau.getMateriau().getNom() + " manque "+ stockMateriau.getMateriau() +"<br>";
                }
            }
            if(exception.equalsIgnoreCase("") == false){
                throw new Exception("Erreur: Fabrication non réalisé <br>" +exception);
            }
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

    private void setMeuble(String idmeuble) {
        setMeuble(new Meuble(idmeuble));
    }

    private void setQuantite(String nb) {
        setQuantite(Integer.parseInt(nb));
    }
}
