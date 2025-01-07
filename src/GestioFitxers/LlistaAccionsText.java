package GestioFitxers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import Llistes.LlistaAccions;
import Classes.*;

/**
 * @author Yeray Zarza
 */

public class LlistaAccionsText {
    private static final String FILE_PATH = "accions.csv";

    public void carregarAccions(LlistaAccions accions) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ";");
    
                String titol = st.nextToken();
                String responsable = st.nextToken();
                String[] dateParts = st.nextToken().split("-");
                int[] data = new int[3];
                for (int i = 0; i < dateParts.length; i++) {
                data[i] = Integer.parseInt(dateParts[i]);
                }
                String[] nomAssociacions = st.nextToken().split(",");
                int cost = Integer.parseInt(st.nextToken());
                short valoracions = Short.parseShort(st.nextToken());
                int vegades = Integer.parseInt(st.nextToken());
                boolean valida = Boolean.parseBoolean(st.nextToken());
                boolean esXerrada = Boolean.parseBoolean(st.nextToken());
                
                Accio ac;
                if (esXerrada) {
                    Data dataXerrada = new Data();
                    dataXerrada.setData(data[2], data[1], data[0]);
                    ac = new Xerrada(titol, responsable, dataXerrada, (short) vegades, valoracions,nomAssociacions);
                } else {
                    Data dataDisseny = new Data();
                    dataDisseny.setData(data[2], data[1], data[0]);
                    ac = new Demostracio(titol, responsable, dataDisseny, valida, (short) vegades, cost, nomAssociacions);
                }

                accions.afegirAccio(ac);
            }
        } catch (IOException e) {
            System.out.println("No es pot carregar el fitxer: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el format de dades numèriques: " + e.getMessage());
        }
    }

    public void guardarAccions(LlistaAccions llista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            
            for (int i = 0; i < llista.getNumAccions(); i++) { 
                if (llista != null) {
                    
                    bw.write(llista.toStringCSV() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("No es pot guardar el fitxer: " + e.getMessage());
        }
    }

    public Associacio getAssocPosicio(int pos) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            int currentIndex = 0; 
            while ((line = br.readLine()) != null) {
                if (currentIndex == pos) { 
                    String[] data = line.split(";");
    
                    
                    if (data.length < 9) {
                        System.out.println("Format incorrecte a la línia: " + line);
                        return null;
                    }
    
                    String[] membres = data[2].split(",");
                    String[] titulacions = data[3].split(",");
                    return new Associacio(
                            data[0],  // ID
                            data[1],  // Nom
                            membres,  // Membres
                            titulacions,  // Titulacions
                            data[4],  // Algún campo adicional
                            data[5],  // Algún campo adicional
                            data[6],  // Algún campo adicional
                            Integer.parseInt(data[7]), // Algún campo numérico
                            Integer.parseInt(data[8])  // Algún campo numérico
                    );
                }
                currentIndex++; // Incrementar el índice actual
            }
        } catch (IOException e) {
            System.out.println("No es pot carregar el fitxer: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el format numèric: " + e.getMessage());
        }
        return null; // Retornar null si no se encuentra la posición
    }
    


}
