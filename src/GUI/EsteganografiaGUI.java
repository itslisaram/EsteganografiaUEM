package GUI;

import logica.Botones;
//import util.*;

import javax.swing.*;
import java.awt.*;

public class EsteganografiaGUI extends JFrame {
    private Botones botones;
    
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JButton encryptButton;
    private JButton decryptButton;
    private JButton exitButton;
    
    public EsteganografiaGUI() {
        setTitle("Esteganografía");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        titleLabel = new JLabel("Herramienta de Esteganografía", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titleLabel, BorderLayout.NORTH);

        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 50, 10, 50);

        encryptButton = new JButton("Codificar imagen");
        encryptButton.setPreferredSize(new Dimension(130, 40));

        decryptButton = new JButton("Decodificar imagen");
        decryptButton.setPreferredSize(new Dimension(130, 40));

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(encryptButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(decryptButton, gbc);

        add(mainPanel, BorderLayout.CENTER);

        exitButton = new JButton("Salir");
        exitButton.setPreferredSize(new Dimension(110, 30));

        JPanel exitPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        exitPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));
        exitPanel.add(exitButton);
        add(exitPanel, BorderLayout.SOUTH);

        botones = new Botones(this, mainPanel);
        encryptButton.addActionListener(e -> botones.handleCodificar());
        exitButton.addActionListener(e -> botones.handleExit());

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
