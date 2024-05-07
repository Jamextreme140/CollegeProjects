import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame implements ActionListener{

    Graph graph;
    Model model;
    JPanel canvas, fields;
    JTextField times;
    JLabel label1, label2;
    JButton start;

    public App()
    {
        super("Borracho");
        init();
        model = new Model(graph);
        setListeners();
    }

    public void init()
    {
        setSize(500, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new JPanel();
        graph = new Graph();
        canvas.add(graph, BorderLayout.CENTER);

        fields = new JPanel(new GridLayout(0, 2));
        label1 = new JLabel("Numero de ejecuciones", SwingConstants.CENTER);
        times = new JTextField();
        label2 = new JLabel("", SwingConstants.RIGHT);
        start = new JButton("Iniciar");
        fields.add(label1);
        fields.add(label2);
        fields.add(times);
        fields.add(start);

        add(canvas, BorderLayout.CENTER);
        add(fields, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    public void setListeners()
    {
        start.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start)
        {
            model.Simulate(Integer.parseInt(times.getText()));
            start.setEnabled(false);
        }
    }

    public static void main(String[] args) throws Exception {
        new App();
    }

}
