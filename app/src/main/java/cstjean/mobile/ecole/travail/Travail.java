package cstjean.mobile.ecole.travail;

import java.util.Calendar;

/**
 * Classe pour un travail.
 */
public class Travail {
    /**
     * String qui est le nom du travail.
     */
    private final String nom;
    /**
     * Calendar qui est la date de remise du travail.
     */
    private final Calendar dateRemise;

    /**
     * Constructeur d'un travail.
     *
     * @param nom prend en paramètre un string pour le nom du travail.
     * @param dateRemise prend en paramètre un calendar pour la date de remise.
     */
    public Travail(String nom, Calendar dateRemise) {
        this.nom = nom;
        this.dateRemise = dateRemise;
    }

    public String getNom() {
        return nom;
    }

    public Calendar getDateRemise() {
        return dateRemise;
    }
}
