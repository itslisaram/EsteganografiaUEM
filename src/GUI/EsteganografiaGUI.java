package GUI;

import logica.*;
//import util.*;

import javax.swing.*;
import java.awt.*;

public class EsteganografiaGUI extends JFrame {
    private JLabel titleLabel;
    private JButton encryptButton;
    private JButton decryptButton;
    private JButton exitButton;
    
    public EsteganografiaGUI() {
        setTitle("Esteganografía");
        setSize(600, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        titleLabel = new JLabel("Herramienta de Esteganografía", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints();

        buttonPanel.setLayout(new GridBagLayout());

        encryptButton = new JButton("Encriptar imagen");
        encryptButton.setPreferredSize(new Dimension(150, 50));

        decryptButton = new JButton("Decodificar imagen");
        decryptButton.setPreferredSize(new Dimension(150, 50));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 40, 20, 40);
        buttonPanel.add(encryptButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        buttonPanel.add(decryptButton, gbc);

        add(buttonPanel, BorderLayout.CENTER);

        JPanel exitPanel = new JPanel(new BorderLayout());
        exitButton = new JButton("Salir");
        exitButton.setPreferredSize(new Dimension(100, 30));
        
        
        exitPanel.add(exitButton, BorderLayout.EAST);
        exitPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));

        add(exitPanel, BorderLayout.SOUTH);

        Botones bLogic = new Botones(this);
        exitButton.addActionListener(bLogic::handleExit);

        setLocationRelativeTo(null);

        setVisible(true);
    }
}
