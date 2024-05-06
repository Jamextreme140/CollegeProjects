import javax.swing.*;

public class MainView extends JFrame
{
    JTextField integerField, binaryField, hexField;
    final int offs = 5;
    
    public MainView()
    {
        super("Convertidor Numeros");
        init();
    }

    public void init()
    {
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        integerField = new JTextField();
        integerField.setBounds((int)(this.getWidth() * 0.05), (int)(this.getHeight() * 0.05), (int)(this.getWidth() * 0.85), (int)(this.getHeight() * 0.20));
        binaryField = new JTextField();
        binaryField.setBounds((int)(this.getWidth() * 0.05), (int)(this.getHeight() * 0.30) + offs, integerField.getWidth(), integerField.getHeight());
        hexField = new JTextField();
        hexField.setBounds((int)(this.getWidth() * 0.05), (int)(this.getHeight() * 0.58) + offs, integerField.getWidth(), integerField.getHeight());

        add(integerField);
        add(binaryField);
        add(hexField);
        
        setVisible(true);
    }

    public void setListeners(Actions ctrl)
    {
        this.addComponentListener(ctrl);
        integerField.addKeyListener(ctrl);
        binaryField.addKeyListener(ctrl);
        hexField.addKeyListener(ctrl);
    }

    public void updateUI(int origin, String... fields)
    {
        switch (origin) {
            case 0 -> {
                binaryField.setText(fields[0]);
                hexField.setText(fields[1]);
            }
            case 1 -> {
                integerField.setText(fields[0]);
                hexField.setText(fields[1]);
            }
            case 2 -> {
                integerField.setText(fields[0]);
                binaryField.setText(fields[1]);
            }
        }
    }

    public void resize()
    {
        integerField.setBounds((int)(this.getWidth() * 0.05), (int)(this.getHeight() * 0.05), (int)(this.getWidth() * 0.85), (int)(this.getHeight() * 0.20));
        binaryField.setBounds((int)(this.getWidth() * 0.05), (int)(this.getHeight() * 0.30) + offs, integerField.getWidth(), integerField.getHeight());
        hexField.setBounds((int)(this.getWidth() * 0.05), (int)(this.getHeight() * 0.58) + offs, integerField.getWidth(), integerField.getHeight());
        revalidate();
        repaint();
    }

    public JTextField getIntegerField() {
        return integerField;
    }

    public JTextField getBinaryField() {
        return binaryField;
    }

    public JTextField getHexField() {
        return hexField;
    }

    
}
