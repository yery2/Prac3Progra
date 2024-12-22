package classes;

/**
 * @author Marc Badia, Pol Caballé
 */

public class LlistaAssociacions {
    
    private int nElem;
    private Associacio[] llista;
    private static final int CAPACITAT_INICIAL = 100; // Capacitat inicial de la llista

    public LlistaAssociacions() {
        llista = new Associacio[CAPACITAT_INICIAL];
        nElem = 0;
    }

    public void afegirAssoc(Associacio a) {
        if (nElem < llista.length) {
            llista[nElem] = a.copia();
            nElem++;
        }
    }

    public void eliminarAssoc(String nomAssoc) {
        for(int i=0; i<nElem; i++){
            if(llista[i].getNomAssociacio().equalsIgnoreCase(nomAssoc)){
                llista[i] = llista[nElem-1];
                llista[i-1] = null;
                nElem--;
            }
        }
    }

    public LlistaAssociacions copiaLlistAssociacio(){

        LlistaAssociacions copia = new LlistaAssociacions();
        for (int i = 0; i < nElem; i++){
            copia.afegirAssoc(llista[i].copia());
        }
        return copia;
    }
    
    public String getNomAssociacioPosicio(int n){
        return llista[n].getNomAssociacio();
    }

    public int getNumAccionsPosicio(int n){
        return llista[n].getNombreAccions();
    }

    public void incrementarNombreAccionsPosicio(int n){
        llista[n].incrementarNombreAccions();
    }

}


