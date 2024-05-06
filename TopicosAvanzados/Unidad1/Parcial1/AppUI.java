
import javax.swing.*;
import java.awt.*;
import util.ToolBox;

public class AppUI extends JFrame{

    private JPanel ids, buttons, persons;
    private JButton enter, exit;
    private JRadioButton[] personID, vipPerson;
    private ButtonGroup personGroup;
    //Torniquete torSystem;

    public AppUI()
    {
        super("Torniquete");
        //torSystem = new Torniquete();
        init();
    }

    private void init()
    {
        setSize(500, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void setUI(int[] idArr, String[] namesArr)
    {
        ids = new JPanel(new GridLayout(0, 2, 2, 2));
        //personID = new JRadioButton[torSystem.getPeople().length];
        personID = new JRadioButton[idArr.length];
        personGroup = new ButtonGroup();
        setIDs(idArr);

        buttons = new JPanel(new GridLayout(0, 1, 5, 5));
        buttons.add(new JLabel(ToolBox.createImageIcon("Imagen1.jpg")));
        enter = new JButton("Entrar");
        exit = new JButton("Salir");
        buttons.add(enter);
        buttons.add(exit);
        add(buttons, BorderLayout.CENTER);

        persons = new JPanel(new GridLayout(0, 1));
        //vipPerson = new JRadioButton[torSystem.getVipPeople().capacity()];
        vipPerson = new JRadioButton[namesArr.length];
        setVIPPeople(namesArr);
    }

    public void showUI()
    {
        setVisible(true);
    }

    public void setIDs(int[] id)
    {
        /* 
        for (int i = 0; i < personID.length; i++) {
            personID[i] = new JRadioButton(Integer.toString(torSystem.getPeople(i).getId()));
            personGroup.add(personID[i]);
            ids.add(personID[i]);
        }
        */
        for (int i = 0; i < personID.length; i++) {
            personID[i] = new JRadioButton(Integer.toString(id[i]));
            personGroup.add(personID[i]);
            ids.add(personID[i]);
        }
        
        add(ids, BorderLayout.WEST);
    }

    public void setVIPPeople(String[] name)
    {
        
        /*
        for (int i = 0; i < vipPerson.length; i++) {
            vipPerson[i] = new JRadioButton(torSystem.getVipPeople(i).getName());
            personGroup.add(vipPerson[i]);
            persons.add(vipPerson[i]);
        }
        */
        for (int i = 0; i < vipPerson.length; i++) {
            vipPerson[i] = new JRadioButton(name[i]);
            personGroup.add(vipPerson[i]);
            persons.add(vipPerson[i]);
        }
        add(persons, BorderLayout.EAST);
    }

    public void addListeners(Controller ctrl)
    {
        enter.addActionListener(ctrl);
        exit.addActionListener(ctrl);
    }
    /*
    public boolean enter(String id)
    {
        return torSystem.enter(id);
    }
    public boolean exit(String id)
    {
        return torSystem.exit(id);
    }
    */

    public ButtonGroup getPersonGroup() {
        return personGroup;
    }

    public JButton getEnter() {
        return enter;
    }

    public JButton getExit() {
        return exit;
    }
}
