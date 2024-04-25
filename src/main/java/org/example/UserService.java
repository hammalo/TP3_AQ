package org.example;
// Classe UserService
public class UserService {
    private final UtilisateurApi utilisateurApi;

    public UserService(UtilisateurApi utilisateurApi) {
        this.utilisateurApi = utilisateurApi;
    }

    public void creerUtilisateur(Utilisateur utilisateur) throws ServiceException {
        utilisateurApi.creerUtilisateur(utilisateur);
        utilisateur.setId(utilisateurApi.getIdUtilisateurCree());
    }
}


