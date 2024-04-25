package org.example;

public class Jeu {
    private final Banque banque;
    private boolean ouvert;

    public Jeu(Banque labanque) {
        this.banque = labanque;
        this.ouvert = true;
    }

    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException {
        if (!estOuvert()) {
            throw new JeuFermeException("Le jeu est fermé.");
        }

        int mise = joueur.mise();
        try {
            joueur.debiter(mise);
        } catch (DebitImpossibleException e) {
            this.ouvert = false;
            throw new JeuFermeException("Le joueur n'a pas assez d'argent pour miser.");
        }

        int sommeDes = de1.lancer() + de2.lancer();
        if (sommeDes == 7) {
            joueur.crediter(2 * mise);
        }

        if (!banque.est_solvable()) {
            this.ouvert = false;
            throw new JeuFermeException("La banque n'est plus solvable.");
        }
    }

    public void fermer() {
        this.ouvert = false;
    }

    public boolean estOuvert() {
        return ouvert;
    }
}
