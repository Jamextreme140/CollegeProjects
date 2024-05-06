import util.ToolBox;

public class Person {
    private int id;
    private String name;
    private int accessTokens;
    private boolean hasEntered;
    private boolean vipAccess;

    public Person(int id)
    {
        this.id = id;
        name = "";
        accessTokens = ToolBox.randInt(1000, 1500);
        hasEntered = false;
        vipAccess = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAccessTokens() {
        return accessTokens;
    }

    public boolean HasEntered() {
        return hasEntered;
    }

    public void setHasEntered() {
        hasEntered = !hasEntered;
    }

    public boolean isVipAccess() {
        return vipAccess;
    }

    public void setVipAccess(boolean vipAccess) {
        this.vipAccess = vipAccess;
    }

    public void discountToken()
    {
        if(vipAccess) return;
        else {
            accessTokens -= 1;
            System.out.println(id + " | " + accessTokens);
        }
    }
}
