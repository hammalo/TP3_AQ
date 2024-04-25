
import org.example.Calculatrice;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class TetsCalculatrice {
    @Mock
    private Calculatrice calculatrice;
    @Test
    public void testAdditionner() {
        // Définition du comportement de la méthode "additionner"
        when(calculatrice.additionner(2, 3)).thenReturn(5);
        //TODO : Appel de la méthode à tester
         int res=calculatrice.additionner(2,3);
        //TODO : Vérification du résultat
        assertEquals(res,5);
//TODO : Vérification que la méthode "additionner" a été appelée
// avec les arguments 2 et 3, utiliser la directive « verify »
        verify(calculatrice).additionner(2,3);
//TODO : Vérification qu'aucune autre méthode n'a été appelée sur
//l'objet après l'appel de la méthode "additionner", utiliser la
// méthode « verifyNoMoreInteractions »
        verifyNoMoreInteractions(calculatrice);
// TODO : Vérification de l'état de l'objet après l'appel de la
//méthode "additionner", penser à utiliser la méthode
//« getState() » de la directive « verify » : // exemple :
        //doNothing().when(calculatrice.getState());
        when(calculatrice.getState()).thenReturn(5);
        int state = calculatrice.getState();
        assertEquals(5, state);
        verify(calculatrice).getState();
    }
}
