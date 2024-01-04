package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class Style {

    private int id;
    private String nom;
    private List<Materiau> liste;

    public Style(String idStyle) {
        setId(idStyle);
    }

    public Style(int idStyle){
        setId(id);
    }
    
    public Style() {}

    Style(int id, String nom) {
        setId(id);
        setNom(nom);
    }

    public int getId() {
        return id;
    }

    public void setId(String id) throws NumberFormatException{
        this.id = Integer.parseInt(id);
    }
    
    public void setId(int id){
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Materiau> getListe() {
        return liste;
    }

    public void setListe(List<Materiau> liste) {
        this.liste = liste;
    }
    
    public void save(Connection c) throws Exception {
        boolean newConnection = false;
        PreparedStatement statement = null;
        try {
            if(c == null) {
                c = util.Util.pgConnect();
                newConnection = true;
            }
            statement = c.prepareStatement("Insert into Style(nom) values (?)");
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
    
    public void addMateriau(Connection c) throws Exception {
        boolean newConnection = false;
        PreparedStatement statement = null;
        try {
            if(c == null) {
                c = util.Util.pgConnect();
                newConnection = true;
            }
            for (Materiau materiau : liste) {
                statement = c.prepareStatement("insert into style_materiau (id_style, id_materiau) values (?, ?)");
                statement.setInt(1, this.getId());
                statement.setInt(2, materiau.getId());
                statement.executeUpdate();
            }
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
    
    public List<Materiau> selectMateriau(Connection c) throws Exception {
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            if(c == null) {
                c = util.Util.pgConnect();
                newConnection = true;
            }
            statement = c.prepareStatement("select id_materiau, nom_materiau from v_style_materiau where id_style = ?");
            statement.setInt(1, this.getId());
            rs = statement.executeQuery();
            List<Materiau> li = new ArrayList<>();
            while(rs.next()) {
                Materiau materiau = new Materiau();
                materiau.setId(rs.getInt("id_materiau"));
                materiau.setNom(rs.getString("nom_materiau"));
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

    public void setListe(String[] idMateriau) {
        this.liste = new ArrayList<>();
        for (String string : idMateriau) {
            liste.add(new Materiau(Integer.parseInt(string)));
        }
    }
    
    public static List<Style> findAll(Connection c) throws Exception {
        
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            if(c == null) {
                c = util.Util.pgConnect();
                newConnection = true;
            }
            statement = c.prepareStatement("select * from Style");
            rs = statement.executeQuery();
            List<Style> li = new ArrayList<>();
            while(rs.next()) {
                Style materiau = new Style();
                materiau.setId(rs.getInt("id_style"));
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

    public void findById(Connection connection) throws Exception {
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet result = null;
        try{
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Select * from Style where id_style = ?");
            statement.setInt(1, this.getId());
            result= statement.executeQuery();
            while(result.next()){
                this.setNom(result.getString("nom"));
            }
        } catch(Exception e){
            e.printStackTrace();
            throw new Exception("Erreur de sélection: ne peut pas trouver le style avec cet id");
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
