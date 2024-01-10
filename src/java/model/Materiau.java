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
    private double prix;

    public Materiau(int parseInt) {
        setId(parseInt);
    }

    public Materiau() {}

    public Materiau(String idMateriau) {
        setId(Integer.parseInt(idMateriau));
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) throws Exception {
        if(prix<0)
            throw new Exception("Erreur: prix négatif");
        this.prix = prix;
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
    
    public List<FormuleQuantite> findMeuble(Connection c) throws Exception {
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            if(c == null) {
                c = util.Util.pgConnect();
                newConnection = true;
            }
            statement = c.prepareStatement("select * from v_fab_meuble_materiau where id_materiau = ?");
            statement.setInt(1, this.getId());
            rs = statement.executeQuery();
            List<FormuleQuantite> li = new ArrayList<>();
            while(rs.next()) {
                FormuleQuantite formuleQuantite = new FormuleQuantite();
                Meuble meuble = new Meuble(rs.getInt("id_meuble"));
                meuble.setNom(rs.getString("nom_taille")+" "+ rs.getString("nom_categorie")+" "+ rs.getString("nom_style"));
                formuleQuantite.setMeuble(meuble);
                formuleQuantite.setMateriau(this);
                formuleQuantite.setQuantite(rs.getInt("quantite"));
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
    
    public void updatePrix(Connection c) throws Exception{
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            if(c == null) {
                c = util.Util.pgConnect();
                newConnection = true;
            }
            String sql = "UPDATE materiau set prix = ? where id_materiau = ?";
            statement = c.prepareStatement(sql);
            statement.setDouble(1, this.getPrix());
            statement.setInt(2, this.getId());
            statement.executeUpdate();
        } catch(Exception e){
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

    public void setPrix(String prix) throws Exception{
        try{
            double prixDouble = Double.parseDouble(prix);
            setPrix(prixDouble);
        }catch(NumberFormatException e){
            throw new Exception("Erreur: Valeur de prix");
        }
    }

}
