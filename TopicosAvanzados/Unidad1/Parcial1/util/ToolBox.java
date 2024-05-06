package util;

import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class ToolBox {
    
    static Random rand = new Random();
    static String[] VN = { "Zoila", "Daniel", "Yessenia", "Luis", "Anastacia", "Plutarco", "Alicia", "Maria", "Sofia",
            "Antonio", "Nereida", "Carolina",
            "Rebeca", "Javier", "Luis" };
    static String[] VA = { "Garcia", "Lopez", "Perez", "Urias", "Mendoza", "Coppel", "Diaz" };
    static boolean [] Genre={false,true,false,true,false,true,false,false,false,true,false,false,false,true,true};	

    public static int randInt(int bound)
    {
        return rand.nextInt(bound);
    }

    public static int randInt(int from, int to)
    {
        return rand.nextInt(from, to);
    }

    public static String randName(int Number){
		String Nom = "", NomTra = "";
        int Pos;
        boolean Genero = true;

        for (int i = 0; i < Number; i++) {
            Pos = randInt(VN.length);

            NomTra = VN[Pos] + " ";

            if (i == 0) {
                Genero = Genre[Pos];

            }

            if (Genero != Genre[Pos] || i > 0 && Nom.indexOf(NomTra) > -1) {
                i--;
                continue;
            }

            Nom += NomTra;

        }
        for (byte i = 0; i < 2; i++) {
            Nom += VA[randInt(VA.length)] + " ";
        }
        return Nom.trim();
	} 

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
