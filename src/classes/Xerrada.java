package Classes;

import Llistes.LlistaMembres;

/**
 * @author Marc Badia
 */

public class Xerrada extends Accio {
    
    private Data dataXerrada;
    private int nAssistents;
    private short valoracions;
    private LlistaMembres llistaMembres; 

    
    public Xerrada(String t, String r, Data d, int NumAssistents, short val, String[] nomAssociacions, LlistaMembres llistaMembres) {
        super(t, r, nomAssociacions); 
        this.dataXerrada = d;
        this.nAssistents = NumAssistents;
        this.valoracions = val;
        this.llistaMembres = llistaMembres; 
    } 

    
    public Data getDataXerrada() {
        return dataXerrada;
    }

    public void setDataXerrada(Data dataXerrada) {
        this.dataXerrada = dataXerrada;
    }

    public int getNAssistents() {
        return nAssistents;
    }

    public void setNAssistents(int nAssistents) {
        this.nAssistents = nAssistents;
    }
    
    public int getValoracions() {
        return valoracions;
    }

    public void setValoracions(short valoracions) {
        this.valoracions = valoracions;
    }

    // Métode de copia
    public Xerrada copia() {
    
        return new Xerrada(this.titol, this.responsable, this.dataXerrada, this.nAssistents, this.valoracions, this.nomAssociacions, this.llistaMembres.copia());
    }

    
    public boolean esMembre(Membres membre) {
        boolean esMembre = false;
        for (int i = 0; i < llistaMembres.getNumMembres(); i++) {
            Membres membreActual = llistaMembres.getMembre(i); 
            if (membreActual != null && membreActual.getAliesId().equals(membre.getAliesId())) {
                esMembre = true; 
            }
        }
        return esMembre; 
    }

    // Métode toString 
    public String toString() {
        return "Xerrada [codi=" + codi 
        + ", titol=" + titol 
        + ", responsable=" + responsable
        + ", dataXerrada=" + dataXerrada
        + ", nAssistents=" + nAssistents 
        + ", valoracions=" + valoracions + "]";
    }
}
