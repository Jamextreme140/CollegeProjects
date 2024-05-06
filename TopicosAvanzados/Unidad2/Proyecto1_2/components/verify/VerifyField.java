package components.verify;

import javax.swing.*;

import components.verify.util.Utils;

import java.awt.*;

public class VerifyField extends JFrame implements SwingInitializer<ProgramControl>
{

    JTextField inputTextField;
    JRadioButton dFont, rndFont;
    ButtonGroup fontButtonGroup;
    JLabel hint;
    ImageIcon critical;

    Font defaulFont;

    public VerifyField()
    {
        super();
        init();
    }

    @Override
    public void init() {
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setupUI();
        setVisible(true);
    }

    @Override
    public void addListeners(ProgramControl ctrl) {
        dFont.addActionListener(ctrl);
        rndFont.addActionListener(ctrl);
        this.addComponentListener(ctrl);
        inputTextField.addKeyListener(ctrl);
    }

    public void resizePanel()
    {
        int w = this.getWidth();
        int iTextW = (int)(w * 0.55);
        inputTextField.setBounds(60, 60, iTextW, 30);

        iTextW = (int)(w * 0.66);
        dFont.setBounds(70 + inputTextField.getWidth(), inputTextField.getY(), 100, 15);
        rndFont.setBounds(70 + inputTextField.getWidth(), inputTextField.getY() + dFont.getHeight(), 100, 15);

        hint.setBounds(inputTextField.getX(), inputTextField.getY() - inputTextField.getHeight(), 200, 30);
    }

    public void setupUI()
    {
        dFont = new JRadioButton("Default Font");
        dFont.setActionCommand("Default");
        dFont.setSelected(true);
        
        rndFont = new JRadioButton("Random Font");
        rndFont.setActionCommand("Random");
        
        fontButtonGroup = new ButtonGroup();
        fontButtonGroup.add(dFont);
        fontButtonGroup.add(rndFont);

        inputTextField = new JTextField("Animal");
        inputTextField.selectAll();

        hint = new JLabel("");
        hint.setHorizontalAlignment(SwingConstants.LEFT);

        critical = new ImageIcon();
        
        defaulFont = inputTextField.getFont();
        
        add(inputTextField);
        add(rndFont);
        add(dFont);
        add(hint);
        resizePanel();
    }

    public void showImage(String filename)
    {
        critical = Utils.createImageIcon(filename, 128, 50);
        hint.setIcon(critical);
        revalidate();
        repaint();
    }

    public void closeImage()
    {
        critical = new ImageIcon();
        hint.setIcon(critical);
        revalidate();
        repaint();
    }

    public void setLabel(String text)
    {
        hint.setText(text);
    }

    public Font getDefaulFont() {
        return defaulFont;
    }

    public Font getRandFont() {
        
        return Utils.nextFont();
    }

    public JTextField getInputTextField() {
        return inputTextField;
    }

}
