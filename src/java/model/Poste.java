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
public class Poste {
    private int id;
    private String nom;
    private double tauxHoraire;

    public Poste(String type, String taux) {
        setNom(type);
        setTauxHoraire(taux);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Poste(String poste) {
        setId(poste);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }

    public Poste() {
    }

    public static List<Poste> findAll(Connection connection) throws Exception {
        List<Poste> liste = new ArrayList<>();
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            if (connection == null) {
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Select * from poste");
            result = statement.executeQuery();
            while (result.next()) {
                Poste Poste = new Poste();
                Poste.setId(result.getInt("id_poste"));
                Poste.setNom(result.getString("nom_poste"));
                Poste.setTauxHoraire(result.getDouble("taux_horaire"));
                liste.add(Poste);
            }
            return liste;
        } catch (Exception e) {
            throw new Exception("Erreur de sélection: Ne peut pas avoir tous les éléments de Poste");
        } finally {
            if (result != null) {
                result.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null && newConnection == true) {
                connection.close();
            }
        }
    }

    public void findById(Connection connection) throws Exception {
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            if (connection == null) {
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Select * from poste");
            result = statement.executeQuery();
            while (result.next()) {
                this.setId(result.getInt("id_poste"));
                this.setNom(result.getString("nom_poste"));
                this.setTauxHoraire(result.getDouble("taux_horaire"));
            }
        } catch (Exception e) {
            throw new Exception("Erreur de sélection: Ne peut pas avoir tous les éléments de Poste");
        } finally {
            if (result != null) {
                result.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null && newConnection == true) {
                connection.close();
            }
        }
    }

    public void save(Connection connection) throws Exception {
        boolean newConnection = false;
        PreparedStatement statement = null;
        try {
            if (connection == null) {
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Insert into poste(nom_poste,taux_horaire) values(?,?)");
            statement.setString(1, this.getNom());
            statement.setDouble(2, this.getTauxHoraire());
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null && newConnection == true) {
                connection.close();
            }
        }
    }

    public void update(Connection connection) throws Exception {
boolean newConnection = false;
        PreparedStatement statement = null;
        try {
            if (connection == null) {
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Update poste set nom_poste = ? , taux_horaire = ? where id_poste = ?");
            statement.setString(1, this.getNom());
            statement.setDouble(2, this.getTauxHoraire());
            statement.setDouble(3, this.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null && newConnection == true) {
                connection.close();
            }
        }
    }

    private void setTauxHoraire(String taux) {
        setTauxHoraire(Double.parseDouble(taux));
    }

    private void setId(String poste) {
        setId(Integer.parseInt(poste));
    }

}
