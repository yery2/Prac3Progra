/**
 * @author Núria Yepes
 */

package classes;

public class LlistaMembres {
    private int nMembres;
    private Membres[] llistaMembres;
    private static int MAX_MEM = 300;

    public LlistaMembres(){
        llistaMembres = new Membres[MAX_MEM];
        nMembres = 0;
    }

    public int getNumMembres(){
        return nMembres;
    }

    public LlistaMembres copia(){
        LlistaMembres copiaLlistaMembres = new LlistaMembres();
        copiaLlistaMembres.nMembres = this.nMembres;
        for(int i=0; i<this.nMembres; i++){
            copiaLlistaMembres.llistaMembres[i]=this.llistaMembres[i];
        }
        return copiaLlistaMembres;
    }

    public void afegirMembre(Membres membre){
        if (nMembres < MAX_MEM) {
            llistaMembres[nMembres] = membre;
            nMembres++;
            System.out.println("S'ha afegit correctament el membre: " + membre.getAliesId());
            System.out.println("Nombre de membres actuals: " + nMembres);
        } else {
            System.out.println("\nNo es poden afegir mes membres. S'ha superat la capacitat.");
        }
    }

    public void eliminarMembre(String aliesId) {
        for(int i=0; i<nMembres; i++){
            if(llistaMembres[i].getAliesId().equalsIgnoreCase(aliesId)){
                llistaMembres[i] = llistaMembres[nMembres-1];
                llistaMembres[nMembres-1] = null;
                nMembres--;
                System.out.println("S'ha eliminat correctament el membre: " +aliesId);
                return;
            }
        }
        System.out.println("No s'ha trobat el membre: " +aliesId);
    }

    public String toString(){
        String str = "";
        int i=0;
        for(Membres membre : llistaMembres){
            if (membre!=null) {
                str += "MembreNumero: " + i++ +"=\n";
                str += membre.toString() + "\n";
            }
        }
        } else {
            str = "No hi ha cap membre\n";
        }
        return str;
    }
}
