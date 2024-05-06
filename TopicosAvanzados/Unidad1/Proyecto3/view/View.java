package view;

import javax.swing.*;

import backend.Controller;

public class View extends JFrame{
    
    //fields
    JPanel view;
    public JLabel[] seaPortName;
    public JButton[] btnShip;
    public JLabel[][] delivered;

    public View()
    {
        super("Barcos");
        
        init();
        //addListeners();
    }

    private void init()
    {
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addListeners(Controller ctrl)
    {
        for (JButton btn : btnShip) {
            btn.addActionListener(ctrl);
        }
    }

    public void showUI()
    {
        setVisible(true);
    }

    public JPanel getView() {
        return view;
    }

}
