package components.multicapture;

import javax.swing.*;
import java.awt.*;

public class CapturePanel extends JPanel 
{
    private JScrollPane scrollpanel;
    private JPanel fieldsview;
    private JRadioButton email, rfc, phone;
    private ButtonGroup selectType;
    private JButton newFieldButton;

    private int arrayPointer;
    private int curType;
    private CaptureEmail[] emailField;
    private CaptureRFC[] RFCField;
    private CapturePhone[] phoneField;
    private JButton[] deleteFieldBtn;
    
    public CapturePanel()
    {
        super();
        arrayPointer = -1;
        init();
        //addListeners();
    }

    void init()
    {
        setLayout(null);
        //setSize(400, 400);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // setSize(400, 400);
        email = new JRadioButton("Email", true);
        email.setBounds(25, 15, 80, 20);
        emailField = new CaptureEmail[10];

        rfc = new JRadioButton("RFC");
        rfc.setBounds(165, 15, 80, 20);
        RFCField = new CaptureRFC[10];

        phone = new JRadioButton("Phone");
        phone.setBounds(303, 15, 80, 20);
        phoneField = new CapturePhone[10];

        deleteFieldBtn = new JButton[10];

        selectType = new ButtonGroup();
        selectType.add(email);
        selectType.add(rfc);
        selectType.add(phone);

        newFieldButton = new JButton("Create New Box");
        newFieldButton.setBounds(5, 53, 389, 34);

        fieldsview = new JPanel();
        fieldsview.setLayout(null);
        fieldsview.setBounds(5, 94, 389, 296);
        fieldsview.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        scrollpanel = new JScrollPane(fieldsview);
        scrollpanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        add(email);
        add(rfc);
        add(phone);
        add(newFieldButton);
        add(fieldsview);
        add(scrollpanel);
    }

    public void addListeners(CapturePanelController ctrl)
    {
        newFieldButton.addActionListener(ctrl);
        addComponentListener(ctrl);
    }

    public void addField(CapturePanelController ctrl)
    {
        arrayPointer++;
        if (arrayPointer > -1) {
            curType = getSelected();
            setRButtons(false);
        }
        if (arrayPointer < 10) {
            if (checkEmpty()) {
                arrayPointer--;
                return;
            }
            addNewField(curType);
            deleteFieldBtn[arrayPointer] = new JButton("X");
            deleteFieldBtn[arrayPointer].addActionListener(ctrl);
            fieldsview.add(deleteFieldBtn[arrayPointer]);
        } else {
            arrayPointer--;
            Utils.Alert("Text box limit reached", "Error");
            return;
        }

    }

    private boolean checkEmpty() {
        switch (curType)
        {
            case 0 -> {
                for (CaptureEmail field : emailField) {
                    if (field != null) {
                        if (field.getText().length() <= 0) {
                            Utils.Alert("No box can't be empty", "Error");
                            return true;
                        }
                    }
                    
                }
            }
            case 1 -> {
                for (CaptureRFC field : RFCField) {
                    if (field != null) {
                        if (field.getText().length() <= 0) {
                            Utils.Alert("No box can't be empty", "Error");
                            return true;
                        }
                    }
                    
                }
            }
            case 2 -> {
                for (CapturePhone field : phoneField) {
                    if (field != null) {
                        if (field.getText().length() <= 0) {
                            Utils.Alert("No box can't be empty", "Error");
                            return true;
                        }
                    }
                    
                }
            }
        }
        return false;
    }

    public void removeField(int pointer)
    {
        removeOldField(pointer);
        switch (curType)
        {
            case 0 -> {
                emailField[pointer] = null;
            }
            case 1 -> {
                RFCField[pointer] = null;
            }
            case 2 -> {
                phoneField[pointer] = null;
            }
        }
        arrayPointer--;
        if (arrayPointer < 0) {
            setRButtons(true);
            return;
        }

    }

    public void addNewField(int selection)
    {
        switch (selection)
        {
            case 0 -> {
                emailField[arrayPointer] = new CaptureEmail();
                fieldsview.add(emailField[arrayPointer]);
            }
            case 1 -> {
                RFCField[arrayPointer] = new CaptureRFC();
                fieldsview.add(RFCField[arrayPointer]);
            }
            case 2 -> {
                phoneField[arrayPointer] = new CapturePhone();
                fieldsview.add(phoneField[arrayPointer]);
            }
        }
    }

    public void removeOldField(int pointer)
    {
        switch(curType)
        {
            case 0 -> {
                fieldsview.remove(emailField[pointer]);
            }
            case 1 -> {
                fieldsview.remove(RFCField[pointer]);
            }
            case 2 -> {
                fieldsview.remove(phoneField[pointer]);
            }
        }
        fieldsview.remove(deleteFieldBtn[pointer]);
    }

