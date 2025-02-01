package logica;

import GUI.*;
import util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

    public void handleDecodificar() {
        DecodificarGUI decodificarPanel = new DecodificarGUI(frame, mainPanel, this);
        frame.setContentPane(decodificarPanel);
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
                imageLabel.setVisible(true);
            } else {
                imageLabel.setText("Error al cargar la imagen");
                imageLabel.setVisible(true);
            }
        }
    }

    public void handleSelectFile(JTextArea textArea) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Archivos de texto", "txt", "log", "csv");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            FicheroTexto fichero = new FicheroTexto(selectedFile);
            String contenido = fichero.leerArchivo();
            textArea.setText(contenido);

            Dimension preferred = textArea.getPreferredSize();
            if (preferred.width < 300)
                preferred.width = 300;

            textArea.setPreferredSize(preferred);
            textArea.setVisible(true);
            textArea.revalidate();
        }
    }

    public void handleEncodeImage(JLabel imageLabel, JTextArea textArea) {
        try {
            ImageIcon encryptedIcon = Esteganografia.cifrarMensaje(imageLabel, textArea);

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar imagen encriptada");
            fileChooser.setSelectedFile(new File("imagen_Codificada.png"));

            int userSelection = fileChooser.showSaveDialog(frame);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                BufferedImage encryptedBuffered = Esteganografia.toBufferedImage(encryptedIcon.getImage());

                ImageIO.write(encryptedBuffered, "png", fileToSave);
                imageLabel.setIcon(encryptedIcon);

                JOptionPane.showMessageDialog(frame, "Mensaje cifrado y guardado en: " + fileToSave.getAbsolutePath());
                imageLabel.setIcon(null);
                imageLabel.setText("Imagen no seleccionada");
                imageLabel.setVisible(false);

                textArea.setText("");
                textArea.setVisible(false);
            }

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Error guardando la imagen: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error al encriptar: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void handleDecodeImage(JLabel imageLabel, JTextArea textArea) {
        try {
            String mensajeOculto = Esteganografia.decifrarMensaje(imageLabel);
            textArea.setText(mensajeOculto);

            Dimension preferred = textArea.getPreferredSize();
            if (preferred.width < 300)
                preferred.width = 300;

            textArea.setPreferredSize(preferred);
            textArea.setVisible(true);
            textArea.revalidate();

            JOptionPane.showMessageDialog(frame, "Mensaje decodificado correctamente.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error al decodificar: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
