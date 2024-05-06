package utils;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Utils {

    static Random rnd = new Random();

    public static void Alert(String msg, String type)
    {
        int msgtype;
        switch (type) {
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
    
    public static JButton[] getKeys()
    {
        JButton[] keyButton = new JButton[10];
        LinkedList<Integer> exclude = new LinkedList<Integer>();
        int i = 0; //Contador
        while(i < keyButton.length) {
            int n = rnd.nextInt(10);
            if(exclude.contains(n))
                continue;
            else
            {
                keyButton[i] = new JButton(Integer.toString(n));
                keyButton[i].setFont(new Font("Courier", Font.BOLD, 18));
                exclude.push(n);
            }
            i++;
        }
        return keyButton;
    }

    public static String nextFourNumbers()
    {
        int digits = rnd.nextInt(9999);
        String fCardString = String.format("%04d ", digits);
        return fCardString;
    }
}
