package components.multicapture;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CapturePhone extends JTextField implements KeyListener{

    String phoneRegex = "^[0-9]{10}$";

    public CapturePhone()
    {
        super();
        addListeners();
    }

    void addListeners()
    {
        this.addKeyListener(this);
    }

    boolean isPhone(String text)
    {
        return text.matches(phoneRegex);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(getText().length() <= 0)
        {
            setBorder(new LineBorder(Color.GRAY));
            return;
        }
        else if (isPhone(getText())) 
        {
            setBorder(new LineBorder(Color.GREEN));
            return;
        } 
        else 
        {
            setBorder(new LineBorder(Color.RED));
            return;
        }
    }

}
