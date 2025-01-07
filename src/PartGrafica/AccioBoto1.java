package PartGrafica;
import javax.swing.*;
import java.awt.event.*;
import ListaClases.*;

/**
 * Classe AccioBoto1 que implementa l'interfície ActionListener per gestionar
 * les accions associades al botó 1 en la interfície gràfica.
 */
public class AccioBoto1 implements ActionListener {
    // Llista d'activitats
    private LlistaActivitats a;

    /**
     * Constructor de la classe que rep una LlistaActivitats com a paràmetre.
     * @param a LlistaActivitats associada a l'acció del botó.
     */
    public AccioBoto1(LlistaActivitats a) {
        this.a = a;
    }

    /**
     * Mètode actionPerformed que s'executa quan es fa clic al botó.
     * @param evt Event que es genera en fer clic al botó.
     */
    public void actionPerformed(ActionEvent evt) {
        // Obté el botó que ha generat l'event.
        JButton b = (JButton) evt.getSource();
        // Obté el text del botó.
        String s = b.getText();

        // Separem el text per  agafar el dia
        String[] parte = s.split(":");
        String parte1 = parte[0];
        String[] parte2 = parte1.split(" ");
        int dia = Integer.parseInt(parte2[1].trim());

        // Crea una nova finestra amb les activitats del dia corresponent.
        Finestra2 finestra2 = new Finestra2("Activitats del dia " + dia);
        finestra2.iniContingutFinestra2(a, dia);
    }
}
