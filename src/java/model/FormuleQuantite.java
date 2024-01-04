/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HERINIAINA
 */
public class FormuleQuantite {
    private Meuble meuble;
    private Materiau materiau;
    private int quantite;

    public Meuble getMeuble() {
        return meuble;
    }

    public void setMeuble(Meuble meuble) {
        this.meuble = meuble;
    }

    public Materiau getMateriau() {
        return materiau;
    }

    public void setMateriau(Materiau materiau) {
        this.materiau = materiau;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
