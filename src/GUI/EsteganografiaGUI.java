package GUI;

import javax.swing.*;
import java.awt.*;

public class EsteganografiaGUI extends JFrame {
    private JTextArea textAreaMensaje;

    public EsteganografiaGUI() {
        setTitle("Proyecto Esteganografía UEM");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearInterfaz();
        setLocationRelativeTo(null); // Para centrar la ventana -> Podemos quitarlo si se prefiere esquinada
        setVisible(true);
    }

    private void crearInterfaz() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        // Botones de la interfaz
        JButton cargarImagenBtn = new JButton("Cargar Imagen");
        JButton cargarTextoBtn = new JButton("Cargar Mensaje desde Archivo");
        JButton ocultarMensajeBtn = new JButton("Ocultar Mensaje");
        JButton extraerMensajeBtn = new JButton("Extraer Mensaje");
        JButton guardarTextoBtn = new JButton("Guardar Mensaje en Archivo");

        textAreaMensaje = new JTextArea(10, 30);

        // Acciones de los botones -> cuando se avance en el proyecto RELLENAR

        // Añadir botones al panel
        panel.add(cargarImagenBtn);
        panel.add(cargarTextoBtn);
        panel.add(ocultarMensajeBtn);
        panel.add(extraerMensajeBtn);
        panel.add(guardarTextoBtn);

        // Añadir componentes a la ventana
        add(panel, BorderLayout.CENTER);
        add(new JScrollPane(textAreaMensaje), BorderLayout.SOUTH);
    }
}
