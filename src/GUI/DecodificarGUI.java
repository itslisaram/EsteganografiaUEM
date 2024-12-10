package GUI;

import javax.swing.*;
import java.awt.*;

public class DecodificarGUI extends JPanel {
    private JLabel titleLabel;

    public DecodificarGUI() {
        setSize(600, 350);
        setLayout(new BorderLayout());

        titleLabel = new JLabel("Decodificar Imagen", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);
    }
}
