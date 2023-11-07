package cstjean.mobile.ecole.travail.rapport;

import cstjean.mobile.ecole.travail.CoursSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe pour le rapport des cours.
 */
public class RapportCours extends Rapport {
    /**
     * Liste qui prend tous les cours sessions.
     */
    private final List<CoursSession> listeCoursSession = new ArrayList<>();

    /**
     * Méthode qui ajoute des cours sessions au rapport.
     *
     * @param coursSession prend en paramètre un cours session.
     */
    void ajouter(CoursSession coursSession) {
        this.listeCoursSession.add(coursSession);
    }

    /**
     * String qui créer le rapport.
     *
     * @return retourne le rapport sous la forme d'un string.
     */
    String getRapportCours() {
        StringBuilder builder = new StringBuilder();

        Collections.sort(listeCoursSession);

        for (CoursSession cours : listeCoursSession) {
            builder.append(cours.getDepartement())
                    .append(" ")
                    .append(cours.getNumero())
                    .append(SAUT_LIGNE);
        }
        return builder.toString();
    }
}
