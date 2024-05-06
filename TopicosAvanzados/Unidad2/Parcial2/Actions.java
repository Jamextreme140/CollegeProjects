import java.awt.event.*;
import java.util.regex.Pattern;

public class Actions implements KeyListener, ComponentListener{

    MainView view;
    Backend model;

    public Actions(MainView view, Backend model)
    {
        this.view = view;
        this.model = model;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource() == view.getIntegerField())
        {
            if(view.getIntegerField().getText().length() < 0)
                return;
            if (!Pattern.matches("^[0-9]+$", String.valueOf(e.getKeyChar()))) {
                e.consume();
                return;
            }
            String curText = view.getIntegerField().getText() + e.getKeyChar();
            view.updateUI(0, model.binString(curText), model.hexString(curText));
        }
        else if(e.getSource() == view.getBinaryField())
        {
            if(view.getBinaryField().getText().length() < 0)
                return;
            if (!Pattern.matches("^[0-1]+$", String.valueOf(e.getKeyChar()))) {
                e.consume();
                return;
            }
            String curText = view.getBinaryField().getText() + e.getKeyChar();
            view.updateUI(1, model.intString(curText, 2), model.hexString(model.intString(curText, 2)));
        }
        else if(e.getSource() == view.getHexField())
        {
            if(view.getHexField().getText().length() < 0)
                return;
            if(!Pattern.matches("^[0-9A-Fa-f]+$", String.valueOf(e.getKeyChar())))
            {
                e.consume();
                return;
            }
            String curText = view.getHexField().getText() + e.getKeyChar();
            view.updateUI(2, model.intString(curText, 16), model.binString(model.intString(curText, 16)));
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void componentResized(ComponentEvent e) {
        view.resize();
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
