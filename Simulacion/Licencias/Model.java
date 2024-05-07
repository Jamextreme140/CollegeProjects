import java.util.Vector;

public class Model {

    Vector<String> row;
    Vector<Vector<String>> data;
    Vector<String> columns;
    Double media, varianza;
    double[] arrVarianza;

    public Model()
    {
        columns = new Vector<String>();
        setColumns();
        data = new Vector<>();
    }

    public void setColumns()
    {
        columns.addElement("N");
        columns.addElement("#ran");
        columns.addElement("Licencias vendidas");
        columns.addElement("Licencias devueltas");
        columns.addElement("Costo");
        columns.addElement("Ing x venta");
        columns.addElement("Ing x Dev.");
        columns.addElement("Utilidad");
    }

    public void simulate(int n, int l)
    {
        arrVarianza = new double[n];
        double sum = 0;
        for(int i = 0; i < n; i++)
        {
            row = new Vector<>();
            double rnd = Math.random();
            int lic;
            int licdev;
            int cost;
            int ingvta;
            int ingdev;
            int utility;
            if(rnd < 0.30)
                lic = 100;
            else if(rnd > 0.30 && rnd < 0.50)
                lic = 150;
            else if(rnd > 0.50 && rnd < 0.80)
                lic = 200;
            else if(rnd > 0.80 && rnd < 0.95)
                lic = 250;
            else 
                lic = 300;
            // Si el valor generado excede las licencias compradas
            if(lic > l)
                lic = l;
            // Lic. devueltas: diferencia de licencia vendidias por las compradas
            licdev = l - lic;

            cost = l * 75;

            ingvta = lic * 100;
            ingdev = lic * 25;
            utility = (ingvta + ingdev) - cost;

            //Media
            sum += utility;

            arrVarianza[i] = utility;

            row.addElement(Integer.toString(i+1));
            row.addElement(Double.toString(rnd));
            row.addElement(Integer.toString(lic));
            row.addElement(Integer.toString(licdev));
            row.addElement(Integer.toString(cost));
            row.addElement(Integer.toString(ingvta));
            row.addElement(Integer.toString(ingdev));
            row.addElement(Integer.toString(utility));

            data.addElement(row);
        }
        media = (sum / n);
        varianza = Varianza(arrVarianza);
    }

    public double Varianza(double[] v)
    {
        double m = media;
        double sum = 0;
        for (int i = 0; i < v.length; i++) {
            sum += Math.pow(v[i], 2f);
        }

        return sum/v.length-Math.pow(m, 2f);
    }

    public Vector<Vector<String>> getData() {
        return data;
    }

    public Vector<String> getColumns() {
        return columns;
    }

    public Double getMedia() {
        return media;
    }

    public Double getVarianza() {
        return varianza;
    }
}
