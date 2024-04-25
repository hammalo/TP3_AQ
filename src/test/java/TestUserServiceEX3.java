import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.example.*;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class TestUserServiceEX3 {




        @Mock
        private UtilisateurApi utilisateurApiMock;

        @Captor
        private ArgumentCaptor<Utilisateur> utilisateurArgumentCaptor;

        @Test(expected = ServiceException.class)
        public void testCreerUtilisateur_EchecCreation() throws ServiceException {
            // Scénario 1: Lever une exception lors de la création de l'utilisateur
            Utilisateur utilisateur = new Utilisateur("louai", "Hamma", "louaihamma@email.com");
            doThrow(new ServiceException("la creation de l'utilisateur est impossible"))
                    .when(utilisateurApiMock)
                    .creerUtilisateur(utilisateur);
            UserService userService = new UserService(utilisateurApiMock);
            userService.creerUtilisateur(utilisateur);
        }

        @Test
        public void testCreerUtilisateur_ErreurValidation() throws ServiceException {
            // Scénario 2: Erreur de validation
            Utilisateur utilisateur = new Utilisateur("louai", "Hamma", "louaihamma@email.com");
            doThrow(new ServiceException("Echec de la création de l'utilisateur")).when(utilisateurApiMock).creerUtilisateur(utilisateur);
            UserService userService = new UserService(utilisateurApiMock);
            userService.creerUtilisateur(utilisateur);
            verify(utilisateurApiMock, times(1)).creerUtilisateur(utilisateur);
            verify(utilisateurApiMock, never()).validerUtilisateur(utilisateur); // Vérifie qu'il n'y a pas de validation
        }

        @Test
        public void testCreerUtilisateur_AvecID() throws ServiceException {
            // Scénario 3: L'API renvoie un ID unique
            Utilisateur utilisateur = new Utilisateur("louai", "Hamma", "louaihamma@email.com");
            int idUtilisateur = 512;
            when(utilisateurApiMock.creerUtilisateurAvecRetour(utilisateur)).thenReturn(true);
            when(utilisateurApiMock.getIdUtilisateurCree()).thenReturn(idUtilisateur);
            UserService userService = new UserService(utilisateurApiMock);
            userService.creerUtilisateur(utilisateur);
            verify(utilisateurApiMock, times(1)).creerUtilisateur(utilisateur);
            verify(utilisateurApiMock, times(1)).getIdUtilisateurCree();
            assertEquals(idUtilisateur, utilisateur.getId()); // Vérifie que l'ID utilisateur est défini correctement
        }

        @Test
        public void testCreerUtilisateur_ArgumentsCaptures() throws ServiceException {
            // Scénario 4: Utilisation d'arguments capturés pour vérifier les arguments exacts
            Utilisateur utilisateur = new Utilisateur("louai", "Hamma", "louaihamma@email.com");
            when(utilisateurApiMock.creerUtilisateurAvecRetour(any(Utilisateur.class))).thenReturn(true);
            UserService userService = new UserService(utilisateurApiMock);
            userService.creerUtilisateur(utilisateur);
            verify(utilisateurApiMock, times(1)).creerUtilisateur(utilisateurArgumentCaptor.capture());
            Utilisateur utilisateurCapture = utilisateurArgumentCaptor.getValue();
            assertEquals(utilisateur.getNom(), utilisateurCapture.getNom()); // Vérifie le nom capturé
            assertEquals(utilisateur.getPrenom(), utilisateurCapture.getPrenom()); // Vérifie le prénom capturé
            assertEquals(utilisateur.getEmail(), utilisateurCapture.getEmail()); // Vérifie l'email capturé
        }


}
