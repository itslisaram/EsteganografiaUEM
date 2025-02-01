package util;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Esteganografia {
    public static ImageIcon cifrarMensaje(JLabel imageLabel, JTextArea textArea) throws IOException {
        if (imageLabel.getIcon() == null)
            throw new IllegalArgumentException("No hay imagen para encriptar.");

        ImageIcon icon = (ImageIcon) imageLabel.getIcon();
        Image originalImage = icon.getImage();
        BufferedImage originalBuffered = toBufferedImage(originalImage);

        String mensaje = textArea.getText();
        if (mensaje == null || mensaje.isEmpty())
            throw new IllegalArgumentException("No hay mensaje para encriptar.");

        BufferedImage imagenCifrada = cifrarMesaje(originalBuffered, mensaje);
        return new ImageIcon(imagenCifrada);
    }

    private static BufferedImage cifrarMesaje(BufferedImage img, String txt) {
        BufferedImage bf = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        String mensaje = txt + '\0';
        int textIndex = 0;
        boolean terminado = false;

        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                int pixel = img.getRGB(x, y);

                if (!terminado && textIndex < mensaje.length()) {
                    char c = mensaje.charAt(textIndex++);
                    int newPixel = (pixel & 0xFFFFFF00) | c;

                    bf.setRGB(x, y, newPixel);
                    if (textIndex == mensaje.length())
                        terminado = true;
                } else
                    bf.setRGB(x, y, pixel);
            }
        }

        return bf;
    }

    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage)
            return (BufferedImage) img;

        BufferedImage bimage = new BufferedImage(
                img.getWidth(null),
                img.getHeight(null),
                BufferedImage.TYPE_INT_RGB);

        Graphics2D g = bimage.createGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        return bimage;
    }

    public static String decifrarMensaje(JLabel imageLabel) {
        if (imageLabel.getIcon() == null)
            throw new IllegalArgumentException("No hay imagen para decodificar.");

        ImageIcon icon = (ImageIcon) imageLabel.getIcon();
        Image originalImage = icon.getImage();
        BufferedImage bf = toBufferedImage(originalImage);

        return extraerMensaje(bf);
    }

    private static String extraerMensaje(BufferedImage bf) {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < bf.getWidth(); x++) {
            for (int y = 0; y < bf.getHeight(); y++) {
                int pixel = bf.getRGB(x, y);
                char c = (char) (pixel & 0xFF);
                if (c == '\0')
                    return sb.toString();

                sb.append(c);
            }
        }
        return sb.toString();
    }
}
