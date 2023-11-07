package cstjean.mobile.ecole.travail;

public class NumeroCoursUtil {
    public static Boolean estNumeroCoursValide(String numeroCours) {

        String regex = "^\\d[0-9A-Z]\\d$";

        return numeroCours.matches(regex);
    }
}
