package backend;

import util.ToolBox;
import backend.objects.*;

public class SeaPort {
    private String name;
    private Vault curVault;

    public SeaPort(String name)
    {
        this.name = name;
        curVault = new Vault(ToolBox.randInt(60, 90));
    }

    public void saveFishOnPort(int amount)
    {
        if(curVault.isFull()) return;

        int newProduct = curVault.getCurrentCapacity() + amount;
        curVault.setCurruentCapacity((newProduct < curVault.getCapacityInKg()) ? newProduct : curVault.getCapacityInKg());
    }

    public String getName() {
        return name;
    }

    public Vault getCurVault() {
        return curVault;
    }

    
}
