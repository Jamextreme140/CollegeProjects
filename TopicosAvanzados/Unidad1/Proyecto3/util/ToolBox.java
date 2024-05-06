package util;

import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class ToolBox {
    
    static Random rand = new Random();

    public static int randInt(int bound)
    {
        return rand.nextInt(bound);
    }

    public static int randInt(int from, int to)
    {
        return rand.nextInt(from, to);
    }

    /**
     * Resize/Scales the image
     * 
     * @param filename
     * @param w        - Width
     * @param h        - Height
     * @return Scaled Image
     */
    public static ImageIcon createImageIcon(String filename, int w, int h) {
        ImageIcon imgico = new ImageIcon(filename);
        Image img = imgico.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        // Image rimg = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        imgico = new ImageIcon(img);
        return imgico;
    }

    /**
     * Resize/Scales the image on 128x128
     * 
     * @param filename
     * @return Scaled Image
     */
    public static ImageIcon createImageIcon(String filename) {
        ImageIcon imgico = new ImageIcon(filename);
        Image img = imgico.getImage();
        Image rimg = img.getScaledInstance(128, 128, Image.SCALE_SMOOTH);
        imgico = new ImageIcon(rimg);
        return imgico;
    }
}
