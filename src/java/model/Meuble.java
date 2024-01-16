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
 * @author nyanj
 */
public class Meuble {

    private int id;
    private String nom;
    private Style style;
    private Taille taille;
    private Categorie categorie;
    private List<Materiau> liste;
    private List<FormuleQuantite> formules;
    private double prix;

    public Meuble(String idMeuble) {
        setId(Integer.parseInt(idMeuble));
    }
    
    public Meuble(int id){
        setId(id);
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

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public List<Materiau> getListe() {
        return liste;
    }

    public void setListe(List<Materiau> liste) {
        this.liste = liste;
    }
    
    public Taille getTaille() {
        return taille;
    }

    public void setTaille(Taille taille) {
        this.taille = taille;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<FormuleQuantite> getFormules() {
        return formules;
    }

    public void setFormules(List<FormuleQuantite> formules) {
        this.formules = formules;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    public Meuble(){}
    
    public Meuble(String idCategorie, String idTaille, String idStyle){
        Categorie cat = new Categorie(idCategorie);
        Taille taille = new Taille(idTaille);
        Style style = new Style(idStyle);
        setCategorie(cat);
        setTaille(taille);
        setStyle(style);
    }
    
    public static List<Meuble> findAll(Connection c) throws Exception{
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            if(c == null) {
                c = util.Util.pgConnect();
                newConnection = true;
            }
            statement = c.prepareStatement("select * from v_meuble");
            rs = statement.executeQuery();
            List<Meuble> li = new ArrayList<>();
            while(rs.next()) {
                Meuble meuble = new Meuble();
                meuble.setId(rs.getInt("id_meuble"));
                meuble.setStyle(new Style(rs.getInt("id_style")));
                meuble.setNom(rs.getString("nom_taille")+" "+rs.getString("nom_categorie")+" "+rs.getString("nom_style"));
                li.add(meuble);
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
 
    public void save(Connection connection)throws Exception{
        boolean newConnection = false;
        PreparedStatement statement = null;
        try {
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Insert into meuble(id_taille,id_categorie,id_style) values(?,?,?)");
            statement.setInt(1, this.getTaille().getId());
            statement.setInt(2, this.getCategorie().getId());
            statement.setInt(3, this.getStyle().getId());
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

    public void findById(Connection connection) throws Exception {
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet result = null;
        try{
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Select * from v_meuble where id_meuble = ?");
            statement.setInt(1, this.getId());
            result= statement.executeQuery();
            while(result.next()){
                Categorie categorie = new Categorie(result.getInt("id_categorie"),result.getString("nom_categorie"));
                this.setCategorie(categorie);
                Taille taille = new Taille(result.getInt("id_taille"),result.getString("nom_taille"));
                this.setTaille(taille);
                Style style = new Style(result.getInt("id_Style"),result.getString("nom_Style"));
                this.setStyle(style);
                this.setNom();
            }
        } catch(Exception e){
            e.printStackTrace();
            throw new Exception("Erreur de sélection: ne peut pas trouver le Meuble avec cet id");
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
    
    private void setNom() {
        setNom(this.getTaille().getNom() + " " + this.getCategorie().getNom()+ " " + this.getStyle().getNom());
    }

    public void saveFormule(Connection connection) throws Exception {
        boolean newConnection = false;
        try{
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            for (FormuleQuantite formule : formules) {
                formule.save(connection);
            }
        } finally{
            if(connection != null && newConnection == true){
                connection.close();
            }
        } 
    }
    
    public static List<Meuble> getBetween(Connection c, String max, String min) throws Exception{
        try{
            double maxDouble = Double.parseDouble(max);
            double minDouble = Double.parseDouble(min);
            if(minDouble>=maxDouble){
                throw new Exception("Erreur min et max");
            }
            return findByPrix(c, maxDouble, minDouble);
        } catch(NumberFormatException n){
            throw new Exception("Erreur format de nombre");
        }
    }
    
    public static List<Meuble> findByPrix(Connection c, double max, double min) throws Exception{
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            if(c == null) {
                c = util.Util.pgConnect();
                newConnection = true;
            }
            statement = c.prepareStatement("select * from v_prix_meuble where prix >= ? and prix <= ?");
            statement.setDouble(2, max);
            statement.setDouble(1, min);
            rs = statement.executeQuery();
            List<Meuble> li = new ArrayList<>();
            while(rs.next()) {
                Meuble meuble = new Meuble();
                meuble.setNom(rs.getString("nom_taille")+" "+rs.getString("nom_categorie")+" "+rs.getString("nom_style"));
                meuble.setPrix(rs.getDouble("prix"));
                li.add(meuble);
            }
            return li;
        } catch (Exception e) {
            throw new Exception("Erreur select");
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

    List<FormuleQuantite> getFormules(Connection connection) throws Exception {
        List<FormuleQuantite> liste = new ArrayList<>();
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet result = null;
        try{
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Select * from fab_meuble_materiau where id_meuble =?");
            statement.setInt(1, id);
            result= statement.executeQuery();
            while(result.next()){
                FormuleQuantite model = new FormuleQuantite();
                model.setMeuble(this);
                model.setMateriau(new Materiau(result.getInt("id_materiau")));
                model.setQuantite(result.getInt("quantite"));
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
 
}
