package PartGrafica;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import ListaClases.*;

public class Finestra2 extends JFrame{
    private JPanel panellBottons = new JPanel();
    private JTextArea area = new JTextArea();
    private JScrollPane scroll;
    
    public Finestra2(String titol){
        super(titol);
        this.setLocation(900, 100);
        this.setLayout(new BorderLayout());
        this.setSize(600, 600); 
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void afegirTextArea(String s) {
        area.setSize(400,400);
        area.setText(""); // borrar Text Area (actualiza el texto)
		this.area.append(s+"\n"); //escribir texto
        
	}


    public void iniContingutFinestra2(LlistaActivitats act, int dia) {
            this.add(area, BorderLayout.CENTER);
            panellBottons.setLayout(new FlowLayout());
            this.add(panellBottons, BorderLayout.NORTH);
            scroll = new JScrollPane (area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            this.add(scroll);

            LocalDate data= LocalDate.of(2023, 10, dia);
            LlistaActivitats a = act.activitatsDia(data);
            Color rosa = new Color(255, 200, 230);

            // Icono
            ImageIcon icon1 = new ImageIcon("Tallers.png");
            ImageIcon icon2 = new ImageIcon("Xerrades.png");
            ImageIcon icon3 = new ImageIcon("Visites.png");

            // Dimensiones del icono
            Image imagen1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            Image imagen2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            Image imagen3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
 
            // Crea un nuevo ImageIcon con la imagen redimensionada
            ImageIcon iconoTaller = new ImageIcon(imagen1);
            ImageIcon iconoXerrada = new ImageIcon(imagen2);
            ImageIcon iconoVisita = new ImageIcon(imagen3);
            

            JButton button1 = new JButton("Tallers", iconoTaller);
            JButton button2 = new JButton("Xerrades", iconoXerrada);
            JButton button3 = new JButton("Visites", iconoVisita);

            // Datos de cada boton
            LlistaActivitats tallers = a.subllistaTallers();
            LlistaActivitats xerrades = a.subllistaXerrades();
            LlistaActivitats visites  = a.subllistaVisites();

            // Tamaño de los botones
            Dimension dimension = new Dimension(150, 80); 
            button1.setPreferredSize(dimension);
            button2.setPreferredSize(dimension);
            button3.setPreferredSize(dimension);

                     
            panellBottons.add(button1); 
            panellBottons.add(button2);
            panellBottons.add(button3);  

            // Font para los botones
            Font fontBotones = new Font("Serif", Font.BOLD, 12);
            button1.setFont(fontBotones);
            button2.setFont(fontBotones);
            button3.setFont(fontBotones);

            if(tallers.esBuit()){
                button1.setBackground(Color.RED);
            }
            else{
                button1.setBackground(rosa);

            } 

            if(visites.esBuit()){
                button3.setBackground(Color.RED);
            }
            else {button3.setBackground(rosa);}
          
            if(xerrades.esBuit()){
                button2.setBackground(Color.RED);
            }
            else {button2.setBackground(rosa);}
            button1.addActionListener(new AccioBoto2(this, tallers, xerrades, visites));
            button2.addActionListener(new AccioBoto2(this, tallers, xerrades, visites));
            button3.addActionListener(new AccioBoto2(this, tallers, xerrades, visites));   

            // Configuración del font para el JTextArea
            Font fontTextArea = new Font("Times New Roman", Font.PLAIN, 14); // Puedes ajustar el tipo y tamaño de la fuente
            area.setFont(fontTextArea);

             // Configuración del color de fondo para el JTextArea
            Color colorFondoTextArea = new Color(173, 216, 230); 
            area.setBackground(colorFondoTextArea);
    }
}
    
  
