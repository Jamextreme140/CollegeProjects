package components.multicapture;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.*;

public class CaptureProgram extends JFrame implements ComponentListener
{

    CapturePanel panel, panel2;

    public CaptureProgram()
    {
        super("MultiCapture");
        init();
        addListeners();
    }

    void init()
    {
        setSize(856, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        panel = new CapturePanel();
        panel.setBounds(3, 3, 400, 400);

        panel2 = new CapturePanel();
        panel2.setBounds(panel.getX() + panel.getWidth() + 30, panel.getY(), panel.getWidth(), panel.getHeight());
        panel.setLocation(3, 3);
        add(panel);
        add(panel2);
        
        setVisible(true);
    }

    void addListeners()
    {
        this.addComponentListener(this);
    }

    public CapturePanel getPanel() {
        return panel;
    }
     
    public CapturePanel getPanel2() {
        return panel2;
    }
    
    @Override
    public void componentResized(ComponentEvent e) {
        int w = this.getWidth();
        int x = (int)(w * 0.01);
        int width = (int)(w * 0.47);
        panel.setBounds(x, panel.getY(), width, panel.getHeight());
        
        x = (int)(w * 0.50);
        width = (int)(w * 0.47);
        panel2.setBounds(x, panel2.getY(), width, panel2.getHeight());
        
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

}
