import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

import util.ToolBox;

public class Controller implements ActionListener{

    private AppUI view;
    private Torniquete model;

    public Controller(AppUI view, Torniquete model)
    {
        this.view = view;
        this.model = model;
        sendToUI();
    }

    public void sendToUI()
    {
        //int idlenght = model.getPeople().length;
        int[] idarr = new int[model.getPeople().length];
        for (int i = 0; i < idarr.length; i++) {
            idarr[i] = model.getPeople(i).getId();
        }
        String[] vipArr = new String[model.getVipPeople().capacity()];
        for (int i = 0; i < vipArr.length; i++) {
            vipArr[i] = model.getVipPeople(i).getName();
        }
        view.setUI(idarr, vipArr);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == view.getEnter())
        {
            if(model.enter(getSelectedButton(view.getPersonGroup()))) ToolBox.Alert("La persona a ingresado con exito", "");
            else ToolBox.Alert("Esta persona ya se encuentra adentro", "Error");
            return;
        }
        else if(evt.getSource() == view.getExit())
        {
            if(model.exit(getSelectedButton(view.getPersonGroup()))) ToolBox.Alert("La persona a salido con exito", "");
            else ToolBox.Alert("Esta persona ya no se encuetra adentro", "Error");
            return;
        }
    }

    private String getSelectedButton(ButtonGroup curBGroup)
    {
        for(Enumeration<AbstractButton> btns = curBGroup.getElements(); btns.hasMoreElements();)
        {
            AbstractButton btn = btns.nextElement();
            if(btn.isSelected()) return btn.getText();
        }
        return null;
    }

}
