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

/**
 *
 * @author nyanj
 */
public class Materiau {

    private int id;
    private String nom;

    public Materiau(int parseInt) {
        setId(parseInt);
    }

    public Materiau() {}

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
    
    public void save(Connection c) throws Exception {
        boolean newConnection = false;
        PreparedStatement statement = null;
        try {
            if(c == null) {
                c = util.Util.pgConnect();
                newConnection = true;
            }
            statement = c.prepareStatement("Insert into Materiau (nom) values (?)");
            statement.setString(1, this.getNom());
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if(statement != null) {
                statement.close();
            }
            if(c != null && newConnection == true) {
                c.close();
            }
        }
    }
    
    public static List<Materiau> findAll(Connection c) throws Exception {
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            if(c == null) {
                c = util.Util.pgConnect();
                newConnection = true;
            }
            statement = c.prepareStatement("select * from Materiau");
            rs = statement.executeQuery();
            List<Materiau> li = new ArrayList<>();
            while(rs.next()) {
                Materiau materiau = new Materiau();
                materiau.setId(rs.getInt("id_materiau"));
                materiau.setNom(rs.getString("nom"));
                li.add(materiau);
            }
            return li;
        } catch (Exception e) {
            throw e;
        } finally {
            if(statement != null) {
                statement.close();
            }
            if(rs != null) {
                rs.close();
            }
            if(c != null && newConnection == true) {
                c.close();
            }
        }
    }
    
    public static List<FormuleQuantite> findMeuble(Connection c) throws Exception {
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            if(c == null) {
                c = util.Util.pgConnect();
                newConnection = true;
            }
            statement = c.prepareStatement("select * from v_fab_meuble_materiau");
            rs = statement.executeQuery();
            List<FormuleQuantite> li = new ArrayList<>();
            while(rs.next()) {
                FormuleQuantite formuleQuantite = new FormuleQuantite();
                
                li.add(formuleQuantite);
            }
            return li;
        } catch (Exception e) {
            throw e;
        } finally {
            if(statement != null) {
                statement.close();
            }
            if(rs != null) {
                rs.close();
            }
            if(c != null && newConnection == true) {
                c.close();
            }
        }
    }
    
}
