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

/**
 *
 * @author HERINIAINA
 */
public class Taille {

    private int id;
    private String nom;
    private int niveau;

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    
    public void setNiveau(String niveau) {
        setNiveau(Integer.parseInt(niveau));
    }
    private int contrainteNombre;

    public Taille(int id, String nom) {
        setId(id);
        setNom(nom);
    }

    public Taille(){}

    public Taille(String idTaille) {
        this.setId(Integer.parseInt(idTaille));
    }

    public int getContrainteNombre() {
        return contrainteNombre;
    }

    public void setContrainteNombre(int contrainteNombre) {
        this.contrainteNombre = contrainteNombre;
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
            statement = c.prepareStatement("Insert into Taille (nom_taille, niveau) values (?,?)");
            statement.setString(1, this.getNom());
            statement.setInt(1, this.getNiveau());
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
    
    public static List<Taille> findAll(Connection c) throws Exception{
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            if(c == null) {
                c = util.Util.pgConnect();
                newConnection = true;
            }
            statement = c.prepareStatement("select * from Taille");
            rs = statement.executeQuery();
            List<Taille> li = new ArrayList<>();
            while(rs.next()) {
                Taille taille = new Taille();
                taille.setId(rs.getInt("id_taille"));
                taille.setNom(rs.getString("nom_taille"));
                li.add(taille);
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
    
    public static Taille findMin(Connection c) throws Exception {
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            if(c == null) {
                c = util.Util.pgConnect();
                newConnection = true;
            }
            statement = c.prepareStatement("select * from Taille order by niveau asc limit 1");
            rs = statement.executeQuery();
            while(rs.next()) {
                Taille taille = new Taille();
                taille.setId(rs.getInt("id_taille"));
                taille.setNom(rs.getString("nom_taille"));
                return taille;
            }
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
        return null;
    }
}
