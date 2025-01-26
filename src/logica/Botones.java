package logica;

import GUI.*;
import util.FicheroTexto;
import util.ImageUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;

public class Botones {
    private final JFrame frame;
    private final JPanel mainPanel;

    public Botones(JFrame frame, JPanel mainPanel) {
        this.frame = frame;
        this.mainPanel = mainPanel;
    }

    public void handleExit() {
        frame.dispose();
    }

    public void handleCodificar() {
        CodificarGUI codificarPanel = new CodificarGUI(frame, mainPanel, this);
        frame.setContentPane(codificarPanel);
        frame.revalidate();
        frame.repaint();
    }

    public void handleDeodificar() {
        CodificarGUI codificarPanel = new CodificarGUI(frame, mainPanel, this);
        frame.setContentPane(codificarPanel);
        frame.revalidate();
        frame.repaint();
    }

    public void handleBack() {
        frame.dispose();
        new EsteganografiaGUI();
    }

    public void handleSelectImage(JLabel imageLabel) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            ImageIcon imageIcon = ImageUtils.loadImage(selectedFile.getAbsolutePath());
            if (imageIcon != null) {
                imageLabel.setIcon(imageIcon);
                imageLabel.setText("");
            } else {
                imageLabel.setText("Error al cargar la imagen");
            }
        }
    }

    public void handleSelectFile() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Archivos de texto", "txt", "log", "csv");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            FicheroTexto fichero = new FicheroTexto(selectedFile);
            fichero.leerArchivo();
        }
    }
}
