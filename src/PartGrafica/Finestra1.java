package PartGrafica;
import javax.swing.*;
import java.awt.*;
import ListaClases.*;
import java.time.LocalDate;

/**
 * Classe Finestra1 que hereta de JFrame i representa la finestra principal de l'aplicació.
 */
public class Finestra1 extends JFrame {
    
    /**
     * Constructor
     * @param titol Títol de la finestra.
     */
    public Finestra1(String titol) {
        super(titol);
        this.setLocation(100, 200);
        this.setSize(800, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Inicialitza el contingut de la Finestra1 amb una graella de botons per als diferents dies.
     * @param a LlistaActivitats que conté les activitats per cada dia.
     */
    public void iniContingutFinestra1(LlistaActivitats a) {
        int nfil = 2, ncol = 5;
        this.setLayout(new GridLayout(nfil, ncol, 10, 20));
        AccioBoto1 accioBoto = new AccioBoto1(a);

        for (int i = 0; i < nfil * ncol; i++) {
            LocalDate data = LocalDate.of(2023, 10, (10 + i));
            int nActivitats = a.activitatsDia(data).getNelem();

            // Icono
            ImageIcon icono = new ImageIcon("chemical.png");
            // Dimensiones del icono
            Image imagen = icono.getImage();
            Image nuevaImagen = imagen.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

            // Crea un nuevo ImageIcon con la imagen redimensionada
            ImageIcon iconoNuevo = new ImageIcon(nuevaImagen);
            JButton button = new JButton("DIA " + (i + 10) + " : " + nActivitats + " Activitats", iconoNuevo);
            this.add(button);

            // Personalització del botó
            button.setBorder(BorderFactory.createLineBorder(Color.PINK, 2)); //bordes
            
            Color rosa = new Color(255, 200, 230);
            Color azul = new Color(162, 210, 255);
            if (i % 2 == 0) {
                button.setBackground(rosa);
            } else {
                button.setBackground(azul);
            }

            // Configuració de la font
            button.setFont(new Font("Times New Roman", Font.BOLD, 14));
            button.setForeground(Color.BLACK); // color del text visible

            button.addActionListener(accioBoto); // ActionListener
        }
    }
}