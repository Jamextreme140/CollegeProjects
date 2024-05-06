package components.multicapture;

import java.awt.event.*;

public class CapturePanelController implements ActionListener, ComponentListener
{

    private CapturePanel view;

    public CapturePanelController(CapturePanel view)
    {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getNewFieldButton())
        {
            System.out.println("New field");
            view.addField(this);
            view.resizePanel();
            return;
        }

        for (int i = 0; i < view.getDeleteFieldBtn().length; i++) {
            if(e.getSource() == view.getDeleteFieldBtn()[i])
            {
                System.out.println("Delete field - " + i);
                view.removeField(i);
                view.resizePanel();
                return;
            }
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        view.resizeLayout();
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
