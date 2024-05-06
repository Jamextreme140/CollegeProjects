package backend;

import util.ToolBox;
import backend.objects.*;

public class Ship {
    Vault curVault;
    FuelTank curTank;

    public Ship()
    {
        curVault = new Vault(ToolBox.randInt(60, 90));
        curTank = new FuelTank(curVault.getCapacity());
    }

    public int catchFish()
    {
        return ToolBox.randInt(20000, 30000); // Kg
    }

    public void saveFish(int amount)
    {
        if (curVault.isFull()) return;
        
        curVault.setCurruentCapacity(curVault.getCurrentCapacity() + amount);
    }

    public boolean is70full()
    {
        return curVault.getCurrentCapacity() >= curVault.getCapacityInKg() * 0.7;
    }

    public void fillTank()
    {
        int fuel = curTank.getCapacity() * ToolBox.randInt(90, 95) / 100;

        int newfuel = (curTank.getCurrentFuel() < fuel) ? fuel : curTank.getCurrentFuel();

        curTank.setCurrentFuel(newfuel);
    }

    public void useFuel()
    {
        curTank.setCurrentFuel(curTank.getCurrentFuel() - (int)(curTank.getFuelCapacity() * .10));
    }

    public void emptyVault()
    {
        curVault.setCurruentCapacity(0);
    }

    public Vault getCurVault() {
        return curVault;
    }

    public FuelTank getCurTank() {
        return curTank;
    }
}
