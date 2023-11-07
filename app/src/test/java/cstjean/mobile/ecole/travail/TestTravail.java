package cstjean.mobile.ecole.travail;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;
import junit.framework.TestCase;

import org.junit.Test;

/**
 * Classe qui teste les travaux.
 */
public class TestTravail {
    /**
     * Classe qui teste la création de travaux.
     */
    @Test
    public void testCreer() {
        Calendar dateRemise = new GregorianCalendar(2023, Calendar.SEPTEMBER, 15);
        String nomTravail1 = "TP1";
        Travail travail1 = creerTravail(nomTravail1, dateRemise);
        assertEquals(nomTravail1, travail1.getNom());
        assertEquals(dateRemise, travail1.getDateRemise());

        String nomTravail2 = "TP2";
        Travail travail2 = creerTravail(nomTravail2, dateRemise);
        assertEquals(nomTravail2, travail2.getNom());
        assertEquals(dateRemise, travail2.getDateRemise());
    }

    /**
     * Méthode pour créer un travail d'équipe.
     *
     * @param nom prend en paramètre le nom d'un travail.
     * @param dateRemise prend en paramètre une date de remise.
     * @return retourne un nouveau travail.
     */
    protected Travail creerTravail(String nom, Calendar dateRemise) {
        return new Travail(nom, dateRemise);
    }
}
