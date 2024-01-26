/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Util;

/**
 *
 * @author Diamondra
 */
public class Employe {
    private int id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private Date dateEmbauche;
    private String experience;
    private double tauxHoraire;
    private Poste emploi;

    private Employe() {}

    public Poste getPoste() {
        return emploi;
    }

    public void setEmploi(Poste emploi) {
        this.emploi = emploi;
    }

    public Employe(String nom, String prenom) {
        setNom(nom);
        setPrenom(prenom);
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public double getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public void setDateEmbauche(String dateEmbauche) {
        setDateEmbauche(Date.valueOf(dateEmbauche));
    }

    public void setDateNaissance(String dateNaissance) {
        setDateNaissance(Date.valueOf(dateNaissance));
    }

    public void save(Connection connection)throws Exception{
        boolean newConnection = false;
        PreparedStatement statement = null;
        try {
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Insert into employe(nom,prenom,date_naissance,date_embauche,id_poste) values(?,?,?,?,?)");
            statement.setString(1, this.getNom());
            statement.setString(2, this.getPrenom());
            statement.setDate(3, this.getDateNaissance());
            statement.setDate(4, this.getDateEmbauche());
            statement.setInt(5, this.getPoste().getId());
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
    
    public static List<Employe> findAll(Connection connection) throws Exception{
        List<Employe> liste = new ArrayList<>();
        boolean newConnection = false;
        PreparedStatement statement = null;
        ResultSet result = null;
        try{
            if(connection == null){
                connection = Util.pgConnect();
                newConnection = true;
            }
            statement = connection.prepareStatement("Select * from v_profil_employe");
            result= statement.executeQuery();
            while(result.next()){
                Employe employe = new Employe();
                employe.setId(result.getInt("id"));
                employe.setNom(result.getString("nom"));
                employe.setPrenom(result.getString("prenom"));
                employe.setExperience(result.getString("profil"));
                employe.setTauxHoraire(result.getDouble("salaire"));
                liste.add(employe);
            }
            return liste;
        } catch(Exception e){
            throw new Exception("Erreur de sélection: Ne peut pas avoir tous les éléments de Model");
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
