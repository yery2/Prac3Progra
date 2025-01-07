package Classes;


/**
 * @author Marc Badia
 */

public class Xerrada extends Accio {
    
    private static short nMembres = 3;
    private Data dataXerrada;
    private int nAssistents;
    private short valoracions;
    Membres[] membres = new Membres[nMembres];

    public Xerrada(String t, String r, Data d, int NumAssistents, short val, String[] nomAssociacions) {
        super(t, r, nomAssociacions);
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
            this.titol, this.responsable, 
            this.dataXerrada, this.nAssistents, this.valoracions, this.nomAssociacions);
        return copiaXerrada;
    }

    // Mètode per comprovar si un membre està en aquesta xerrada
    public boolean esMembre(Membres membre) {
        boolean esMembre = false;
        for (int i = 0; i < nMembres; i++) {
            if (membres[i] != null && membres[i].getAliesId().equals(membre.getAliesId())) {
                esMembre = true;
            }
        }
        return esMembre;
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
