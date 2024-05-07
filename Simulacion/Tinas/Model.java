import java.util.Vector;

public class Model {

    Vector<String> row;
    Vector<Vector<String>> data;
    Vector<String> columns;
    int dias = 260;
    double t_cost = 50000;
    
    public Model()
    {
        columns = new Vector<String>();
        setColumns();
        data = new Vector<>();
    }

    public void setColumns()
    {
        columns.addElement("N");
        columns.addElement("Tina");
        columns.addElement("#ran");
        columns.addElement("Peso simulado");
        columns.addElement("P. S. Acumulado");
        columns.addElement("Exc. Capacidad?");
        columns.addElement("Si si, Acumula $200");
    }

    public void simular(int n)
    {
        double p = 0; //Peso 
        double pa = 0; //Peso acumulado
        boolean exc = false; // Excede capacidad
        double cost = 0; //Si si, acumula $200
        double cost_anual;
        
        for (int i = 0; i < n; i++) { // Cada año
            row = new Vector<>();
            row.addElement("Año " + (i+1));
            row.addElement("-----");
            row.addElement("-----");
            row.addElement("-----");
            row.addElement("-----");
            row.addElement("-----");
            row.addElement("-----");
            data.addElement(row);
            for (int j = 0; j < dias; j++) { // Cada 260 dias
                for (int k = 0; k < 5; k++) { // Cada tina

                    double ran = Math.random();
                    if(ran < 0.5)
                        p = 190 + Math.sqrt(800 * ran);
                    else if(ran == 0.5)
                        p = 210;
                    else
                        p = 230 - Math.sqrt(800 * (1 - ran));
                    
                    pa += p; // Suma al peso acumulado

                    // Si excede la tonelada, se le suman $200
                    if(pa > 1000)
                        exc = true;
                    if(exc)
                        cost += 200;
                    
                    row = new Vector<>();
                    row.addElement(Integer.toString(j + 1));
                    row.addElement(Integer.toString(k + 1));
                    row.addElement(Double.toString(ran));
                    row.addElement(Double.toString(Math.round(p)));
                    row.addElement(Double.toString(Math.round(pa)));
                    row.addElement(exc ? "Si" : "No");
                    row.addElement(Double.toString(cost));
                    data.addElement(row);
                    exc = false;
                }
                pa = 0;
            }
            cost_anual = cost / (i+1);
            if(i==n)
                System.out.println((i+1) + " [FINAL] - Costo promedio anual: $" + cost_anual);
            else
                System.out.println((i+1) + " - Costo promedio anual: $" + cost_anual);
            System.out.println(" - Costo promedio anual por camion nuevo: " + t_cost);

            if (cost_anual < t_cost)
                System.out.println("Opcion -> Rentar");
            else
                System.out.println("Opcion -> Comprar");
            cost = 0;
        }
    }

    public Vector<Vector<String>> getData() {
        return data;
    }
    public Vector<String> getColumns() {
        return columns;
    }
}
