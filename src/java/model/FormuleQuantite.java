/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import util.Util;

/**
 *
 * @author HERINIAINA
 */
public class FormuleQuantite {
    private Meuble meuble;
    private Materiau materiau;
    private int quantite;

    public Meuble getMeuble() {
        return meuble;
    }

    public void setMeuble(Meuble meuble) {
        this.meuble = meuble;
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
    
    public void setQuantite(String quantite){
        this.setQuantite(Integer.parseInt(quantite));
    }
    
    public void save(Connection connection) throws Exception{
        boolean newConnection = false;
        PreparedStatement statement = null;
        try {
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Insert into fab_meuble_materiau(id_meuble,id_materiau,quantite) values(?,?,?)");
            statement.setInt(1, this.getMeuble().getId());
            statement.setInt(2, this.getMateriau().getId());
            statement.setDouble(3, this.getQuantite());
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
