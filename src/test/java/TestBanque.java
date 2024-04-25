import org.example.Banque;
import org.example.ImpBanque;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class TestBanque {

    @Test
    public void testBanqueSolvable() {
        // Initialisation de la banque avec des fonds suffisants
        Banque banque = new ImpBanque(1000, 500);

        // Vérification que la banque est solvable
        assertTrue(banque.est_solvable());
    }

    @Test
    public void testBanqueNonSolvable() {
        // Initialisation de la banque avec des fonds insuffisants
        Banque banque = new ImpBanque(400, 500);

        // Vérification que la banque n'est pas solvable
        assertFalse(banque.est_solvable());
    }
}
