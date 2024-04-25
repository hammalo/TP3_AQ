
import org.example.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;public class TestJeu {

    @Test(expected = JeuFermeException.class)
    public void testJoueurInsolvable() throws JeuFermeException, DebitImpossibleException {
        // Préparation du test
        Joueur joueur = Mockito.mock(Joueur.class);
        Banque banque = Mockito.mock(Banque.class);
        De de1 = Mockito.mock(De.class);
        De de2 = Mockito.mock(De.class);

        // Configuration du joueur insolvable
        Mockito.when(joueur.mise()).thenReturn(10); // Mise du joueur
        Mockito.doThrow(new DebitImpossibleException("Le joueur est insolvable")).when(joueur).debiter(Mockito.anyInt());

        // Exécution du jeu
        Jeu jeu = new Jeu(banque);
        jeu.jouer(joueur, de1, de2);
    }
}
