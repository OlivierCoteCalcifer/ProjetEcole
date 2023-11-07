package cstjean.mobile.ecole.travail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe qui test les cours par session.
 */
public class TestCoursSession {
    /**
     * Créer une instance de cours sessions.
     */
    private CoursSession coursSession;

    /**
     * Méthode qui créer les setup de test.
     */
    @Before
    public void setUp() {
        coursSession = new CoursSession("Philo", "101");
    }

    /**
     * Test la création de cours par sessions.
     */
    @Test
    public void testCreer() {
        assertEquals("Philo", coursSession.getDepartement());
        assertEquals("101", coursSession.getNumero());
        assertEquals(0, coursSession.getNombreTravaux());
        assertEquals("Philo 101", coursSession.getDepartementNumero());
    }

    /**
     * Test l'Ajout d'un travail à la liste.
     */
    @Test
    public void testAjoutTravail() {
        Calendar dateRemise = new GregorianCalendar(2023, Calendar.SEPTEMBER, 15);
        Travail travail1 = new Travail("TP1", dateRemise);
        coursSession.ajouterTravail(travail1);
        assertEquals(1, coursSession.getNombreTravaux());
        assertEquals(travail1, coursSession.getTravail(0));

        Travail travail2 = new Travail("TP2", dateRemise);
        coursSession.ajouterTravail(travail2);
        assertEquals(2, coursSession.getNombreTravaux());
        assertEquals(travail1, coursSession.getTravail(0));
        assertEquals(travail2, coursSession.getTravail(1));
    }

    /**
     * Méthode qui test le compteur.
     */
    @Test
    public void testCompteur() {
        CoursSession.resetCompteur();
        assertEquals(0, CoursSession.getCompteur());

        new CoursSession("Philo", "101");
        assertEquals(1, CoursSession.getCompteur());

        new CoursSession("Philo", "101");
        assertEquals(2, CoursSession.getCompteur());

        new CoursSession("Philo", "101");
        assertEquals(3, CoursSession.getCompteur());

        CoursSession.resetCompteur();
        assertEquals(0, CoursSession.getCompteur());
    }

    /**
     * Méthode qui test le compare qui trie les cours.
     */
    @Test
    public void testCompare() {
        assertEquals(0, coursSession.compareTo(new CoursSession("Philo", "101")));
        assertTrue(coursSession.compareTo(new CoursSession("Philo", "201")) < 0);
        assertTrue(coursSession.compareTo(new CoursSession("Maths", "101")) > 0);
    }

    @Test
    public void testURL() throws MalformedURLException {
        final String url = "https://www.cstjean.qc.ca/philo101";
        coursSession.setUrl(url);
        assertEquals(url, coursSession.getUrl().toString());
    }

    @Test
    public void testUrlInvalidejUnit3() {
        final String url = "://www.cstjean.qc.ca/philo101";

        try {
            coursSession.setUrl(url);
            fail("Devrait avoir une exception");
        } catch (MalformedURLException e) {
            // Succès!
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNumeroCoursInvalide() throws IllegalArgumentException {
        new CoursSession("Philo", "AAA");
    }

    @Test(expected = MalformedURLException.class)
    public void testUrlInvalidejUnit4() throws MalformedURLException {
        final String url = "://www.cstjean.qc.ca/philo101";
        coursSession.setUrl(url);
    }

}
