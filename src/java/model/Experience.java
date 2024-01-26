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
 * @author Diamondra
 */
public class Experience {
    private Poste poste;
    private int id;
    private String profil;
    private int min;
    private int max;
    private int multi;

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMulti() {
        return multi;
    }

    public void setMulti(int multi) {
        this.multi = multi;
    }
    
    public void save(Connection connection)throws Exception{
        boolean newConnection = false;
        PreparedStatement statement = null;
        try {
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Insert into experience (profil,experience) values(?,?,?)");
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

    public void setPoste(String poste) {
        setPoste(new Poste(poste));
    }

    public void setMin(String min) {
        setMin(Integer.parseInt(min));
    }

    public void setMax(String max) {
        setMax(Integer.parseInt(max));
    }

    public void setMulti(String multi) {
        setMulti(Integer.parseInt(multi));
    }
}
