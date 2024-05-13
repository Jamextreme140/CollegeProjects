import java.awt.event.*;

public class Controlador implements ActionListener{

    Interfaz vista;
    Modelo modelo;

    public Controlador(Interfaz vista, Modelo modelo)
    {
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.getGenerar())
        {
            int n = Integer.parseInt(vista.getnVeces());
            if(n <= 0) return;
            modelo.simular(n);
            actualizarVista();
        }
    }

    public void actualizarVista()
    {
        vista.crearTabla(modelo.getFilas(), modelo.getColumnas());
    }

}
