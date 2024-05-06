package backend;
import java.util.Random;

public class Card {
    
    private int amount;
    private String NIP;

    public Card()
    {
        Random rnd = new Random();
        amount = rnd.nextInt(1000, 10000);
        System.out.println("$" + amount);
        //int curNIP = rnd.nextInt(9999);
        //NIP = String.format("%04d", curNIP);
        NIP = "1234";
        System.out.println(NIP);
    }

    public int getAmount()
    {
        return amount;
    }
    
    public void discountAmount(int newAmount)
    {
        amount -= newAmount;
    }

    public String getNIP()
    {
        return NIP;
    }
}
