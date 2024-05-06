package backend.objects;

public class FuelTank extends Vault{

    public FuelTank(int capacity) {
        super(capacity / 2);
    }

    public int getFuelCapacity()
    {
        return super.getCapacity();
    }

    public int getCurrentFuel()
    {
        return super.getCurrentCapacity();
    }

    public void setCurrentFuel(int curFuel)
    {
        super.setCurruentCapacity(curFuel);
    }

}  
