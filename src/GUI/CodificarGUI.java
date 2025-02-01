package GUI;

import logica.Botones;

import javax.swing.*;
import java.awt.*;

public class CodificarGUI extends JPanel {
    private JTextArea textArea;
    private JLabel titleLabel, imageLabel;
    private JButton selectImageButton, selectFileButton, encryptButton, backButton;

    public CodificarGUI(JFrame frame, JPanel mainPanel, Botones botones) {
        setLayout(new BorderLayout());

        titleLabel = new JLabel("Encriptar Imagen", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        add(titleLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.CENTER;

        gbc.gridy = 0;
        gbc.gridwidth = 2;
        imageLabel = new JLabel("Imagen no seleccionada", JLabel.CENTER);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        imageLabel.setVisible(false);
        centerPanel.add(imageLabel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 2;
        selectImageButton = new JButton("Seleccionar Imagen");
        selectImageButton.addActionListener(e -> botones.handleSelectImage(imageLabel));
        centerPanel.add(selectImageButton, gbc);

        gbc.gridy = 2;
        textArea = new JTextArea(10, 30);
        textArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textArea.setVisible(false);
        centerPanel.add(textArea, gbc);

        gbc.gridy = 3;
        gbc.gridwidth = 2;
        selectFileButton = new JButton("Seleccionar Archivo de Texto");
        selectFileButton.addActionListener(e -> botones.handleSelectFile(textArea));
        centerPanel.add(selectFileButton, gbc);

        gbc.gridy = 4;
        gbc.gridwidth = 2;
        encryptButton = new JButton("Encriptar Mensaje");
        encryptButton.addActionListener(e -> botones.handleEncodeImage(imageLabel, textArea));
        centerPanel.add(encryptButton, gbc);

        backButton = new JButton("Volver");
        backButton.addActionListener(e -> botones.handleBack());
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        centerPanel.add(backButton, gbc);

        add(centerPanel, BorderLayout.CENTER);
    }
}
