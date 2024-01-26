/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import util.Util;

/**
 *
 * @author HERINIAINA
 */
public class Vente {

    private int id;
    private Client client;
    private Date date;
    private Meuble meuble;
    private int nombre;
    private static int femme =0;
    private static int homme =0;
    
    
    public static int getFemme() {
        return femme;
    }

    public static void setFemme(int femme) {
        Vente.femme = femme;
    }

    public static int getHomme() {
        return homme;
    }

    // setters & getters
    public static void setHomme(int homme) {
        Vente.homme = homme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setClient(String client) throws Exception {
        this.client = new Client(client);
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Meuble getMeuble() {
        return meuble;
    }

    public void setMeuble(Meuble meuble) {
        this.meuble = meuble;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) throws Exception {
        if(nombre<0){
            throw new Exception("Nombre négatif");
        }
        this.nombre = nombre;
    }
    public void setNombre(String nombre) throws Exception {
        setNombre(Integer.parseInt(nombre));
    }
    
    // constructeur
    public Vente(){}
    
    public Vente(String id) throws Exception{
        try{
            this.setId(Integer.parseInt(id));}
        catch(NumberFormatException e){
            throw new Exception("Erreur parsing: id pas sous le format nombre");
        }
        this.findById(null);
    }

    // dao
    public void findById(Connection connection) throws Exception {
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet result = null;
        try{
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Select * from [Vente] where id = ?");
            statement.setInt(1, this.getId());
            result= statement.executeQuery();
            while(result.next()){
                this.client.setId(result.getInt("id_client"));
                this.client.findById(connection);
                Date d = result.getDate("date");
                this.setDate(d);
                this.meuble.setId(result.getInt("id_meuble"));
                this.meuble.findById(connection);
                this.setNombre(result.getInt("nombre"));
            }
        } catch(Exception e){
            e.printStackTrace();
            throw new Exception("Erreur de sélection: ne peut pas trouver le [Vente] avec cet id");
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

    public List<Vente> findAll(Connection connection) throws Exception{
        List<Vente> liste = new ArrayList<>();
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet result = null;
        try{
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Select * from Vente");
            result= statement.executeQuery();
            while(result.next()){
                Vente vente = new Vente();
                vente.setId(result.getInt("id"));
                vente.client.setId(result.getInt("id_client"));
                vente.client.findById(connection);
                Date d = result.getDate("date");
                vente.setDate(d);
                vente.meuble.setId(result.getInt("id_meuble"));
                vente.meuble.findById(connection);
                vente.setNombre(result.getInt("nombre"));
                liste.add(vente);
            }
            return liste;
        } catch(Exception e){
            throw new Exception("Erreur de sélection: Ne peut pas avoir tous les éléments de [Vente]");
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
    
    public void save(Connection connection)throws Exception{
        boolean newConnection = false;
        PreparedStatement statement = null;
        try {
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Insert into Vente(id_client,date,id_meuble,nombre) values(?,?,?,?)");
            statement.setInt(1, this.client.getId());
            statement.setDate(2, this.getDate());
            statement.setInt(3, this.meuble.getId());
            statement.setInt(4, this.getNombre());
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
    
    public void update(Connection connection)throws Exception{
        boolean newConnection = false;
        PreparedStatement statement = null;
        try {
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Update [Vente] set id_client = ? , date = ?, id_meuble = ?, nombre = ? where id = ?");
            statement.setInt(1, this.client.getId());
            statement.setDate(2, this.getDate());
            statement.setInt(3, this.meuble.getId());
            statement.setInt(4, this.getNombre());
            statement.setInt(5, this.getId());
            statement.executeUpdate();
        } catch(Exception e){
            throw new Exception();
        } finally{
            if(statement != null){
                statement.close();
            }
            if(connection != null && newConnection == true){
                connection.close();
            }
        }
    }
 
    public Vente getLast(Connection connection)throws Exception{
        Vente vente = new Vente();
        PreparedStatement statement = null;
        ResultSet result = null;
        boolean newConnection = false;
        try{
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Select * from Facture order by id desc limit 1");
            result= statement.executeQuery();
            while(result.next()){
                vente.setId(result.getInt("id"));
                vente.client.setId(result.getInt("id_client"));
                vente.client.findById(connection);
                Date d = result.getDate("date");
                vente.setDate(d);
                vente.meuble.setId(result.getInt("id_meuble"));
                vente.meuble.findById(connection);
                vente.setNombre(result.getInt("nombre"));
            }
        } catch(Exception e){
            throw e;
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
        return vente;
    }
    
    public static void findEtat(Connection connection) throws Exception {
        setFemme(0);
        setHomme(0);
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet result = null;
        try{
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Select * from v_vente_total");
            result= statement.executeQuery();
            while(result.next()){
                if(result.getInt("genre")==1)
                    setFemme(result.getInt("total"));
                if(result.getInt("genre")==0)
                    setHomme(result.getInt("total"));
            }
        } catch(Exception e){
            e.printStackTrace();
            throw new Exception("Erreur de sélection: ne peut pas trouver le [Vente] avec cet id");
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
    
    public static void save(List<Vente> ventes, Connection connection) throws SQLException, Exception {
        boolean newConnection = false;
        PreparedStatement statement = null;
        try {
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            for (Vente vente : ventes) {
                vente.save(connection);
            }
        } catch(Exception e){
            throw e;
        } finally{
            if(connection != null && newConnection == true){
                connection.close();
            }
        }
    }

    public void setDate(String date) {
        setDate(Date.valueOf(date));
    }
    
    public static void findEtat(String meuble, Connection connection) throws Exception {
        boolean newConnection = false;
        setFemme(0);
        setHomme(0);
        PreparedStatement statement = null;
        ResultSet result = null;
        int idMeuble = Integer.parseInt(meuble);
        try{
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Select * from v_vente where id_meuble = ?");
            statement.setInt(1, idMeuble);
            result= statement.executeQuery();
            while(result.next()){
                if(result.getInt("genre")==1)
                    setFemme(result.getInt("total"));
                if(result.getInt("genre")==0)
                    setHomme(result.getInt("total"));
            }
        } catch(Exception e){
            e.printStackTrace();
            throw new Exception("Erreur de sélection: ne peut pas trouver le vente avec cet id");
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
