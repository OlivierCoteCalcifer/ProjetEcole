package cstjean.mobile.ecole.travail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import cstjean.mobile.ecole.travail.SingletonEcole;

public class TestSingletonEcole {

    private SingletonEcole singleton;

    public void setUp() {
        singleton = SingletonEcole.getInstance();
        singleton.reset();
    }
    @Test
    public void testInstance() {
        SingletonEcole singleton2 = SingletonEcole.getInstance();
        assertSame(singleton, singleton2);
    }

    @Test
    public void testAjoutCours() {
        CoursSession cours1 = new CoursSession("Philo", "101");
        singleton.ajouterCoursSession(cours1);
        assertEquals(1, singleton.getNbCoursSession());
        assertEquals(cours1, singleton.getCoursSession(0));

        CoursSession cours2 = new CoursSession("Philo", "201");
        singleton.ajouterCoursSession(cours2);
        assertEquals(2, singleton.getNbCoursSession());
        assertEquals(cours1, singleton.getCoursSession(0));
        assertEquals(cours2, singleton.getCoursSession(1));

        //assertEquals();
    }
}
