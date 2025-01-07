package PartGrafica;
import java.awt.event.*;
import javax.swing.*;
import ListaClases.*;

public class AccioBoto2 implements ActionListener {
    private LlistaActivitats llistaTallers;
    private LlistaActivitats llistaVisites;
	private LlistaActivitats llistaXerrades;
    private Finestra2 finestra;

	public AccioBoto2(Finestra2 finestra, LlistaActivitats tallers, LlistaActivitats xerrades, LlistaActivitats visites) {
        llistaTallers = tallers;
        llistaVisites = visites;
        llistaXerrades = xerrades;
        this.finestra = finestra;
	}
    public void actionPerformed(ActionEvent e){
        JButton boton = (JButton) e.getSource(); 
        String textBoto = boton.getText(); 
        if(textBoto.equalsIgnoreCase("Tallers")){
            // Enviem el text al TextArea
            
            finestra.afegirTextArea(llistaTallers.toString());
        }
        else if(textBoto.equalsIgnoreCase("Xerrades")){
            finestra.afegirTextArea(llistaXerrades.toString());
        }
        else if(textBoto.equalsIgnoreCase("Visites")){
            finestra.afegirTextArea(llistaVisites.toString());
        }
           
    }

}
