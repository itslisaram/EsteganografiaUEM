package logica;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Botones {
    private final JFrame frame;

    public Botones(JFrame frame) {
        this.frame = frame;
    }

    public void handleExit(ActionEvent e) {
        frame.dispose();
    }
}
