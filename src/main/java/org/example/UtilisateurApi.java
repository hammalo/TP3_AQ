package org.example;

public interface UtilisateurApi {
    void creerUtilisateur(Utilisateur utilisateur) throws ServiceException;

    void validerUtilisateur(Utilisateur utilisateur);
    Object creerUtilisateurAvecRetour(Utilisateur utilisateur);
    int getIdUtilisateurCree();
}
