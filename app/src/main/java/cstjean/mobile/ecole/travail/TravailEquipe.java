package cstjean.mobile.ecole.travail;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Classe pour un travail d'équipe.
 */
public class TravailEquipe extends Travail {
    /**
     * Map qui contient tous les coéquipiers.
     */
    private final Map<Integer, String> coequipiers = new LinkedHashMap<>();

    /**
     * Constructeur pour un travail d'équipe.
     *
     * @param nom prend en paramètre le nom du travail.
     * @param dateRemise prend en paramètre une date de remise.
     */
    public TravailEquipe(String nom, Calendar dateRemise) {
        super(nom, dateRemise);
    }

    /**
     * Fonction qui ajoute un coéquipier au travail.
     *
     * @param da prend en paramètre le da d'un étudiant.
     * @param nomCoequipier prend en paramètre le nom de l'étudiant.
     */
    void ajouterCoequipier(int da, String nomCoequipier) {
        coequipiers.put(da, nomCoequipier);
    }

    /**
     * Fonction qui retourne le nom d'un coéquipier.
     *
     * @param da prend en paramètre le da d'un étudiant.
     * @return retourne le nom d'un étudiant.
     */
    String getCoequipier(int da) {
        return coequipiers.get(da);
    }
}
