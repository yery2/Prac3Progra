package classes;

/**
 * @author Marc Badia, Pol Caballé
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

    public LlistaAccions copia(){
        LlistaAccions copiaLlistaAccions = new LlistaAccions();
        return copiaLlistaAccions;
    }

    public String toString() { //cal comprovar que funcioni
        String str = "";
        int i=0;
        for (Accio accio : llistaAccio) {
            str+=("AccioNumero :"+i+++"=\n");
            str+=accio.toString();
        }
        return str;
    }
}

