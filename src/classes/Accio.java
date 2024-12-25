package classes;

/**
 * @author Marc Badia, Pol Caballé
 */

public class Accio {
    
    protected String codi = "";    // S'ha de fer metode que a partir de nom assoc. generi codi
    protected String titol;
    protected String responsable;
    protected LlistaAssociacions llistaAss = new LlistaAssociacions();

    public Accio(String t, String r, LlistaAssociacions llistaAss) {
        this.llistaAss = llistaAss;
        codi = generarCodi(); 
        titol = t; 
        responsable = r; 
    }

    public String getCodi(){
        return codi;
    }

    public String getTitol(){
        return titol;
    }

    public String getResponsable(){
        return responsable;
    }


    public String generarCodi(){
        String digits = ""; 
        for (int i = 0; i < llistaAss.getNomAssociacioPosicio(0).length() && i<3; i++) {
            char c = llistaAss.getNomAssociacioPosicio(0).charAt(i); 
            digits += c; 
        }
        llistaAss.incrementarNombreAccionsPosicio(0);
        int val = 99+llistaAss.getNumAccionsPosicio(0);
        digits += val;
        return digits;
    }

    public String toString() {

        return "Accio{" +
                "codi='" + codi + '\'' +
                ", titol='" + titol + '\'' +
                ", responsable='" + responsable + '\'' +
                ", nAssoc organitzadores=" + llistaAss.getNElem() +
                '}';
    }

}