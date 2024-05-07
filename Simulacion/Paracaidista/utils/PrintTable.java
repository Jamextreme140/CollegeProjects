package utils;

/**
 *
 * @author jamex
 */
public class PrintTable {
    
    String leftAlignFormat = "| %-3d |  %-9f  |%n";
    
    public PrintTable()
    {
        Header();
    }
    
    private void Header()
    {
        System.out.format("+-----+-------------+%n");
        System.out.format("|  t  |      v      |%n");
        System.out.format("+-----+-------------+%n");
    }
    
    public void Report(int t, double v)
    {
        System.out.format(leftAlignFormat, t, v);
    }
    
    public void Footer()
    {
        System.out.println("+-----+-------------+");
    }
}
