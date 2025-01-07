package Classes;

import Llistes.LlistaAssociacions;

/**
 * @author Marc Badia
 */

public class Xerrada extends Accio {
    
    private static short nMembres = 3;
    private Data dataXerrada;
    private int nAssistents;
    private short valoracions;
    Membres[] membres = new Membres[nMembres];
    private int[] posicionsAssociacions;

    public Xerrada(String t, String r, Data d, int NumAssistents, short val, int[] posicionsAssociacions) {
        super(t, r, posicionsAssociacions);
        this.nAssistents = NumAssistents;
        this.valoracions = val;
        this.posicionsAssociacions = posicionsAssociacions;
        valoracions = val;
    }

    public void setNMembres (short n) {
        nMembres = n;
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

    public Xerrada copia(){
        Xerrada copiaXerrada = new Xerrada(
            this.titol, this.responsable, 
            this.dataXerrada, this.nAssistents, this.valoracions, this.posicionsAssociacions);
        return copiaXerrada;
    }

    public String toString() {
        return "Xerrada [codi=" + codi 
        + ", titol=" + titol 
        + ", responsable=" + responsable
        + ", dataXerrada=" + dataXerrada
        + ", nAssistents=" + nAssistents 
        + ", valoracions=" + valoracions + "]";
    }
    
}
