/**
 * @author Núria Yepes
 */

package classes;

import java.io.*;

public class LlistaMembres {
    private int nMembres;
    private Membres[] llistaMembres;
    private static int MAX_MEM = 300;
    private static final String FITXER_MEMBRES = "membres.csv";

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
            try{
                guardarMembres();
            } catch (IOException e){
                System.out.println("Error al afegir el membre. Ho sentim.");
            }
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
                try{
                    guardarMembres();
                } catch (IOException e){
                    System.out.println("Error al eliminar el membre. Ho sentim.");
                }
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
        if (str.isEmpty()) {
            str = "No hi ha cap membre\n";
        }
        return str;
    }

    public void carregarMembres(){
        BufferedReader br = null; 
        try{
            br = new BufferedReader(new FileReader(FITXER_MEMBRES));
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] camps = linia.split(";");
                if (camps.length == 4){
                    String departament = camps[2];
                    if (departament.equals("DEIM") || departament.equals("DEEEA")){ // Si el tercer campo es un departament, es un Professor
                        Professors professor = new Professors(camps[0], camps[1], departament, Integer.parseInt(camps[3]));
                        afegirMembre(professor);
                    } else { // Si no, es un Professor
                        Alumnes alumne = new Alumnes(camps[0], camps[1], camps[2], Integer.parseInt(camps[3]));
                        afegirMembre(alumne);
                    }
                }
            }
        } catch (IOException e){
            System.out.println("Hi ha hagut un error en la lectura del fitxer");
        }
    }

    public void guardarMembres() throws IOException {
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(FITXER_MEMBRES));
            for (int i = 0; i < nMembres; i++) {
                Membres membre = llistaMembres[i];
                if (membre instanceof Alumnes) {
                    Alumnes alumne = (Alumnes) membre;
                    // Formato CSV: aliasId,email,grau,anysUniversitat
                    bw.write(alumne.getAliesId() + ";" + alumne.getEmail() + ";" + alumne.getEnsenyament() + ";" + alumne.getAnys());
                } else if (membre instanceof Professors) {
                    Professors professor = (Professors) membre;
                    // Formato CSV: aliasId,email,departament,numeroDespatx
                    bw.write(professor.getAliesId() + ";" + professor.getEmail() + ";" + professor.getDepartament() + ";" + professor.getDespatx());
                }
                bw.newLine();
            }
        } catch (IOException e){
            System.out.println("Hi ha hagut un error en l'escriptura al fitxer");
        }
     }

}
