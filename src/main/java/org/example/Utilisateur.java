package org.example;

public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private String email;

    public Utilisateur(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public int getId() {
        return id ;
    }

    public String getNom() {
        return nom;
    }

    public String  getPrenom() {
        return prenom;
    }

    public String  getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }
}
