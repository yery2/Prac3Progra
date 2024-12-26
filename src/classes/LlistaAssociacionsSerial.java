package classes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marc Badia, Pol Caballé
 */

public class LlistaAssociacionsSerial {
    
    private static final String FILE_PATH = "associacions.csv";
    private int nElem;
    private Associacio[] llista;
    private static final int CAPACITAT_INICIAL = 100; // Capacitat inicial de la llista

    public LlistaAssociacionsSerial() {
        llista = new Associacio[CAPACITAT_INICIAL];
        nElem = 0;
    }

    public void afegirAssoc(Associacio a) {
        if (nElem < llista.length) {
            llista[nElem] = a.copia();
            nElem++;
            System.out.println("Associació afegida: " + a.getNomAssociacio());
            System.out.println("Nombre d'elements actual: " + nElem);
        } else {
            System.out.println("No es pot afegir més associacions, capacitat màxima.");
        }
    }

    public void eliminarAssoc(String nomAssoc) {
        for(int i=0; i<nElem; i++){
            if(llista[i].getNomAssociacio().equalsIgnoreCase(nomAssoc)){
                llista[i] = llista[nElem-1];
                llista[i-1] = null;
                nElem--;
            }
        }
    }

    public LlistaAssociacions copiaLlistAssociacio(){

        LlistaAssociacions copia = new LlistaAssociacions();
        for (int i = 0; i < nElem; i++){
            copia.afegirAssoc(llista[i].copia());
        }
        return copia;
    }
    
    public String getNomAssociacioPosicio(int n) {
        if (n >= 0 && n < nElem && llista[n] != null) {
            return llista[n].getNomAssociacio();
        } else {
            String str="Err:\n";
            if(n<0) str+= "getNomAssociacioPosicio: Assoc no existent: n<0  \n";
            if(n>=nElem) str+= "getNomAssociacioPosicio: Assoc no existent: n>=nElem  \n";
            if(llista[n]==null) str+= "getNomAssociacioPosicio: Assoc no existent:  llista[n] == null  \n";
            return str;
        }
    }

    public int getNumAccionsPosicio(int n) {
        if (n >= 0 && n < nElem && llista[n] != null) {
            return llista[n].getNombreAccions();
        } else {
            return 0;
        }
    }

    public void incrementarNombreAccionsPosicio(int n){
        if (n >= 0 && n < nElem && llista[n] != null) {
            llista[n].incrementarNombreAccions();
        } else {
            if(n<0) System.out.println("incrementarNombreAccionsPosicio: No es compleix que n>=0 || n: " + n);
            if(n>=nElem) System.out.println("incrementarNombreAccionsPosicio: No es compleix que n<nElem  || n: " + n + " || nElem: " + nElem);
            if(llista[n]==null) System.out.println("incrementarNombreAccionsPosicio: No es compleix que llista[n] != null  ");
        }
    }

    public int getNElem() {
        return nElem;
    }

    private void carregarAssociacions() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                String[] membres = data[2].split(",");
                String[] titulacions = data[3].split(",");
                Associacio a = new Associacio(data[0],data[1],
                            membres,titulacions,data[4],data[5],data[6],
                            Integer.parseInt(data[7]),Integer.parseInt(data[8])); 
                afegirAssoc(a);
            }
        } catch (IOException e) {
            System.out.println("No es pot carregar el fitxer: " + e.getMessage());
        }
    }

    private void guardarAssociacions() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Associacio a : llista) {
                bw.write(a.toStringSerial() + "\n");
            }
        } catch (IOException e) {
            System.out.println("No es pot guardar el fitxer: " + e.getMessage());
        }
    }
}