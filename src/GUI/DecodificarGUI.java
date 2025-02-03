package GUI;

import logica.Botones;
import javax.swing.*;
import java.awt.*;

public class DecodificarGUI extends JPanel {

    private JLabel titleLabel, imageLabel;
    private JTextArea textArea;

    private JButton loadImageButton, decodeImageButton, saveFileButton, backButton;

    public DecodificarGUI(JFrame frame, JPanel mainPanel, Botones botones) {
        setLayout(new BorderLayout());

        titleLabel = new JLabel("Decodificar Imagen", JLabel.CENTER);
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
        loadImageButton = new JButton("Cargar Imagen");
        loadImageButton.addActionListener(e -> botones.handleSelectImage(imageLabel));
        centerPanel.add(loadImageButton, gbc);

        gbc.gridy = 2;
        textArea = new JTextArea(10, 30);
        textArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        textArea.setVisible(false);
        centerPanel.add(textArea, gbc);

        gbc.gridy = 3;
        gbc.gridwidth = 2;
        decodeImageButton = new JButton("Decodificar Imagen");
        decodeImageButton.addActionListener(e -> botones.handleDecodeImage(imageLabel, textArea));
        centerPanel.add(decodeImageButton, gbc);

        gbc.gridy = 4;
        gbc.gridwidth = 2;
        saveFileButton = new JButton("Guardar Mensaje");
        saveFileButton.addActionListener(e -> botones.handleSaveImage(imageLabel, textArea));
        centerPanel.add(saveFileButton, gbc);

        gbc.gridy = 5;
        gbc.gridwidth = 2;
        backButton = new JButton("Volver");
        backButton.addActionListener(e -> botones.handleBack());
        centerPanel.add(backButton, gbc);

        add(centerPanel, BorderLayout.CENTER);
    }
}
