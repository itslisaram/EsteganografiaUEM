package util;

import javax.swing.*;
import java.awt.*;

public class ImageUtils {
    public static ImageIcon loadImage(String imagePath) {
        try {
            ImageIcon originalIcon = new ImageIcon(imagePath);
            int originalWidth = originalIcon.getIconWidth();
            int originalHeight = originalIcon.getIconHeight();

            boolean isWidthSmaller = (originalWidth < originalHeight);
            int newWidth, newHeight;

            if (isWidthSmaller) {
                newWidth = 200;
                newHeight = (int) ((double) originalHeight * ((double) 200 / (double) originalWidth));
            } else {
                newHeight = 200;
                newWidth = (int) ((double) originalWidth * ((double) 200 / (double) originalHeight));
            }

            Image scaledImage = originalIcon.getImage()
                    .getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            return new ImageIcon(scaledImage);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
