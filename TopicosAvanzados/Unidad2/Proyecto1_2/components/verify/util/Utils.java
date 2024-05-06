package components.verify.util;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class Utils {

    static Random rnd = new Random();

    /**
     * Displays a popup message
     * @param msg - Message
     * @param type - Warning | Error | Question | Information (default)
     */
    public static void Alert(String msg, String type)
    {
        int msgtype;
        switch(type)
        {
            case "Warning":
                msgtype = JOptionPane.WARNING_MESSAGE;
                break;
            case "Error":
                msgtype = JOptionPane.ERROR_MESSAGE;
                break;
            case "Question":
                msgtype = JOptionPane.QUESTION_MESSAGE;
                break;
            default:
                msgtype = JOptionPane.INFORMATION_MESSAGE;
                type = "Information";
                break;
        }
        JOptionPane.showMessageDialog(null, msg, type, msgtype);
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
     * Returns a random font from the system
     * @return a random Font
     */
    public static Font nextFont()
    {
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        int pointer = nextInt(0, fonts.length);
        Font curFont = new Font(fonts[pointer], Font.PLAIN, 12);
        return curFont;
    }

    public static int nextInt(int from, int to)
    {
        return rnd.nextInt(from, to);
    }
}
