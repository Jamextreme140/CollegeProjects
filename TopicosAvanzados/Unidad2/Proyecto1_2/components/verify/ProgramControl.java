package components.verify;

import java.awt.event.*;
import components.verify.backend.VerifySystem;

public class ProgramControl implements ActionListener, ComponentListener, KeyListener
{

    VerifySystem model;
    VerifyField view;

    public ProgramControl(VerifySystem model, VerifyField view)
    {
        this.model = model;
        this.view = view;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        view.resizePanel();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void componentShown(ComponentEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("a");
        switch (e.getActionCommand())
        {
            case "Default" -> {
                view.getInputTextField().setFont(view.getDefaulFont());
            }
            case "Random" -> {
                view.getInputTextField().setFont(view.getRandFont());
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String img;
        if(!(img = model.check(view.getInputTextField().getText().toLowerCase())).equals(""))
        {
            // Open Image
            view.showImage(img);
            return;
        }
        else
        {
            // Close image
            view.closeImage();
        }
        
        if(view.getInputTextField().getText().length() <= 0)
        {
            view.setLabel("");
            view.getInputTextField().setText(model.getHint());
            view.getInputTextField().selectAll();
        }
        else
        {
            view.setLabel(model.getHint());
        }
    }

}
