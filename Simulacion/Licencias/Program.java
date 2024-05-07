import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.util.Vector;

public class Program extends JFrame
{
    
    JPanel fieldsPanel, tablePanel;
    JTable table;
    JTableHeader headers;
    JScrollPane tableview;
    JButton generate;
    JTextField times, licenses;
    JLabel prompt1, prompt2, result;

    public Program()
    {
        super("Licencias");
        init();
    }

    public void init()
    {
        setSize(960, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setFields();
        setTable();
        setVisible(true);
    }

    public void setFields()
    {
        fieldsPanel = new JPanel(new GridLayout(0, 2, 5, 5));

        prompt1 = new JLabel("¿Cuantas veces desea realizar la simulación?", SwingConstants.RIGHT);
        times = new JTextField();
        prompt2 = new JLabel("¿Cuantas licencias desea comprar?", SwingConstants.RIGHT);
        licenses = new JTextField();
        result = new JLabel("", SwingConstants.CENTER);
        generate = new JButton("Generar");

        fieldsPanel.add(prompt1);
        fieldsPanel.add(times);
        fieldsPanel.add(prompt2);
        fieldsPanel.add(licenses);
        fieldsPanel.add(result);
        fieldsPanel.add(generate);
        add(fieldsPanel, BorderLayout.NORTH);
    }

    public void setTable()
    {
        tablePanel = new JPanel();
        tableview = new JScrollPane();
        add(tableview, BorderLayout.CENTER);
    }

    public void createTable(Vector<Vector<String>> rows, Vector<String> columns)
    {
        table = new JTable(rows, columns);
        tablePanel.add(table.getTableHeader());
        tablePanel.add(table);
        tableview.setViewportView(table);
        revalidate();
        repaint();
    }

    public void setMediaVarianza(String text)
    {
        result.setText(text);
        revalidate();
        repaint();
    }

    public void setListeners(ProgramControl ctrl)
    {
        generate.addActionListener(ctrl);
    }

    public JButton getGenerate() {
        return generate;
    }

    public JTextField getTimes() {
        return times;
    }

    public JTextField getLicenses() {
        return licenses;
    }
}
