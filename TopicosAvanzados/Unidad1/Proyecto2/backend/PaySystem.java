package backend;

import utils.*;
import java.util.*;

public class PaySystem {

    HashMap<String, Card> cards;
    String[] cardNumbers;
    Random rnd;

    public PaySystem()
    {
        cards = new HashMap<String, Card>();
        rnd = new Random();
        cardNumbers = doCardInfo();
    }

    public String[] doCardInfo() {
        int cardreg = rnd.nextInt(50, 100);
        String[] cardNumbers = new String[cardreg];

        for (int i = 0; i < cardreg; i++) {
            String cardNumber = buildCardNumber();
            System.out.println(cardNumber);
            cards.put(cardNumber, new Card());
            cardNumbers[i] = cardNumber;
        }

        return cardNumbers;
    }
    
    public boolean verify(String id, String typedNIP, int amount)
    {
        Card ref = cards.get(id);
        int typedAmount = amount;
        int available = ref.getAmount();

        if (typedAmount <= available && typedNIP.equals(ref.getNIP())){
            ref.discountAmount(typedAmount);
            return true;
        }
        else
            return false;
    }

    private String buildCardNumber()
    {
        String cNumber = "";
        for (int i = 0; i < 4; i++) {
            cNumber += Utils.nextFourNumbers();
        }
        return cNumber;
    }

    public String[] getCardNumbers()
    {
        return cardNumbers;
    }
    
    public Card getInfo(String id)
    {
        return cards.get(id);
    }
}
