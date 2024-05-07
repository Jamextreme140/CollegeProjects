import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;
import java.text.DecimalFormat;
import utils.PrintTable;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;

public class App extends JFrame implements ActionListener{

    JPanel fields, chart, tableviewContainer;
    JScrollPane tableview;
    JTable table;
    JFormattedTextField w, ca;
    JLabel askWeight, askAir;
    JButton start;

    Vector<Vector<String>> rows = new Vector<Vector<String>>();
    Vector<String> row = new Vector<String>();
    Vector<String> columns = new Vector<String>();

    final float g = 9.81f;
    DecimalFormat df = new DecimalFormat("0.0000");

    public App()
    {
        super("Simulacion - Caida de paracaidista");
        init();
        addListeners();
    }

    public void init()
    {
        setSize(900, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        UIManager.put("Label.font", new Font("Tahoma", Font.BOLD, 14));

        fields = new JPanel(new GridLayout(0,2, 5, 5));
        askWeight = new JLabel("Peso del paracaidista: ");
        askWeight.setHorizontalAlignment(JLabel.RIGHT);
        askAir = new JLabel("Coeficiente de la resistencia del Aire: ");
        askAir.setHorizontalAlignment(JLabel.RIGHT);
        w = new JFormattedTextField();
        w.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        ca = new JFormattedTextField();
        ca.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        start = new JButton("Simular");
        fields.add(askWeight);
        fields.add(w);
        fields.add(askAir);
        fields.add(ca);
        fields.add(start);
        add(fields, BorderLayout.NORTH);

        chart = new JPanel();
        add(chart, BorderLayout.CENTER);

        tableviewContainer = new JPanel();
        add(tableviewContainer, BorderLayout.EAST);

        setVisible(true);
    }

    public void addListeners()
    {
        w.addActionListener(this);
        ca.addActionListener(this);
        start.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == w)
        {
            ca.requestFocus();
        }
        else if (e.getSource() == start || e.getSource() == ca) {
            if (w.getText() != null && ca.getText() != null) {
                DefaultCategoryDataset data = new DefaultCategoryDataset();

                float m = Float.parseFloat(w.getText());
                float c = Float.parseFloat(ca.getText());
                int t = 0;
                String t1 = "0";
                String t2 = "1";
                double v = 0;
                double vi = 0;

                columns.addElement("Tiempo");
                columns.addElement("Velocidad");

                PrintTable ctable = new PrintTable();

                while (!t1.equals(t2)) {
                    v = ((g * m) / c) * (1 - Math.pow(Math.E, -((c / m) * t)));
                    // Se agrega el valor al dataset
                    data.setValue(v, "Tiempo", String.valueOf(t));
                    ctable.Report(t, v);
                    row.addElement(Integer.toString(t));
                    row.addElement(df.format(v));
                    rows.addElement(row);
                    row = new Vector<>();

                    t += 1;
                    vi = ((g * m) / c) * (1 - Math.pow(Math.E, -((c / m) * t)));

                    t1 = df.format(v);
                    t2 = df.format(vi);

                }
                System.out.println(
                        "La velocidad final del paracaidista es: " + v + " m/s" + System.lineSeparator() +
                                "despues de " + t + " segundos." + System.lineSeparator());

                JFreeChart graph = ChartFactory.createLineChart(
                        "Velocidad del paracaidista",
                        "Tiempo",
                        "Velocidad",
                        data,
                        PlotOrientation.VERTICAL,
                        true,
                        true,
                        false);

                ChartPanel cpanel = new ChartPanel(graph);
                cpanel.setMouseWheelEnabled(true);
                cpanel.setPreferredSize(chart.getSize());

                // jPanel1.setLayout(new BorderLayout());
                chart.add(cpanel);

                table = new JTable(rows, columns);
                tableview = new JScrollPane(table);
                tableview.setPreferredSize(new Dimension(300, tableviewContainer.getHeight()));
                table.setEnabled(false);
                tableviewContainer.add(tableview);
                
                pack();
                repaint();
                setLocationRelativeTo(null);
                JOptionPane.showMessageDialog(this,
                        "La velocidad final del paracaidista es: " + df.format(v) + " m/s " + "despues de " + t + " segundos.");
                start.setEnabled(false);
                ca.removeActionListener(this);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa los valores requeridos", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
