package cstjean.mobile.ecole.travail;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Classe qui teste un travail d'équipe.
 */
public class TestTravailEquipe extends TestTravail {

    /**
     * Teste l'ajout de coéquipiers.
     */
    @Test
    public void testAjoutCoequipiers() {
        TravailEquipe travail = (TravailEquipe) creerTravail("TP1",
                new GregorianCalendar(2023, Calendar.SEPTEMBER, 20));

        int da1 = 123456;
        String nomCoequipier1 = "Coéquipier 1";
        travail.ajouterCoequipier(da1, nomCoequipier1);
        assertEquals(nomCoequipier1, travail.getCoequipier(da1));

        int da2 = 111222;
        String nomCoequipier2 = "Coéquipier 2";
        travail.ajouterCoequipier(da2, nomCoequipier2);
        assertEquals(nomCoequipier2, travail.getCoequipier(da2));

        assertEquals(nomCoequipier1, travail.getCoequipier(da1));
    }

    @Override
    protected Travail creerTravail(String nom, Calendar dateRemise) {
        return new TravailEquipe(nom, dateRemise);
    }
}
