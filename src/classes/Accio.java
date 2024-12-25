package classes;

/**
 * @author Marc Badia, Pol Caballé
 */

public class Accio {
    
    protected String codi = "";    // S'ha de fer metode que a partir de nom assoc. generi codi
    protected String titol;
    protected String responsable;
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


    public String generarCodi(){
        String digits = ""; 
        for (int i = 0; i < llistaAss.getNomAssociacioPosicio(0).length() && i<3; i++) {
            char c = llistaAss.getNomAssociacioPosicio(0).charAt(i); 
            digits += c; 
        }
        }
        return digits;
    }

}