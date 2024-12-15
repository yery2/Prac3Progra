package classes;

/**
 * Author: Marc Badia
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

    public int getNAssistents() {
        return nAssistents;
    }
    
    public int getValoracions() {
        return valoracions;
    }
    
}