    public void resizePanel()
    {
        changePositions();
        revalidate();
        repaint();
    }

    public void resizeLayout()
    {
        int w = getWidth();
        int x = (int)(w * 0.10);
        email.setBounds(x, email.getY(), email.getWidth(), email.getHeight());
        x = (int)(w * 0.38);
        rfc.setBounds(x, rfc.getY(), rfc.getWidth(), rfc.getHeight());
        x = (int)(w * 0.65);
        phone.setBounds(x, phone.getY(), phone.getWidth(), phone.getHeight());

        x = (int)(w * 0.01);
        int width = (int)(w * 0.97);
        newFieldButton.setBounds(x, newFieldButton.getY(), width, newFieldButton.getHeight());

        fieldsview.setBounds(x, fieldsview.getY(), width, fieldsview.getHeight());
    }

    void changePositions()
    {
        if (arrayPointer < 0)
            return;

        switch (curType)
        {
            case 0 -> {
                int percent = 100 / (emailField.length + 1);
                for (int i = 0; i < emailField.length; i++) {
                    if(emailField[i] == null) continue;
                    int[] position = {4, Utils.valuePercent(fieldsview.getHeight(), (percent * i))};
                    int[] size = {Utils.valuePercent(fieldsview.getWidth(), 60), Utils.valuePercent(fieldsview.getHeight(), percent)};

                    emailField[i].setBounds(position[0], position[1], size[0], size[1]);

                    position[0] = Utils.valuePercent(fieldsview.getWidth(), 60);
                    size[0] = Utils.valuePercent(fieldsview.getWidth(), 15);

                    deleteFieldBtn[i].setBounds(position[0], position[1], size[0], size[1]);
                }
            }
            case 1 -> {
                int percent = 100 / (RFCField.length + 1);
                for (int i = 0; i < RFCField.length; i++) {
                    if(RFCField[i] == null) continue;
                    int[] position = {4, Utils.valuePercent(fieldsview.getHeight(), (percent * i))};
                    int[] size = {Utils.valuePercent(fieldsview.getWidth(), 60), Utils.valuePercent(fieldsview.getHeight(), percent)};

                    RFCField[i].setBounds(position[0], position[1], size[0], size[1]);

                    position[0] = Utils.valuePercent(fieldsview.getWidth(), 60);
                    size[0] = Utils.valuePercent(fieldsview.getWidth(), 15);

                    deleteFieldBtn[i].setBounds(position[0], position[1], size[0], size[1]);
                }
            }
            case 2 -> {
                int percent = 100 / (phoneField.length + 1);
                for (int i = 0; i < phoneField.length; i++) {
                    if(phoneField[i] == null) continue;
                    int[] position = {4, Utils.valuePercent(fieldsview.getHeight(), (percent * i))};
                    int[] size = {Utils.valuePercent(fieldsview.getWidth(), 60), Utils.valuePercent(fieldsview.getHeight(), percent)};

                    phoneField[i].setBounds(position[0], position[1], size[0], size[1]);

                    position[0] = Utils.valuePercent(fieldsview.getWidth(), 60);
                    size[0] = Utils.valuePercent(fieldsview.getWidth(), 15);

                    deleteFieldBtn[i].setBounds(position[0], position[1], size[0], size[1]);
                }
            }
        }
    }

    public int getSelected()
    {
        if(email.isSelected())
            return 0;
        else if(rfc.isSelected())
            return 1;
        else if(phone.isSelected())
            return 2;
        
        return -1;
    }

    public JButton getNewFieldButton() {
        return newFieldButton;
    }

    public JButton[] getDeleteFieldBtn() {
        return deleteFieldBtn;
    }

    public JPanel getFieldsview() {
        return fieldsview;
    }

    public JRadioButton getEmail() {
        return email;
    }

    public JRadioButton getRfc() {
        return rfc;
    }

    public JRadioButton getPhone() {
        return phone;
    }


    void setRButtons(boolean enable)
    {
        if(enable)
        {
            email.setEnabled(true);
            rfc.setEnabled(true);
            phone.setEnabled(true);
        }
        else
        {
            email.setEnabled(false);
            rfc.setEnabled(false);
            phone.setEnabled(false);
        }
    }

}

class Utils
{
    /**
     * Displays a popup message
     * @param msg - Message
     * @param type - Warning | Error | Question | Information (default)
     */
    public static void Alert(String msg, String type)
    {
        int msgtype;
        switch(type)
        {
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

    /**
     * Returns the percentage of a given value
     * @param value Number to be calculated
     * @param percent Example: 50% (50)
     * @return Calculated value
     */
    public static int valuePercent(int value, int percent)
    {
        return value * percent / 100;
    }
}