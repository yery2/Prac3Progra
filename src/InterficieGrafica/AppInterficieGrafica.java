package InterficieGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import Classes.*;
import GestioFitxers.*;
import Llistes.LlistaAccions;

public class AppInterficieGrafica extends JFrame {
    private LlistaAccions llistaAccions;
    private LlistaAssociacionsSerial llistaAssociacions;
    private JTextArea textArea;
    private List<JCheckBox> checkBoxes;

    public AppInterficieGrafica(LlistaAccions llistaAccions, LlistaAssociacionsSerial llistaAssociacions) {
        this.llistaAccions = llistaAccions;
        this.llistaAssociacions = llistaAssociacions;
        initialize();
    }

    private void initialize() {
        setTitle("Aplicació Gràfica de Demostracions");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para los checkboxes de asociaciones
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        // Crear checkboxes dinámicamente según las asociaciones
        checkBoxes = new ArrayList<>();
        for (int i = 0; i < llistaAssociacions.getNElem(); i++) {
            Associacio associacio = llistaAssociacions.getAssociacio(i);
            if (associacio != null) {
                JCheckBox checkBox = new JCheckBox(associacio.getNomAssociacio());
                checkBoxes.add(checkBox);
                panel.add(checkBox);
            }
        }

        // Scroll para checkboxes
        JScrollPane scrollPaneCheckBoxes = new JScrollPane(panel);
        scrollPaneCheckBoxes.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneCheckBoxes.setPreferredSize(new Dimension(300, 800));

        // Botón para mostrar demostraciones
        JButton button = new JButton("Mostrar Demostracions");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDemostracions();
            }
        });

        // Panel para el botón
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button);

        // TextArea para mostrar resultados
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPaneTextArea = new JScrollPane(textArea);

        // Añadir componentes al layout principal
        add(scrollPaneCheckBoxes, BorderLayout.WEST);
        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPaneTextArea, BorderLayout.CENTER);
    }

    private void mostrarDemostracions() {
        textArea.setText(""); // Limpiar el área de texto
        List<String> selectedAssociacions = new ArrayList<>();

        // Recoger las asociaciones seleccionadas
        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                selectedAssociacions.add(checkBox.getText());
            }
        }

        // Filtrar y mostrar demostraciones relacionadas con las asociaciones seleccionadas
        for (int i = 0; i < llistaAccions.getNumAccions(); i++) {
            Accio accio = llistaAccions.getAccio(i);
            if (accio instanceof Demostracio) {
                Demostracio demostracio = (Demostracio) accio;
                for (String nomAssociacio : demostracio.getNomAssociacions()) {
                    if (selectedAssociacions.contains(nomAssociacio)) {
                        textArea.append(demostracio.toString() + "\n\n");
                        break; // Evitar duplicados
                    }
                }
            }
        }

        // Si no hay resultados, mostrar mensaje
        if (textArea.getText().isEmpty()) {
            textArea.setText("No s'han trobat demostracions per a les associacions seleccionades.");
        }
    }

    public static void main(String[] args) {
        // Crear llistes d'activitats i entitats
        LlistaAssociacionsSerial llistaAssociacions = new LlistaAssociacionsSerial();
        LlistaAccions llistaAccions = new LlistaAccions();
        LlistaAccionsText llistaAccionstxt = new LlistaAccionsText();

        // Carregar associacions i accions
        llistaAssociacions.carregarAssociacions();
        llistaAccionstxt.carregarAccions(llistaAccions);

        // Crear i mostrar la interfície gràfica
        AppInterficieGrafica app = new AppInterficieGrafica(llistaAccions, llistaAssociacions);
        app.setVisible(true);
    }
}
