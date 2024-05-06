public class Backend {

    private final String hexDigits;

    public Backend()
    {   
        hexDigits = "0123456789ABCDEF";
    }

    public String binString(String text)
    {
        int n = Integer.parseInt(text);
        if(n <= 0)
            return "0";

        StringBuilder binaryString = new StringBuilder();

        while(n > 0)
        {
            int residuo = n % 2;
            binaryString.append(residuo);
            n /= 2;
        }
        binaryString.reverse();

        return binaryString.toString();
    }

    public String hexString(String text)
    {
        int n = Integer.parseInt(text);

        if(n <= 0)
            return "0";

        String hexString = "";
        while (n > 0)
        {
            int residuo = n % 16;
            hexString = hexDigits.charAt(residuo) + hexString;
            n /= 16;
        }
        return hexString;
    }

    public String intString(String text, int type)
    {
        int curNumber = 0;
        switch (type)
        {
            case 2 -> {
                curNumber = Integer.parseInt(text, type);
            }
            case 16 -> {
                curNumber = Integer.parseInt(text, type);
            }
        }
        return Integer.toString(curNumber);
    }
}
