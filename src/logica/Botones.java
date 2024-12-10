package logica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Botones {
    private final JFrame frame;
    private final JPanel mainPanel;

    public Botones(JFrame frame, JPanel mainPanel) {
        this.frame = frame;
        this.mainPanel = mainPanel;
    }

    public void handleExit(ActionEvent e) {
        frame.dispose();
    }

    public void handleCodificar(ActionEvent e) {
        CardLayout layout = (CardLayout) mainPanel.getLayout();
        layout.show(mainPanel, "CodificarPanel");
    }

    public void handleDecodificar(ActionEvent e) {
        CardLayout layout = (CardLayout) mainPanel.getLayout();
        layout.show(mainPanel, "DecodificarPanel");
    }
}
