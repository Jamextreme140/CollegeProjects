import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Graph extends Canvas{
    
    public Graph()
    {
        super();
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(500, 500));
    }

    public void paint(Graphics g)
    {
        super.paint(g);

        g.setColor(Color.DARK_GRAY);

        for (int x = 0; x < 500; x += 50) 
        {
            if(x == 250)
                g.setColor(Color.WHITE);
            else
                g.setColor(Color.DARK_GRAY);
            g.drawLine(x, 0, x, 500);
        }
        for (int y = 0; y < 500; y += 50)
        {
            if(y == 250)
                g.setColor(Color.WHITE);
            else
                g.setColor(Color.DARK_GRAY);
            g.drawLine(0, y, 500, y);
        }
    }

    public void drawLine(int x1, int y1, int x2, int y2)
    {
        Graphics g = this.getGraphics();
        g.setColor(Color.GREEN);
        g.drawLine(x1, y1, x2, y2);
    }

    public void drawPoint(int x2, int y2)
    {
        Graphics g = this.getGraphics();
        g.setColor(Color.YELLOW);
        g.drawRect(x2 - 4, y2 - 4, 8, 8);
    }

    public void clear()
    {
        Graphics g = this.getGraphics();
        paint(g);
    }
}
