import java.util.Scanner;
import java.util.Vector;

public class App {

    static Scanner read;
    static String tableFormat = " %-3d | %-5s | %-7s | %-5s | %-5s |%n";
    static String tableHeaders = "  n  |  #ran |Semilla^2| N.Int | Sig.N |%n";
    
    public static void main(String[] args) {
        read = new Scanner(System.in);

        Vector<String> exclude = new Vector<String>();
        
        while(true)
        {
            int media = 0, sum = 0;
            Vector<Double> varianza = new Vector<Double>();
            double var = 0;
            
            System.out.println("Ingrese una semilla a no más de 3 digitos: ");
            String seed = read.next();
            if(seed.length() > 3)
            {
                System.out.println("Error: debe ingresar una semilla no mayor a 3 digitos");
                continue;
            }
            seed = addZeros(seed, 3);
            String powNumber, nextNumber;
            int i = 0;
            int n1, n2;
            int seedLenght = seed.length();
            int sl2, firstChar;

            n1 = Integer.parseInt(seed);
            System.out.format(tableHeaders);
            do
            {
                n2 = (int)Math.pow(n1, 2);
                if(n2 == 0) break;

                powNumber = Integer.toString(n2);
                if(powNumber.length() % 2 == 0)
                    powNumber = addZeros(powNumber, powNumber.length() + 1);
                else if(powNumber.length() < 3)
                    powNumber = addZeros(powNumber, 3);
                
                sl2 = powNumber.length();
                //Determina el caracter de inicio a tomar
                firstChar = (sl2 - seedLenght) / 2;
                //Saca los 3 caracteres (digitos) del numero elevado al cuadrado
                nextNumber = powNumber.substring(firstChar, firstChar + seedLenght);

                if(Search(exclude, nextNumber) && i > 4) break;
                exclude.add(nextNumber);

                sum += Integer.parseInt(nextNumber);
                varianza.add(Double.parseDouble(nextNumber));

                System.out.printf(tableFormat, i, seed, powNumber, nextNumber, nextNumber);

                n1 = Integer.parseInt(nextNumber);
                seed = nextNumber;

                i++;
                if(n1 == n2) break;
            }while(n2 != 0);

            media = (sum / i);
            var = Varianza(varianza.toArray(new Double[varianza.size()]), media);
            System.out.printf("Media: %d | Varianza: %-8.5f |%n", media, var);

            System.out.println("¿Seguir ejecutando?");
            String exit = read.next();
            if(exit.toLowerCase().equals("no")) break;
            exclude.clear();
        }
        System.out.println("Fin del programa");
    }

    public static boolean Search(Vector<String> sd, String value)
    {
        for(String str : sd)
        {
            if(str.equalsIgnoreCase(value)) return true;
        }
        return false;
    }

    public static double Varianza(Double[] v, int media)
    {
        double m = media;
        double sum = 0;
        for (int i = 0; i < v.length; i++) {
            sum += Math.pow(v[i], 2f);
        }
        return sum/v.length-Math.pow(m, 2f);
    }

    public static String addZeros(String str, int num)
    {
        while(str.length() < num) str = "0" + str;
        return str;
    }
}
