package classes;

/**
 * Author: Marc Badia, Pol Caballe
 */

public class LlistaAccions {
    private int nElem;
    private Accio[] llistaAccio;
    private static final int CAPACITAT_INICIAL = 100; // Capacitat inicial de la llista

    public LlistaAccions() {
        llistaAccio = new Accio[CAPACITAT_INICIAL];
        nElem = 0;
    }
    public int getNumAccions(){
        return nElem;
    }
}

