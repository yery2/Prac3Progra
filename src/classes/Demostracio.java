package Classes;

/**
 * @author Pol Caballé
 */

public class Demostracio extends Accio {
    private Data dataDisseny;
    private boolean valida;
    private short nVegades;
    private int cost;

    public Demostracio(String t, String r, Data d, boolean valida, short nVegades, int cost,String[] nomAssociacions) {
        super(t, r,nomAssociacions);
        this.dataDisseny = d; this.valida = valida; this.nVegades = nVegades; this.cost = cost;
    }

    public Data getDataDisseny () {
        return dataDisseny;
    }

    public boolean esValida() {
        return valida;
    }

    public short getNVegades() {
        return nVegades;
    }

    public int getCost() {
        return cost;
    }

    public String[] getNomAssociacions(){
        return nomAssociacions;
    }


}