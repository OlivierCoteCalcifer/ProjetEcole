package cstjean.mobile.ecole.travail.rapport;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.Travail;
import java.text.SimpleDateFormat;

/**
 * Classe pour les rapports de travaux.
 */
public class RapportTravaux extends Rapport {
    /**
     * String pour l'entête du rapport.
     */
    static final String ENTETE_RAPPORT_TRAVAUX = "---------- TRAVAUX ----------" + SAUT_LIGNE + SAUT_LIGNE;
    /**
     * String pour le pied de page.
     */
    static final String PIEDPAGE_RAPPORT_TRAVAUX = SAUT_LIGNE;

    /**
     * Méthode qui construit le rapport.
     *
     * @param coursSession prend en paramètre un cours session.
     * @return retourne la string du rapport.
     */
    public static String getRapportTravaux(CoursSession coursSession) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder builder = new StringBuilder();

        builder.append(ENTETE_RAPPORT_TRAVAUX);

        for (int i = 0; i < coursSession.getNombreTravaux(); i++) {
            Travail travail = coursSession.getTravail(i);

            builder.append(travail.getNom())
                    .append(" - ")
                    .append(formatDate.format(travail.getDateRemise().getTime()))
                    .append(SAUT_LIGNE)
                    .append(SAUT_LIGNE);
        }
        builder.append("Total : ")
                .append(coursSession.getNombreTravaux())
                .append(SAUT_LIGNE);

        return builder.toString();
    }
}
