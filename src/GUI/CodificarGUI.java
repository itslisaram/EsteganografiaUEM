package GUI;

import logica.Botones;

import javax.swing.*;
import java.awt.*;

public class CodificarGUI extends JPanel {
    private JLabel titleLabel;
    private JLabel imageLabel;
    private JButton selectFileButton ,selectImageButton;
    private JButton backButton;

    public CodificarGUI(JFrame frame, JPanel mainPanel, Botones botones) {
        setLayout(new BorderLayout());

        titleLabel = new JLabel("Encriptar Imagen", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        add(titleLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        imageLabel = new JLabel("Imagen no seleccionada", JLabel.CENTER);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        centerPanel.add(imageLabel, gbc);

        // Label de mensaje -> cambiar a select File
        selectImageButton = new JButton("Seleccionar Imagen");
        selectImageButton.addActionListener(e -> botones.handleSelectImage(imageLabel));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        centerPanel.add(selectImageButton, gbc);

        selectFileButton = new JButton("Seleccionar Archivo de Texto");
        selectFileButton.addActionListener(e -> botones.handleSelectFile());
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        centerPanel.add(selectFileButton, gbc);

        backButton = new JButton("Volver");
        backButton.addActionListener(e -> botones.handleBack());
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        centerPanel.add(backButton, gbc);

        add(centerPanel, BorderLayout.CENTER);
    }
}
