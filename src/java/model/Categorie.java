/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nyanj
 */
public class Categorie {

    private int id;
    private String nom;
    private int contraiteHeure;

    public Categorie(int id, String nom) {
        setId(id);
        setNom(nom);
    }
    
    public Categorie(){
    }

    public Categorie(String idCategorie) {
        this.setId(Integer.parseInt(idCategorie));
    }

    public int getContraiteHeure() {
        return contraiteHeure;
    }

    public void setContraiteHeure(int contraiteHeure) {
        this.contraiteHeure = contraiteHeure;
    }

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
            statement = c.prepareStatement("Insert into Categorie (nom) values (?)");
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
    
    public static List<Categorie> findAll(Connection c) throws Exception{
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            if(c == null) {
                c = util.Util.pgConnect();
                newConnection = true;
            }
            statement = c.prepareStatement("select * from Categorie order by niveau");
            rs = statement.executeQuery();
            List<Categorie> li = new ArrayList<>();
            while(rs.next()) {
                Categorie categorie = new Categorie();
                categorie.setId(rs.getInt("id_categorie"));
                categorie.setNom(rs.getString("nom"));
                li.add(categorie);
            }
            return li;
        } catch (SQLException e) {
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

    public void setId(String categorie) {
        setId(Integer.parseInt(categorie));
    }

    public void setContraiteHeure(String heure) {
        setContraiteHeure(Integer.parseInt(heure));
    }

    public void saveContrainte(Connection c) throws Exception{
        boolean newConnection = false;
        PreparedStatement statement = null;
        try {
            if(c == null) {
                c = util.Util.pgConnect();
                newConnection = true;
            }
            statement = c.prepareStatement("Insert into contrainte_categorie (id_categorie, heure) values (?, ?)");
            statement.setInt(1, this.getId());
            statement.setInt(2, this.getContraiteHeure());
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
    
}
