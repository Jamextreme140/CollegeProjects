import javax.swing.JOptionPane;

public class Model {

    int n;
    Graph c;
    int cuadras = 0;
    int exito = 0;
    int count = 0;
    float prob;

    public Model(Graph c)
    {
        this.c = c;
    }

    public void Simulate(int n)
    {
        this.n = n;

        for (int i = 0; i < n; i++) 
        {
            System.out.print("\t#" + (i+1));
            System.out.println("");
            
            int posX = 250;
            int posY = 250;
            int traceX = 0;
            int traceY = 0;

            System.out.format("|  N  |  Localizacion   |#de cuadras caminadas|#aleGen|%n");
            for (int j = 0; j < 10; j++) {
                
                if (j > 0) {
                    posX = traceX;
                    posY = traceY;
                }

                double ran = Math.random();
                if (ran < 0.25) {
                    traceX = posX;
                    traceY = posY + 50;
                } else if (ran > 0.25 && ran < 0.50) {
                    traceX = posX;
                    traceY = posY - 50;
                } else if (ran > 0.50 && ran < 0.75) {
                    traceX = posX + 50;
                    traceY = posY;
                } else {
                    traceX = posX - 50;
                    traceY = posY;
                }

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    System.err.println("Error: " + e.getMessage());
                }

                c.drawLine(posX, posY, traceX, traceY);
                if(j == 9)
                    c.drawPoint(traceX, traceY);
                cuadras++;
                System.out.printf("| %5d | X: %3d - Y: %3d | %2d | %.4f  |%n", j + 1, traceX, traceY, cuadras, ran);
            }

            exito = ((posX + posY) - (250 + 250)) / 50;

            if(exito >= 2 || exito <= -2)
            {
                System.out.println("El borracho caminó: " + exito + " Cuadras");
                System.out.println("Exito");
                count++;
            }
            else
            {
                System.out.println("El borracho caminó: " + exito + " Cuadras");
                System.out.println("Fracaso");
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Error: " + e.getMessage());
            }
            if(i < (n - 1))
                c.clear();
        }

        prob = ((float)count / (float)n) * 100f;

        System.out.println("La probabilidad de que el borracho quede a 2 cuadras o mas es de " + prob + "%");
        JOptionPane.showMessageDialog(null,
                "La probabilidad de que el borracho\nquede a 2 cuadras o mas es de " + prob + "%",
                "Simulacion finalizada", JOptionPane.INFORMATION_MESSAGE);
    }
}
