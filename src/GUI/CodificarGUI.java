package GUI;

import javax.swing.*;
import java.awt.*;

public class CodificarGUI extends JPanel {
    private JLabel messageLabel;
    private JTextField messageField;
    private JButton selectImageButton;
    private JButton encryptButton;

    public CodificarGUI() {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Encriptar Imagen", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        messageLabel = new JLabel("Mensaje:");
        messageField = new JTextField();
        centerPanel.add(messageLabel);
        centerPanel.add(messageField);

        selectImageButton = new JButton("Seleccionar Imagen");
        centerPanel.add(selectImageButton);

        add(centerPanel, BorderLayout.CENTER);

        encryptButton = new JButton("Encriptar");
        add(encryptButton, BorderLayout.SOUTH);
    }
}
