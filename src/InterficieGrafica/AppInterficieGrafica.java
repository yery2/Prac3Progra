package InterficieGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Classes.*;
import GestioFitxers.*;


public class AppInterficieGrafica extends JFrame {
    private LlistaAccionsText llistaAccions;
    private LlistaAssociacionsSerial llistaAssociacions;
    private JTextArea textArea;
    private JComboBox<String> comboBox;

    public AppInterficieGrafica(LlistaAccionsText llistaAccions, LlistaAssociacionsSerial llistaAssociacions) {
        this.llistaAccions = llistaAccions;
        this.llistaAssociacions = llistaAssociacions;
        initialize();
    }

    private void initialize() {
        setTitle("Aplicació Gràfica de Demostracions");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        comboBox = new JComboBox<>();
        comboBox.addItem("Totes les associacions");
        for (Entitats entitat : llistaEntitats.getLlistaEntitats()) {
            if (entitat != null) {
                comboBox.addItem(entitat.getNom());
            }
        }
        panel.add(comboBox);

        JButton button = new JButton("Mostrar Demostracions");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDemostracions();
            }
        });
        panel.add(button);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void mostrarDemostracions() {
        String selectedEntitat = (String) comboBox.getSelectedItem();
        textArea.setText("");

        for (Activitats activitat : llistaActivitats.getLlistaActivitats()) {
            if (activitat != null && activitat instanceof Demostracions) {
                Demostracions demostracio = (Demostracions) activitat;
                if (selectedEntitat.equals("Totes les associacions") || demostracio.getEntitat().getNom().equals(selectedEntitat)) {
                    textArea.append(demostracio.toString() + "\n\n");
                }
            }
        }
    }

    public static void main(String[] args) {
        // Crear llistes d'activitats i entitats
        LlistaEntitats llistaEntitats = new LlistaEntitats(10);
        LlistaActivitats llistaActivitats = new LlistaActivitats(30);

        // Afegir entitats i activitats (exemple)
        llistaEntitats.afegir(new Entitats("Generalitat", 496784334, "gen@generalitat.com"));
        llistaEntitats.afegir(new Entitats("Perritos Guapos", 364735435, "adoptaunperrito@gmail.dog"));

        LocalDate date = LocalDate.of(2023, 10, 10);
        llistaActivitats.afegir(new Demostracions("Moda", "BCN", 27, date, llistaEntitats.getLlistaEntitats()[0], "Descripció de la demostració"));

        // Crear i mostrar la interfície gràfica
        AppInterficieGrafica app = new AppInterficieGrafica(llistaActivitats, llistaEntitats);
        app.setVisible(true);
    }
}
