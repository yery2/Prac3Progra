package Llistes;

import Classes.*;
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

    public Accio getAccio(int i) {
        if (i >= 0 && i < nElem) {
            return llistaAccio[i];
        } else {
            return null; // Retorna null si l'índex no és vàlid
        }
    }

    public LlistaAccions copia(){
        LlistaAccions copiaLlistaAccions = new LlistaAccions();
        return copiaLlistaAccions;
    }

    public void afegirAccio(Accio accio) {
        if (nElem < CAPACITAT_INICIAL) {
            llistaAccio[nElem++] = accio;
        } else {
            System.out.println("No es poden afegir més accions, capacitat maxima");
        }
    }

    public Xerrada xerradaMillorvalorada(){
        Xerrada xerradaMillor = null;
        double mitjanaMillor = -1.0;
        for(int i = 0; i < nElem; i++){
            if (llistaAccio[i] instanceof Xerrada) {
                Xerrada xerradaActual = (Xerrada) llistaAccio[i];
                double mitjanaActual = (double) xerradaActual.getValoracions() / xerradaActual.getNAssistents();
                if (mitjanaActual > mitjanaMillor || (mitjanaActual == mitjanaMillor && xerradaActual.getValoracions() > xerradaMillor.getValoracions())) {
                xerradaMillor = xerradaActual;
                mitjanaMillor = mitjanaActual;
            }   
            } 
        }
        return xerradaMillor;
    }

    public LlistaAccions obtenirXerradesPerMembre(Membres membre) {
        LlistaAccions xerradesMembres = new LlistaAccions();
        for (int i = 0; i < nElem; i++) {
            if (llistaAccio[i] instanceof Xerrada) {
                Xerrada xerrada = (Xerrada) llistaAccio[i];
                if (xerrada.esMembre(membre)) {
                    xerradesMembres.afegirAccio(llistaAccio[i]);
                }
            }
        }
        return xerradesMembres;
    }

    public String toString() { 
        String str = "";
        int i=0;
        if(llistaAccio!=null) {
            for (Accio accio : llistaAccio) {
                if (accio != null) { // Add null check here
                    str += "AccioNumero: " + i++ + "=\n";
                    str += accio.toString() + "\n";
                }
            }
        } else {
            str = "No hi ha cap accio";
        }
        return str;
    }

    public String toStringCSV() { 
        String str = "";
        int i=0;
        if(llistaAccio!=null) {
            for (Accio accio : llistaAccio) {
                if (accio != null) { // Add null check here
                    str += "AccioNumero: " + i++ + "=\n";
                    str += accio.toStringCSV() + "\n";
                }
            }
        } else {
            str = "No hi ha cap accio";
        }
        return str;
    }
}

