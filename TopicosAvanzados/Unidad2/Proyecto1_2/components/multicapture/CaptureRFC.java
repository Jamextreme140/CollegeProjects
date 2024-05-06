package components.multicapture;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CaptureRFC extends JTextField implements KeyListener{

    String RFCregrex = "^[A-Z]{4}[0-9]{6}[A-Z0-9]{3}$";

    public CaptureRFC()
    {
        super();
        addListeners();
    }

    void addListeners()
    {
        this.addKeyListener(this);
    }

    boolean isRFC(String text)
    {
        return text.matches(RFCregrex);
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
        else if (isRFC(getText())) 
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
