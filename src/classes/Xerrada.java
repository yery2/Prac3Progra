package classes;

/**
 * @author Marc Badia
 */

public class Xerrada extends Accio {
    
    private static short nMembres = 3;
    private Data dataXerrada;
    private int nAssistents;
    private short valoracions;
    Membres[] membres = new Membres[nMembres];

    public Xerrada(String c, String t, String r, int nAssoc, Data d, int NumAssistents, short val) {
        super(c, t, r, nAssoc);
        this.dataXerrada = d;
        nAssistents = NumAssistents;
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
            this.codi, this.titol, this.responsable, this.nAssoc, 
            this.dataXerrada, this.nAssistents, this.valoracions);
        return copiaXerrada;
    }

    public String toString() {
        return "Xerrada [codi=" + codi 
        + ", titol=" + titol + ", responsable=" + responsable
        + ", nAssoc=" + nAssoc + ", dataXerrada=" + dataXerrada
        + ", nAssistents=" + nAssistents 
        + ", valoracions=" + valoracions + "]";
    }
    
}
