package Classes;

import GestioFitxers.LlistaAssociacionsSerial;


/**
 * @author Marc Badia, Pol Caballé
 */

public class Accio {
    
    protected String codi = "";    // S'ha de fer metode que a partir de nom assoc. generi codi
    protected String titol;
    protected String responsable;
    protected LlistaAssociacionsSerial llistaAss = new LlistaAssociacionsSerial();
    protected String[] nomAssociacions;

    public Accio(String t, String r,String[] nomAssociacions) {//String = "1;4;5"
        codi = generarCodi(); 
        titol = t; 
        responsable = r; 
        llistaAss.carregarAssociacionsNom(nomAssociacions);
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

    public String[] getNomAssociacions() {
        return nomAssociacions;
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

    public String toStringCSV() {
        return codi + ";" + titol + ";" + responsable + ";" + String.join(",", nomAssociacions);
    }

    public Accio copia(){
        Accio copiaAccio = new Accio(titol, responsable, this.nomAssociacions);
        return copiaAccio;
    }

}