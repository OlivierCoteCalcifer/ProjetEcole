package cstjean.mobile.ecole.travail.rapport;

import static org.junit.Assert.assertEquals;

import cstjean.mobile.ecole.travail.CoursSession;

import org.junit.Test;

/**
 * Classe qui teste les rapports de cours.
 */
public class TestRapportCours {
    /**
     * Teste les rapports des cours.
     */
    @Test
    public void testRapport() {
        RapportCours rapport = new RapportCours();
        rapport.ajouter(new CoursSession("FRANCAIS", "101"));
        rapport.ajouter(new CoursSession("MATHS", "301"));
        rapport.ajouter(new CoursSession("PHILO", "301"));
        rapport.ajouter(new CoursSession("MATHS", "201"));
        rapport.ajouter(new CoursSession("PHILO", "201"));

        assertEquals("FRANCAIS 101" + RapportCours.SAUT_LIGNE +
                        "MATHS 201" + RapportCours.SAUT_LIGNE +
                        "MATHS 301" + RapportCours.SAUT_LIGNE +
                        "PHILO 201" + RapportCours.SAUT_LIGNE +
                        "PHILO 301" + RapportCours.SAUT_LIGNE, rapport.getRapportCours());
    }
}
