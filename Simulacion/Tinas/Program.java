import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Program extends JFrame{
    
    JPanel fieldsPanel, tablePanel;
    JTable table;
    JScrollPane tableview;
    JButton generate;
    JTextField times;
    JLabel prompt;

    public Program()
    {
        super("Simulacion Tinas");
        setupUI();
    }

    void setupUI()
    {
        setSize(700, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setFields();
        setTable();
    }

    void setFields()
    {
        fieldsPanel = new JPanel(new GridLayout(0, 2, 5, 5));

        prompt = new JLabel("¿Cuantos años desea simular?: ");
        times = new JTextField();
        generate = new JButton("Simular");

        fieldsPanel.add(prompt);
        fieldsPanel.add(times);
        fieldsPanel.add(new JLabel());
        fieldsPanel.add(generate);

        add(fieldsPanel, BorderLayout.NORTH);
    }
    void setTable()
    {
        tablePanel = new JPanel();
        tableview = new JScrollPane();
        add(tableview, BorderLayout.CENTER);
    }

    public void createTable(Vector<Vector<String>> rows, Vector<String> columns)
    {
        table = new JTable(rows, columns);
        table.setEnabled(false);
        tablePanel.add(table.getTableHeader());
        tablePanel.add(table);
        tableview.setViewportView(table);
        revalidate();
        repaint();
    }

    public void setListener(ProgramControl ctrl)
    {
        generate.addActionListener(ctrl);
    }

    public JTextField getTimes() {
        return times;
    }

    public JButton getGenerate() {
        return generate;
    }

}
