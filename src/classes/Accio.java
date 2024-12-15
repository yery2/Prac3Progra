package classes;

/**
 * Author: Marc Badia, Pol Caballé
 */

public class Accio {
    
    protected String codi = "";    // S'ha de fer metode que a partir de nom assoc. generi codi
    protected String titol;
    protected String responsable;
    protected int nAssoc;
    private static int NUM_ACCIONS = 0;
    protected LlistaAssociacions llistaA = new LlistaAssociacions();

    public Accio (String c, String t, String r, int nAssoc){
        
        codi = generarCodi(); 
        titol = t; responsable = r; this.nAssoc = nAssoc;
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

    public int getNAssoc(){
        return nAssoc;
    }

    public int getNumAccions(){
        return NUM_ACCIONS;
    }

    public void incrementarNumAccions(){
        NUM_ACCIONS++;
    }
    public String generarCodi(){
        String digits = ""; 
        for (int i = 0; i < llistaA.getNomAssociacioPosicio(0).length(); i++) {
            char c = llistaA.getNomAssociacioPosicio(0).charAt(i); 
                digits += c; 
                if (digits.length() == 3) {
                    digits += llistaA.getNumAccionsPosicio(0);
                    llistaA.incrementarNombreAccionsPosicio(0);
                }
        }
        return digits;
    }

}