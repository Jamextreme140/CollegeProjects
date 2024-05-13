import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Interfaz extends JFrame{

    JPanel campos, tablaPanel;
    JTable tabla;
    JScrollPane vistaTabla;
    JLabel pregunta;
    JTextField nVeces;
    JButton generar;

    public Interfaz()
    {
        super("Simulación - Cajero");
        init();
    }

    public void init()
    {
        setSize(700, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        crearCampos();
        crearTablaPanel();

    }

    public void crearCampos()
    {
        campos = new JPanel(new GridLayout(0, 2, 5, 5));

        pregunta = new JLabel("Numero de simulaciones a realizar: ", JLabel.RIGHT);
        nVeces = new JTextField();
        generar = new JButton("Simular");
        campos.add(pregunta);
        campos.add(nVeces);
        campos.add(new JLabel());
        campos.add(generar);
        add(campos, BorderLayout.NORTH);
    }

    public void crearTablaPanel()
    {
        tablaPanel = new JPanel();
        vistaTabla = new JScrollPane();
        add(vistaTabla, BorderLayout.CENTER);
    }

    public void crearTabla(Vector<Vector<String>> filas, Vector<String> columnas)
    {
        tabla = new JTable(filas, columnas);
        tabla.setEnabled(false);
        tablaPanel.add(tabla.getTableHeader());
        tablaPanel.add(tabla);
        vistaTabla.setViewportView(tabla);
        revalidate();
        repaint();
    }

    public void creaEscuchas(Controlador ctrl)
    {
        generar.addActionListener(ctrl);
    }

    public void mostrarInterfaz()
    {
        setVisible(true);
    }

    public String getnVeces() {
        return nVeces.getText();
    }

    public JButton getGenerar() {
        return generar;
    }

}
