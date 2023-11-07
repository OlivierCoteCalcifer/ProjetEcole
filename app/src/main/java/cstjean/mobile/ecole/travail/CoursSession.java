package cstjean.mobile.ecole.travail;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe d'un cours pour une session.
 */
public class CoursSession implements Comparable<CoursSession> {

    /**
     * String du nom du département.
     */
    private final String departement;
    /**
     *  String pour le numéro du cours.
     */
    private final String numero;
    /**
     * Liste des travaux associés au cours.
     */
    private final List<Travail> travaux = new ArrayList<>();

    private URL url;
    /**
     * Int qui compte le nombre de cours crée.
     */
    private static int compteur;

    /**
     * Constructeur d'un cours.
     *
     * @param departement prend un string avec le nom du département.
     * @param numero prend en string le numéro du cours.
     */
    public CoursSession(String departement, String numero) {
        if (!NumeroCoursUtil.estNumeroCoursValide(numero)) {
            throw new IllegalArgumentException();
        }
        this.departement = departement;
        this.numero = numero;
        compteur++;
    }

    public String getDepartement() {
        return departement;
    }

    public String getNumero() {
        return numero;
    }

    public int getNombreTravaux() {
        return travaux.size();
    }

    /**
     * Méthode qui ajoute un travail à la liste de travaux.
     *
     * @param travail prend en paramètre un travail.
     */
    public void ajouterTravail(Travail travail) {
        travaux.add(travail);
    }

    /**
     * Méthode qui retourne un travail à un index donné.
     *
     * @param index prend un paramètre un int comme indice de recherche.
     * @return retourne le travail à la position de l'indice.
     */
    public Travail getTravail(int index) {
        return travaux.get(index);
    }

    public static int getCompteur() {
        return compteur;
    }

    /**
     * Reset le compteur du nombre de travaux créé.
     */
    public static void resetCompteur() {
        compteur = 0;
    }

    public String getDepartementNumero() {
        return departement + " " + numero;
    }

    public URL getUrl() {
        return url;
    }
    public void setUrl(String url)  throws MalformedURLException {
        this.url = new URL(url);
    }

    @Override
    public int compareTo(CoursSession o) {
        int compareDepartement = getDepartement().compareTo(o.getDepartement());

        if (compareDepartement != 0) {
            return compareDepartement;
        }

        return getNumero().compareTo(o.getNumero());
    }
}
