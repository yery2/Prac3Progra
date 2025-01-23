package GestioFitxers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Classes.Alumnes;
import Classes.Membres;
import Classes.Professors;
import Llistes.LlistaMembres;

public class LlistaMembresText {
    private static final String FITXER_MEMBRES = "membres.csv";

    public void carregarMembres(LlistaMembres membres) {
         BufferedReader br = null;
         try {
             br = new BufferedReader(new FileReader(FITXER_MEMBRES));
             String linia;
             while ((linia = br.readLine()) != null) {
                 String[] camps = linia.split(";");
                 if (camps.length == 4) {
                     String departament = camps[2];
                     if (departament.equals("DEIM") || departament.equals("DEEEA")) { // Si el tercer campo es un departament, es un Professor
                         Professors professor = new Professors(camps[0], camps[1], departament, Integer.parseInt(camps[3]));
                             membres.afegirMembre(professor);
                     } else { // Si no, es un Alumne
                         Alumnes alumne = new Alumnes(camps[0], camps[1], camps[2], Integer.parseInt(camps[3]));
                             membres.afegirMembre(alumne);

                     }
                 }
             }
         } catch (IOException e) {
             System.out.println("Hi ha hagut un error en la lectura del fitxer");
         } finally {
             try {
                 if (br != null) {
                     br.close();
                 }
             } catch (IOException e) {
                 System.out.println("Error al tancar el fitxer");
             }
         }
     }
 
     public void guardarMembres(LlistaMembres membres) throws IOException {
         BufferedWriter bw = null;
         try{
             bw = new BufferedWriter(new FileWriter(FITXER_MEMBRES));
             for (int i = 0; i < membres.getNumMembres(); i++) {
                 Membres membre = ;
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
