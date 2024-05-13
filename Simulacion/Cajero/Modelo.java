import java.util.Vector;

public class Modelo {
    
    private Vector<String> datos;
    private Vector<Vector<String>> filas;
    private Vector<String> columnas;

    public Modelo()
    {
        columnas = new Vector<String>();
        crearColumnas();
        filas = new Vector<>();
    }
    // headers = ["Usuario", "#ran", "T. llegada", "M. llegada", "T. Inicio", "T. Espera", "#ran2", "Op.", "T. Op.", "T. Termina"]
    public void crearColumnas()
    {
        columnas.addElement("Usuario");
        columnas.addElement("#RAN");
        columnas.addElement("T. Llegada");
        columnas.addElement("M. llegada");
        columnas.addElement("T. Inicio");
        columnas.addElement("T. Espera");
        columnas.addElement("#RAN2");
        columnas.addElement("Op.");
        columnas.addElement("T. Op.");
        columnas.addElement("T. Termina");
    }

    public void simular(int n)
    {
        for (int i = 0; i < n; i++) 
        {
            datos = new Vector<>();
            imprimirEspacio(i);
            Vector<Double> tet = new Vector<>();
            int to = 0; // Tiempo de operacion
            double tll = 0, // Tiempo entre llegada
            mll = 0, // Momento de llegada
            millant = 0, // Mll anterior
            ti = 0, // Tiempo inicia servicio
            te = 0, // Tiempo espera/atencion
            tt = 0; // Tiempo termina servicio
            String op = ""; // Operacion
            for (int j = 0; j < 100; j++) 
            {
                double ran = Math.random();
                tll = (-Math.log(1 - ran) / 30) * 60;
                if (j == 0) // Primera iteración 
                {
                    millant = mll;
                    mll = tll;
                    ti = tll;
                }
                else
                {
                    millant = mll;
                    mll = millant + tll;
                    ti = tt;
                }
                te = ti - mll; // Tiempo de espera
                double ran2 = Math.random();
                if(ran < 0.25)
                {
                    op = "Consulta";
                    to = 80;
                }
                else if(ran > 0.25 && ran < 0.5)
                {
                    op = "Otros";
                    to = 50;
                }
                else if(ran > 0.5 && ran < 0.85)
                {
                    op = "Retiro";
                    to = 120;
                }
                else
                {
                    op = "Transferencia";
                    to = 60;
                }
                tt = ti + to;
                // data = [j + 1, ran, tll, mll, ti, te, ran2, op, to, tt]
                datos = new Vector<>();
                datos.addElement(Integer.toString(j+1));
                datos.addElement(Double.toString(ran));
                datos.addElement(Double.toString(tll));
                datos.addElement(Double.toString(mll));
                datos.addElement(Double.toString(ti));
                datos.addElement(Double.toString(te));
                datos.addElement(Double.toString(ran2));
                datos.addElement(op);
                datos.addElement(Integer.toString(to));
                datos.addElement(Double.toString(tt));

                filas.addElement(datos);
                tet.addElement(te);
            }
            datos = new Vector<>();
            imprimirFinal(tet);
        }
    }

    public void imprimirEspacio(int n)
    {
        datos.addElement("Simulacion #" + (n+1));
        datos.addElement("---------");
        datos.addElement("---------");
        datos.addElement("---------");
        datos.addElement("---------");
        datos.addElement("---------");
        datos.addElement("---------");
        datos.addElement("---------");
        datos.addElement("---------");
        datos.addElement("---------");
        filas.addElement(datos);
    }

    public void imprimirFinal(Vector<Double> ns)
    {
        double sum = 0;
        for (Double n : ns) {
            sum += n;
        }
        
        datos.addElement("T. Espera Total");
        datos.addElement(Double.toString(sum/3600));
        datos.addElement("Horas");
        datos.addElement("---------");
        datos.addElement("---------");
        datos.addElement("---------");
        datos.addElement("---------");
        datos.addElement("---------");
        datos.addElement("---------");
        datos.addElement("---------");
        filas.addElement(datos);
    }

    public Vector<Vector<String>> getFilas() {
        return filas;
    }
    public Vector<String> getColumnas() {
        return columnas;
    }
}
